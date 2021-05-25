package com.sunsigne.rebeccasreleasing.system;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.util.ConcurrentModificationException;

import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.LAYER;
import com.sunsigne.rebeccasreleasing.system.util.Camera;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static final String NAME = "Reversed Rebecca";
	private static final Camera cam = new Camera();

	public static void main(String args[]) {
		instance = new Game();
		Conductor.startApp();
	}

	////////// SIGNELTON ////////////

	private static Game instance = null;

	public static Game getInstance() {
		return instance;
	}

	////////// THREAD ////////////

	private Thread thread;
	private boolean running;

	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this, NAME + "_main");
		thread.start();
	}

	public synchronized void stop() {
		running = false;

		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	////////// MAIN LOOP ////////////

	public void run() {

		// this line ask for keyboard priority when game starts.
		// Without this line, you need to click once on the window
		// before keyboard works.
		this.requestFocus();

		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;

//		int ticks = 0;
//		int frames = 0;

		double delta = 0;
		long timer = System.currentTimeMillis();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			boolean shouldRender = false;

			while (delta >= 1) {
//				ticks++;
				try {
					tick();

				} catch (ConcurrentModificationException e) {
					// some list are sometimes changed during a tick instead of between
					// two ticks, which may cause crash. As the next tick repair the problem,
					// no need to proccess this exception.
				} catch (Exception e) {
					e.printStackTrace();
				}
				delta--;
				shouldRender = true;
			}

			if (shouldRender) {
//				frames++;
				try {
					render();
				} catch (ConcurrentModificationException e) {
					// same problem as above
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (System.currentTimeMillis() - timer >= 1000) {
				timer += 1000;
//				System.out.println("Ticks : " + ticks + ", FPS : " + frames);
//				frames = 0;
//				ticks = 0;
			}
		}
		stop();
	}

	public void forceLoop() {
		try {
			tick();
			render();
		} catch (Exception e) {
			// same problem as above but can be more annoying.
			// Clearly, It's just better to ignore this catch
			// as this method is called very rarely.
		}
	}

	////////// TICK ////////////

	private void tick() throws Exception {
		HandlerRender.getInstance().setPlayerRenderingRefreshed(true);

		Point pos = MouseInfo.getPointerInfo().getLocation();
		new GameCursor().setPos(pos);

		HandlerTick.getInstance().tick();

	}

	////////// RENDER ////////////

	private void render() throws Exception {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);

		renderDependency(g, true);
		renderDependency(g, false);

		g.dispose();
		bs.show();

	}

	private void renderDependency(Graphics g, boolean cameraDependant) {
		Graphics2D g2d = (Graphics2D) g;
		if (cameraDependant)
			g2d.translate(cam.getX(), cam.getY());
		else
			g2d.translate(-cam.getX(), -cam.getY());

		renderLayers(g);
		if (cameraDependant)
			refreshPlayerRendering(g);
		HandlerRender.getInstance().setCameraDependant(!cameraDependant);
	}

	private void renderLayers(Graphics g) {

		for (LAYER layer : LAYER.values()) {
			HandlerRender.getInstance().setLayer(layer);
			HandlerRender.getInstance().render(g);
		}
	}

	private void refreshPlayerRendering(Graphics g) {
		if (HandlerObject.getInstance().isPlayerExisting() && HandlerRender.getInstance().isPlayerRenderingRefreshed())
			HandlerObject.getInstance().getPlayer().render(g);

	}

}
