package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.chat.Chat;
import com.sunsigne.rebeccasreleasing.game.world.mapcreator.MapCreator;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseInput;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerRender;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.GUI;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.characters.living.PlayerObject;

public class World implements IRender {

	private ILvl ilvl;
	private Chat chat;
	private boolean npcRequested;

	public static World currentWorld;

	public static GUI gui = new GUI();

	public World(ILvl ilvl) {
		this.ilvl = ilvl;
		ilvl.loadEvent();
		HandlerRender.getInstance().addObject(this);

		loadLevel();
		SoundTask.playMusic(0.5, SoundBank.getSound(SoundBank.level));
	}

	@Override
	public boolean isCameraDependant() {
		return true;
	}

	public ILvl getILvl() {
		return ilvl;
	}

	public static void loadChat(Chat chat) {
		if (currentWorld != null)
			currentWorld.chat = chat;
	}

	public static Chat getChat() {
		if (currentWorld != null)
			return currentWorld.chat;
		else
			return null;
	}

	public static void killChat() {
		if (currentWorld != null)
			currentWorld.chat = null;
	}

	public static boolean isNpcRequested() {
		return (currentWorld != null ? currentWorld.npcRequested : false);
	}

	public static void setNpcRequested(boolean requested) {
		if (currentWorld != null)
			currentWorld.npcRequested = requested;
	}

	private void loadLevel() {

		MapCreator.createLevel(ilvl.getLvlImage());
		Game.game.forceLoop();
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
		killChat();
	}

}
