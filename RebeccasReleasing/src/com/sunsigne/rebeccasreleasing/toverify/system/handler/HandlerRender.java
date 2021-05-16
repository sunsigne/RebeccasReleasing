package com.sunsigne.rebeccasreleasing.toverify.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

public class HandlerRender implements IRender {

	public HandlerRender() {
		for (int i = 0; i < 3; i++) {
			handler_render_list[0][i] = new LinkedList<IRender>();
			handler_render_list[1][i] = new LinkedList<IRender>();
		}
	}

	////////// SIGNELTON ////////////

	private static HandlerRender instance = null;

	public static HandlerRender getInstance() {
		if (instance == null)
			instance = new HandlerRender();
		return instance;
	}

	////////// MAP OR LIST ////////////

	@SuppressWarnings("unchecked")
	private static LinkedList<IRender>[][] handler_render_list = new LinkedList[2][3]; // - cameraDependency -
																						// cameraLayer
	// layer 0 - hp&tools & puzzle
	// layer 1 - dialogues
	// layer 2 - menu

	private LinkedList<IRender> getList(boolean cameraDependant, int cameraLayer) {
		int cameraDependency = cameraDependant ? 1 : 0;
		return handler_render_list[cameraDependency][cameraLayer];
	}

	public void addObject(IRender renderable) {
		if (renderable != null)
			addObject(renderable.isCameraDependant(), renderable.getCameraLayer(), renderable);
	}

	protected void addObject(boolean cameraDependant, int cameraLayer, IRender renderable) {
		if (renderable != null) {
			LinkedList<IRender> list = getList(cameraDependant, cameraLayer);
			list.add(renderable);
		}
	}

	public void removeObject(IRender renderable) {
		if (renderable != null)
			removeObject(renderable.isCameraDependant(), renderable.getCameraLayer(), renderable);
	}

	protected void removeObject(boolean cameraDependant, int cameraLayer, IRender renderable) {
		if (renderable != null) {
			LinkedList<IRender> list = getList(cameraDependant, cameraLayer);
			list.remove(renderable);
		}
	}

	public void clear(boolean cameraDependant, int cameraLayer) {
		getList(cameraDependant, cameraLayer).clear();
	}

	public void clearAll() {
		for (int i = 0; i < 3; i++) {
			handler_render_list[0][i].clear();
			handler_render_list[1][i].clear();
		}
	}

	////////// STATE ////////////

	private boolean cameraDependant;
	private int cameraLayer;

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public void setCameraDependant(boolean cameraDependant) {
		this.cameraDependant = cameraDependant;
	}

	@Override
	public int getCameraLayer() {
		return cameraLayer;
	}

	public void setCameraLayer(int cameraLayer) {
		this.cameraLayer = cameraLayer;
	}

	private boolean playerPaintedAtTheEnd;

	public boolean isPlayerPaintedAtTheEnd() {
		return playerPaintedAtTheEnd;
	}

	public void setPlayerPaintedAtTheEnd(boolean playerPaintedAtTheEnd) {
		this.playerPaintedAtTheEnd = playerPaintedAtTheEnd;
	}

	////////// BEHAVIOR ////////////

	// if I ever need to reversed the order of rendering, use the following loop :
	// IRender tempRender = list.get(size - i - 1);
	@Override
	public void render(Graphics g) {

		LinkedList<IRender> list = getList(cameraDependant, cameraLayer);

		for (IRender tempRender : list)
			tempRender.render(g);
//		if (Game.isDebugMode()) {
//			for (IRender tempRender : list)
//				tempRender.drawHitbox(g);
//		}
	}

}
