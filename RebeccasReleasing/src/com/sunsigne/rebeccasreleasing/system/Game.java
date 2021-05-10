package com.sunsigne.rebeccasreleasing.system;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferStrategy;
import java.util.ConcurrentModificationException;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.game.puzzles.hack.PuzzleHack;
import com.sunsigne.rebeccasreleasing.game.puzzles.lazer.object.ColorEnigmaBank;
import com.sunsigne.rebeccasreleasing.ressources.characters.CharacterBank;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.images.TextureBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.controllers.GameKeyboardInput;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.util.Camera;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.system.util.Window;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static final Camera cam = new Camera();

	public static final String NAME = "Rebecca's Releasing";
	private static boolean debugMode = false;
	private static boolean wallPassMode = false;
	private static boolean multiToolMode = false;
	public static final boolean skipIntro = true;

	public static Game game;

	private Thread thread;
	private boolean running;

	public static void main(String args[]) {

		new Game();
	}

	public Game() {

		game = this;
		Options.loadSavedSettings();
		Conductor.setState(STATE.LOADING);
		ImageBank.loadRessources();
		SoundBank.loadRessources();
		CharacterBank.loadRessources();
		TextureBank.getInstance().loadRessources();
		new ColorEnigmaBank().loadRessources();
		
		this.addKeyListener(new GameKeyboardInput());
		this.addMouseListener(GameMouseInput.getInstance());
		new Window(game);

		Conductor.start();
	}

	// State
	
	public static boolean isDebugMode()
	{
		return debugMode;
	}
	
	public static boolean isWallPassMode()
	{
		return wallPassMode;
	}
	
	public static boolean isMultiToolMode() {
		return multiToolMode;
	}

	public static void switchDebugMode()
	{
		debugMode = debugMode ? false : true;
	}
	
	public static void switchWallPassMode()
	{
		wallPassMode = wallPassMode ? false : true;
	}
	

	public static void switchMultiToolMode() {
		multiToolMode = multiToolMode ? false : true;
	}
	
	
	// Thread

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
					// two, which may cause crash. As next tick will repair the problem,
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

	private void tick() {

		HandlerRender.getInstance().playerAbove = true;
		HandlerTick.getInstance().tick();
		GameCursor.setPos(MouseInfo.getPointerInfo().getLocation());
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
