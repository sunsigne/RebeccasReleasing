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
		HandlerTick.getInstance().addObject(this);
		HandlerRender.getInstance().addObject(true, this);
		HandlerRender.getInstance().addObject(false, this);
	}

	////////// SIGNELTON ////////////

	private static HandlerObject instance = null;

	public static HandlerObject getInstance() {
		if (instance == null)
			instance = new HandlerObject();
		return instance;
	}

	////////// MAP OR LIST ////////////

	private LinkedList<GameObject> handler_object_camera_dependant_list = new LinkedList<GameObject>();
	private LinkedList<GameObject> handler_object_camera_independant_list = new LinkedList<GameObject>();

	public LinkedList<GameObject> getList(boolean cameraDependant) {
		return cameraDependant ? handler_object_camera_dependant_list : handler_object_camera_independant_list;
	}

	public GameObject getObjectAtPos(int x, int y) {
		for (GameObject tempObject : handler_object_camera_dependant_list) {
			if (tempObject.getX() == x && tempObject.getY() == y) {
				return tempObject;
			}
		}
		return null;
	}

	public void addObject(GameObject object) {
		if (object != null) {
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(object.isCameraDependant());
			list.add(object);
		}
	}

	public void removeObject(GameObject object) {
		if (object != null) {
			LinkedList<GameObject> list = HandlerObject.getInstance().getList(object.isCameraDependant());
			list.remove(object);
		}
	}

	public void clearFront() {
		setVirusExisting(false);
		this.handler_object_camera_independant_list.clear();
	}

	public void clearBack() {
		setPlayerExisting(false);
		this.handler_object_camera_dependant_list.clear();
	}

	public void clearAll() {
		clearFront();
		clearBack();
	}

	////////// STATE ////////////

	private PlayerObject player = new PlayerObject(0, 0);
	private boolean isPlayerExisting, isVirusExisting;

	@Override
	public boolean isCameraDependant() {
		return HandlerRender.getInstance().isCameraDependant();
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

	////////// BEHAVIOR ////////////

	@Override
	public void tick() {

		for (GameObject tempObject : handler_object_camera_dependant_list)
			tempObject.tick();
		for (GameObject tempObject : handler_object_camera_independant_list)
			tempObject.tick();
	}

	@Override
	public void render(Graphics g) {

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(isCameraDependant());

		for (GameObject tempObject : list)
			tempObject.render(g);

		if (Game.isDebugMode()) {
			for (GameObject tempObject : list)
				tempObject.drawHitbox(g);
		}
	}

}
