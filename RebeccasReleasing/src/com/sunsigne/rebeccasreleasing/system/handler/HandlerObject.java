package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionDetection;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

import objects.characters.living.PlayerObject;

public class HandlerObject implements ITick, IRender {

	public HandlerObject() {

		for (int layer = 0; layer < 3; layer++) {
			handler_object_list[0][layer] = new LinkedList<GameObject>();
			handler_object_list[1][layer] = new LinkedList<GameObject>();
		}

		HandlerTick.getInstance().addObject(this);
		for (LAYER layer : LAYER.values()) {
			HandlerRender.getInstance().addObject(true, layer, this);
			HandlerRender.getInstance().addObject(false, layer, this);
		}
	}

	private PlayerObject player = new PlayerObject(0, 0);

	public PlayerObject getPlayer() {
		return player;
	}

	public boolean isPlayerExisting() {
		for (LAYER allLayer : LAYER.values()) {
			if (getList(true, allLayer).contains(player))
				return true;
		}
		return false;
	}

	public void resetPlayer() {
		player = new PlayerObject(0, 0);
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

	public LinkedList<GameObject> getList(boolean cameraDependant, LAYER layer) {
		int cameraDependency = cameraDependant ? 1 : 0;
		return handler_object_list[cameraDependency][layer.getNum()];
	}

	public void addObject(GameObject object) {
		if (object != null) {
			var list = getList(object.isCameraDependant(), object.getLayer());
			list.add(object);
		}
	}

	public void removeObject(GameObject object) {
		if (object != null) {
			var list = getList(object.isCameraDependant(), object.getLayer());
			list.remove(object);
		}
	}

	public void clear(boolean cameraDependant, LAYER layer) {
		getList(cameraDependant, layer).clear();
	}

	public void clearAll() {
		for (int layer = 0; layer < 3; layer++) {
			handler_object_list[0][layer].clear();
			handler_object_list[1][layer].clear();
		}
	}

	public GameObject getObjectAtPos(LAYER layer, int x, int y) {
		for (GameObject tempObject : handler_object_list[1][layer.getNum()]) {
			if (tempObject.getX() == x && tempObject.getY() == y) {
				return tempObject;
			}
		}
		return null;
	}

	////////// TICK ////////////

	@Override
	public void tick() {

		LinkedList<GameObject> list = null;
		for (LAYER layer : LAYER.values()) {

			list = getList(true, layer);
			for (GameObject tempObject : list) {
				tempObject.tick();
				if (ICollisionDetection.class.isInstance(tempObject))
					((ICollisionDetection) tempObject).getCollisionDetector().tick();
			}

			list = getList(false, layer);
			for (GameObject tempObject : list) {
				tempObject.tick();
				if (ICollisionDetection.class.isInstance(tempObject))
					((ICollisionDetection) tempObject).getCollisionDetector().tick();
			}
		}
	}

	////////// RENDER ////////////

	@Override
	public boolean isCameraDependant() {
		return HandlerRender.getInstance().isCameraDependant();
	}

	@Override
	public LAYER getLayer() {
		return HandlerRender.getInstance().getLayer();
	}

	@Override
	public void render(Graphics g) {

		var list = getList(isCameraDependant(), getLayer());

		for (GameObject tempObject : list)
			tempObject.render(g);

		if (Conductor.getDebugMode().getHitboxMode().getState()) {
			for (GameObject tempObject : list)
				tempObject.drawHitbox(g);
		}
	}

}
