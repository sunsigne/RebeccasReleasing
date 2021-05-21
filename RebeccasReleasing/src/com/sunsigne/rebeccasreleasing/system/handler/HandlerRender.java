package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.LAYER;

public class HandlerRender implements IRender {

	public HandlerRender() {
		for (int layer = 0; layer < 3; layer++) {
			handler_render_list[0][layer] = new LinkedList<IRender>();
			handler_render_list[1][layer] = new LinkedList<IRender>();
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
	private static LinkedList<IRender>[][] handler_render_list = new LinkedList[2][3]; // - cameraDependency - layer

	private LinkedList<IRender> getList(boolean cameraDependant, LAYER layer) {
		int cameraDependency = cameraDependant ? 1 : 0;
		return handler_render_list[cameraDependency][layer.getNum()];
	}

	public void addObject(IRender renderable) {
		if (renderable != null)
			addObject(renderable.isCameraDependant(), renderable.getLayer(), renderable);
	}

	protected void addObject(boolean cameraDependant, LAYER layer, IRender renderable) {
		if (renderable != null) {
			var list = getList(cameraDependant, layer);
			list.add(renderable);
		}
	}

	public void removeObject(IRender renderable) {
		if (renderable != null)
			removeObject(renderable.isCameraDependant(), renderable.getLayer(), renderable);
	}

	protected void removeObject(boolean cameraDependant, LAYER layer, IRender renderable) {
		if (renderable != null) {
			var list = getList(cameraDependant, layer);
			list.remove(renderable);
		}
	}

	public void clear(boolean cameraDependant, LAYER layer) {
		getList(cameraDependant, layer).clear();
	}

	public void clearAll() {
		for (int layer = 0; layer < 3; layer++) {
			handler_render_list[0][layer].clear();
			handler_render_list[1][layer].clear();
		}
	}

	////////// RENDER ////////////

	private boolean cameraDependant;
	private LAYER layer;

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public void setCameraDependant(boolean cameraDependant) {
		this.cameraDependant = cameraDependant;
	}

	@Override
	public LAYER getLayer() {
		return layer;
	}

	public void setLayer(LAYER layer) {
		this.layer = layer;
	}

	private boolean playerRenderingRefreshed;

	public boolean isPlayerRenderingRefreshed() {
		return playerRenderingRefreshed;
	}

	public void setPlayerRenderingRefreshed(boolean playerRenderingRefreshed) {
		this.playerRenderingRefreshed = playerRenderingRefreshed;
	}

	@Override
	public void render(Graphics g) {
		var list = getList(cameraDependant, layer);
		int size = list.size();
		for (int i = 0; i < size; i++) {
			// size - i - 1 --> the last object is render first, then the previous one, and
			// so on. As HandlerObject is added berofe back layers, the opposite would turns
			// objects invisible (because BEHIND the back layers)
			IRender tempRender = list.get(size - i - 1);
			tempRender.render(g);
		}
	}

}
