package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.GUI;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.characters.living.PlayerObject;

public class World implements IRender {

	private ILvl ilvl;

	public static World currentWorld;

	public static GUI gui = new GUI();
	public static int levelnum;

	public World(ILvl ilvl) {
		this.ilvl = ilvl;
//		ilvl.loadEvent();
		HandlerRender.getInstance().addObject(this);
		World.levelnum = ilvl.getLvlNumber();

		SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.soundtrack_3));
		loadLevel();
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	public ILvl getILvl() {
		return ilvl;
	}


	private void loadLevel() {

		MapCreator.createLevel(ilvl.getLvlImage());
		startGUI();
		Conductor.setState(STATE.LEVEL);
	}
	

	private static void startGUI() {
		gui = new GUI();
		HandlerObject.getInstance().addObject(gui);
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
		currentWorld.close();
		currentWorld = new World(currentWorld.getILvl());
	}

	public void close() {
		
		Conductor.setState(STATE.LOADING);
		HandlerEvent.getInstance().clear();
		GameMouseInput.getInstance().clearClickable();
		HandlerObject.getInstance().player = new PlayerObject(0, 0);
		HandlerObject.getInstance().isPlayerExisting = false;
		HandlerObject.getInstance().clearAll();
		HandlerRender.getInstance().removeObject(this);
		SoundTask.stopMusic();
	}

}
