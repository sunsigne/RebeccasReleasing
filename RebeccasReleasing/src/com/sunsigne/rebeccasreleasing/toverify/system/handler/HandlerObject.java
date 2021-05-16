package com.sunsigne.rebeccasreleasing.toverify.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;

import objects.GameObject;
import objects.characters.living.PlayerObject;

public class HandlerObject implements ITick, IRender {

	public HandlerObject() {

		for (int i = 0; i < 3; i++) {
			handler_object_list[0][i] = new LinkedList<GameObject>();
			handler_object_list[1][i] = new LinkedList<GameObject>();
		}

		HandlerTick.getInstance().addObject(this);
		for (int i = 0; i < 3; i++) {
			HandlerRender.getInstance().addObject(true, i, this);
			HandlerRender.getInstance().addObject(false, i, this);
		}

//		HandlerRender.getInstance().addObject(true, this);
//		HandlerRender.getInstance().addObject(false, this);
	}

	////////// SIGNELTON ////////////

	private static HandlerObject instance = null;

	public static HandlerObject getInstance() {
		if (instance == null)
			instance = new HandlerObject();
		return instance;
	}

	////////// MAP OR LIST ////////////

	@SuppressWarnings("unchecked")
	private static LinkedList<GameObject>[][] handler_object_list = new LinkedList[2][3]; // - cameraDependency - layer
	// layer 0 - hp&tools & puzzle
	// layer 1 - dialogues
	// layer 2 - menu

	public LinkedList<GameObject> getList(boolean cameraDependant, int layer) {
		int cameraDependency = cameraDependant ? 1 : 0;
		return handler_object_list[cameraDependency][layer];
	}

	public void addObject(GameObject object) {
		if (object != null) {
			LinkedList<GameObject> list = getList(object.isCameraDependant(), object.getCameraLayer());
			list.add(object);
		}
	}

	public void removeObject(GameObject object) {
		if (object != null) {
			LinkedList<GameObject> list = getList(object.isCameraDependant(), object.getCameraLayer());
			list.remove(object);
		}
	}

	public void clear(boolean cameraDependant, int cameraLayer) {
		getList(cameraDependant, cameraLayer).clear();
		if (!cameraDependant && cameraLayer == 1)
			setVirusExisting(false);
	}

	public void clearAll() {
		setVirusExisting(false);
		setPlayerExisting(false);
		for (int i = 0; i < 3; i++) {
			handler_object_list[0][i].clear();
			handler_object_list[1][i].clear();
		}
	}

	////////// STATE ////////////

	private PlayerObject player = new PlayerObject(0, 0);
	private boolean isPlayerExisting, isVirusExisting;

	@Override
	public boolean isCameraDependant() {
		return HandlerRender.getInstance().isCameraDependant();
	}

	@Override
	public int getCameraLayer() {
		return HandlerRender.getInstance().getCameraLayer();
	}

	public boolean isVirusExisting() {
		return isVirusExisting;
	}

	public void setVirusExisting(boolean isVirusExisting) {
		this.isVirusExisting = isVirusExisting;
	}

	public boolean isPlayerExisting() {
		return isPlayerExisting;
	}

	public void setPlayerExisting(boolean isPlayerExisting) {
		this.isPlayerExisting = isPlayerExisting;
	}

	public PlayerObject getPlayer() {
		return player;
	}

	public void resetPlayer() {
		player = new PlayerObject(0, 0);
	}

	public GameObject getObjectAtPos(int cameraLayer, int x, int y) {
		for (GameObject tempObject : handler_object_list[0][cameraLayer]) {
			if (tempObject.getX() == x && tempObject.getY() == y) {
				return tempObject;
			}
		}
		return null;
	}

	////////// BEHAVIOR ////////////

	@Override
	public void tick() {

		LinkedList<GameObject> list = null;
		for (int cameraLayer = 0; cameraLayer < 3; cameraLayer++) {

			list = getList(true, cameraLayer);
			for (GameObject tempObject : list)
				tempObject.tick();

			list = getList(false, cameraLayer);
			for (GameObject tempObject : list)
				tempObject.tick();
		}
	}

	@Override
	public void render(Graphics g) {

		LinkedList<GameObject> list = getList(isCameraDependant(), getCameraLayer());

		for (GameObject tempObject : list)
			tempObject.render(g);

		if (Game.isDebugMode()) {
			for (GameObject tempObject : list)
				tempObject.drawHitbox(g);
		}
	}

}
