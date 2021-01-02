package com.sunsigne.rebeccasreleasing.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferStrategy;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.game.puzzles.normal.PuzzleHack;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.system.Camera;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.GameKeyboardListener;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;

import tofinish.TextureBank;

/**
 * Supervise the global running of the application. This class is the one that :
 * start the app, instance all important componants, and run the main loops
 * (including its visual interface)
 * 
 * @author casqu
 * @version 0.1
 */
public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final Camera cam = new Camera();

	public static final String NAME = "Rebecca's Releasing";
	public static final boolean visibleHitbox = false;
	
	public static Game game;
	
	private Thread thread;
	private boolean running;

	public static void main(String args[]) {

		new Game();
	}

	public Game() {

		
		
		game = this;
		Conductor.state = STATE.LOADING;
		Options.loadLanguage();
		new ImageBank().loadRessources();
		new AudioBank().loadRessources();
		TextureBank.getInstance().loadRessources();

		this.addKeyListener(new GameKeyboardListener());
		this.addMouseListener(GameMouseListener.getInstance());
		new Window(game);

		Conductor.start();
	}

	// Thread

	/**
	 * Initialize and start the {@code thread}
	 */
	public synchronized void start() {
		if (running)
			return;

		running = true;
		thread = new Thread(this, NAME + "_main");
		thread.start();		
	}

	/**
	 * Ask for the {@code  thread} to stop.
	 */
	public synchronized void stop() {
		running = false;

		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Main loop of the whole application : repetively casts the method
	 * <b>tick()</b> and the method renderGame(Graphics) in <b>Render class</b>.
	 * 
	 * @see #tick()
	 * @see Render#renderGame(Graphics)
	 */
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
				} catch (Exception e) {
					// some commun lags may cause desynchronisation with some lists.
					// This throws ask for the code to just ignore them.
					// The next tick will repair it anyway.
				}
				delta--;
				shouldRender = true;
			}

			if (shouldRender) {
//				frames++;
				try {
					render();
				} catch (Exception e) {
					// Same "problem" than above.
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

	private void tick() {

		HandlerRender.getInstance().playerAbove = true;
		HandlerTick.getInstance().tick();
		GameMouseListener.getInstance().setPos(MouseInfo.getPointerInfo().getLocation());
	}

	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, Size.WIDHT, Size.HEIGHT);

		renderLayer(g, true);
		renderLayer(g, false);

		g.dispose();
		bs.show();

	}

	private void renderLayer(Graphics g, boolean cameraDependant) {
		Graphics2D g2d = (Graphics2D) g;
		if (cameraDependant)
			g2d.translate(cam.getX(), cam.getY());
		else
			g2d.translate(-cam.getX(), -cam.getY());

		HandlerRender.getInstance().render(g);
		HandlerRender.getInstance().setCameraDependant(!cameraDependant);
		refreshPlayerRender(g, cameraDependant);
	}

	private void refreshPlayerRender(Graphics g, boolean cameraDependant) {

		if (HandlerObject.getInstance().isPlayerExisting && HandlerRender.getInstance().playerAbove && cameraDependant)
			HandlerObject.getInstance().player.render(g);
		else if (HandlerObject.getInstance().isVirusExisting && !cameraDependant)
			PuzzleHack.virus.render(g);
	}

}
