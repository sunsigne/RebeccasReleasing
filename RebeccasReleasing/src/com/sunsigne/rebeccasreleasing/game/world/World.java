package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.event.EventLoader;
import com.sunsigne.rebeccasreleasing.game.event.IEvent;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.AudioTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.displayer.GUI;
import objects.characters.living.FoeObject;

public class World implements IRender {

	private ILvl ilvl;
	private IEvent ievent;
	private EventLoader event;

	public static World world;

	public static GUI gui = new GUI();
	public static int levelnum;

	public World(ILvl ilvl) {
		this.ilvl = ilvl;
		ievent = ilvl.getIEvent();
		event = new EventLoader(ievent);
		HandlerRender.getInstance().addObject(this);
		World.levelnum = ilvl.getLvlNumber();

		AudioTask.playMusic(0.5, AudioBank.soundtrack_3);
		loadLevel();
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	public ILvl getILvl() {
		return ilvl;
	}

	public IEvent getIEvent() {
		return ievent;
	}

	private static void startGUI() {
		gui = new GUI();
		HandlerObject.getInstance().addObject(gui);
	}

	private void loadLevel() {

		MapBuilder.createLevel(ilvl.getLvlImage());
		startGUI();
		Conductor.setState(STATE.LEVEL);
		event.start();
	}

	// level maker

	public static void stunAllFoes() {

		boolean isCameraDependant = true;
		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant);
		for (GameObject tempObject : list) {
			if (tempObject.getId() == OBJECTID.FOE)
				((FoeObject) tempObject).stun();
		}
	}

	@Override
	public void render(Graphics g) {

		BufferedImage img = ilvl.getCutoutLvlImage();
		g.drawImage(img, 0, 0, img.getWidth() * Size.TILE / 32, img.getHeight() * Size.TILE / 32, null);
	}

	public void restart() {
		world.close();
		world = new World(world.getILvl());
	}

	public void close() {

		GameMouseListener.getInstance().clearClickable();
		event.clearEvent();
		HandlerObject.getInstance().isPlayerExisting = false;
		HandlerObject.getInstance().clearAll();
		HandlerRender.getInstance().removeObject(this);
		AudioTask.stopMusic();
	}

}
