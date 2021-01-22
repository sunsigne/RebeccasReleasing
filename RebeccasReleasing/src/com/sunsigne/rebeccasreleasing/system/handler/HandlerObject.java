package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

import objects.GameObject;
import objects.characters.living.PlayerObject;

public class HandlerObject implements ITick, IRender {

	private static HandlerObject instance = null;

	public static HandlerObject getInstance() {
		if (instance == null)
			instance = new HandlerObject();
		return instance;
	}

	private LinkedList<GameObject> handler_object_camera_dependant_list = new LinkedList<GameObject>();
	private LinkedList<GameObject> handler_object_camera_independant_list = new LinkedList<GameObject>();

	public PlayerObject player = new PlayerObject(0, 0);
	public boolean isPlayerExisting, isVirusExisting;

	public HandlerObject() {
		HandlerTick.getInstance().addObject(this);
		HandlerRender.getInstance().addObject(true, this);
		HandlerRender.getInstance().addObject(false, this);
	}

	@Override
	public boolean isCameraDependant() {
		return HandlerRender.getInstance().isCameraDependant();
	}

	@Override
	public void tick() {

		for (GameObject tempObject : handler_object_camera_dependant_list)
			tempObject.tick();
		for (GameObject tempObject : handler_object_camera_independant_list)
			tempObject.tick();
	}

	@Override
	public void render(Graphics g) {

		if (isCameraDependant())
			renderCameraDependant(g);
		else
			renderCameraIndependant(g);
	}

	private void renderCameraDependant(Graphics g) {
		for (GameObject tempObject : handler_object_camera_dependant_list)
			tempObject.render(g);
	}

	private void renderCameraIndependant(Graphics g) {
		for (GameObject tempObject : handler_object_camera_independant_list)
			tempObject.render(g);
	}

	public LinkedList<GameObject> getList(boolean cameraDependant) {
		if (cameraDependant)
			return this.handler_object_camera_dependant_list;
		else
			return this.handler_object_camera_independant_list;
	}

	public void addObject(GameObject object) {
		if (object != null) {
			if (object.isCameraDependant())
				HandlerObject.getInstance().handler_object_camera_dependant_list.add(object);
			else
				HandlerObject.getInstance().handler_object_camera_independant_list.add(object);
		}
	}

	public void removeObject(GameObject object) {
		if (object != null) {
			if (object.isCameraDependant())
				HandlerObject.getInstance().handler_object_camera_dependant_list.remove(object);
			else
				HandlerObject.getInstance().handler_object_camera_independant_list.remove(object);
		}
	}

	public void clearFront() {
		isVirusExisting = false;
		this.handler_object_camera_independant_list.clear();
	}

	public void clearBack() {
		isPlayerExisting = false;
		this.handler_object_camera_dependant_list.clear();
	}

	public void clearAll() {
		clearFront();
		clearBack();
	}

}
