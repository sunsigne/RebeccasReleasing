package com.sunsigne.rebeccasreleasing.toverify.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.Game;

import objects.GameObject;

public class HandlerRender implements IRender {

	////////// SIGNELTON ////////////

	private static HandlerRender instance = null;

	public static HandlerRender getInstance() {
		if (instance == null)
			instance = new HandlerRender();
		return instance;
	}

	////////// MAP OR LIST ////////////

	private LinkedList<IRender> handler_render_camera_dependant_list = new LinkedList<>();
	private LinkedList<IRender> handler_render_camera_independant_list = new LinkedList<>();

	private LinkedList<IRender> getList(boolean cameraDependant) {
		return cameraDependant ? handler_render_camera_dependant_list : handler_render_camera_independant_list;
	}

	public void addObject(IRender renderable) {
		addObject(renderable.isCameraDependant(), renderable);
	}

	protected void addObject(boolean cameraDependant, IRender renderable) {
		if (renderable != null) {
			LinkedList<IRender> list = HandlerRender.getInstance().getList(cameraDependant);
			list.add(renderable);
		}
	}

	public void removeObject(IRender renderable) {
		if (renderable != null) {
			LinkedList<IRender> list = HandlerRender.getInstance().getList(renderable.isCameraDependant());
			list.remove(renderable);
		}
	}

	public void clearFront() {
		HandlerObject.getInstance().setVirusExisting(false);
		this.handler_render_camera_independant_list.clear();
	}

	public void clearBack() {
		HandlerObject.getInstance().setPlayerExisting(false);
		this.handler_render_camera_dependant_list.clear();
	}

	public void clearAll() {
		clearFront();
		clearBack();
	}

	////////// STATE ////////////

	private boolean cameraDependant;
	private boolean playerPaintedAtTheEnd;

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public void setCameraDependant(boolean cameraDependant) {
		this.cameraDependant = cameraDependant;
	}

	public boolean isPlayerPaintedAtTheEnd() {
		return playerPaintedAtTheEnd;
	}

	public void setPlayerPaintedAtTheEnd(boolean playerPaintedAtTheEnd) {
		this.playerPaintedAtTheEnd = playerPaintedAtTheEnd;
	}

	////////// BEHAVIOR ////////////

	@Override
	public void render(Graphics g) {
		LinkedList<IRender> list = HandlerRender.getInstance().getList(cameraDependant);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			// size - i - 1 --> the last object is render first, then the previous one, and
			// so on.
			IRender tempRender = list.get(size - i - 1);
			tempRender.render(g);
		}
	}
/*	
	@Override
	public void render(Graphics g) {

		LinkedList<IRender> list = HandlerRender.getInstance().getList(cameraDependant);		

		for (IRender tempRender : list)
			tempRender.render(g);
/*
		if (Game.isDebugMode()) {
			for (IRender tempRender : list)
				tempObject.drawHitbox(g);
		}
	}
*/


}
