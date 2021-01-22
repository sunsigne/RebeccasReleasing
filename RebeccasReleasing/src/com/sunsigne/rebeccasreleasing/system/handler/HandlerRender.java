package com.sunsigne.rebeccasreleasing.system.handler;

import java.awt.Graphics;
import java.util.LinkedList;

public class HandlerRender implements IRender {

	private static HandlerRender instance = null;

	public static HandlerRender getInstance() {
		if (instance == null)
			instance = new HandlerRender();
		return instance;
	}
	
	private LinkedList<IRender> handler_render_camera_dependant_list = new LinkedList<>();
	private LinkedList<IRender> handler_render_camera_independant_list = new LinkedList<>();
	private boolean cameraDependant;
	public boolean playerAbove;

	@Override
	public boolean isCameraDependant() {
		return cameraDependant;
	}

	public void setCameraDependant(boolean cameraDependant) {
		this.cameraDependant = cameraDependant;
	}

	@Override
	public void render(Graphics g) {

		if (isCameraDependant())
			renderCameraDependant(g);
		else
			renderCameraIndependant(g);
	}

	private void renderCameraDependant(Graphics g) {
		try {
			int size = handler_render_camera_dependant_list.size();
			for (int i = 0; i < size; i++) {
				IRender tempRender = handler_render_camera_dependant_list.get(size - i - 1);
				tempRender.render(g);
			}
		} catch (Exception e) {

		}
	}

	private void renderCameraIndependant(Graphics g) {
		try {
			int size = handler_render_camera_independant_list.size();
			for (int i = 0; i < size; i++) {
				IRender tempRender = handler_render_camera_independant_list.get(size - i - 1);
				tempRender.render(g);
			}
		} catch (Exception e) {

		}
	}

	public void addObject(boolean cameraDependant, IRender renderable) {
		if (renderable != null) {
			if (cameraDependant)
				HandlerRender.getInstance().handler_render_camera_dependant_list.add(renderable);
			else
				HandlerRender.getInstance().handler_render_camera_independant_list.add(renderable);
		}
	}

	public void addObject(IRender renderable) {
		if (renderable != null) {
			if (renderable.isCameraDependant())
				HandlerRender.getInstance().handler_render_camera_dependant_list.add(renderable);
			else
				HandlerRender.getInstance().handler_render_camera_independant_list.add(renderable);
		}
	}

	public void removeObject(IRender renderable) {
		if (renderable != null) {
			if (renderable.isCameraDependant())
				HandlerRender.getInstance().handler_render_camera_dependant_list.remove(renderable);
			else
				HandlerRender.getInstance().handler_render_camera_independant_list.remove(renderable);
		}
	}

	public void clearFront() {
		HandlerObject.getInstance().isVirusExisting = false;
		this.handler_render_camera_independant_list.clear();
	}

	public void clearBack() {
		HandlerObject.getInstance().isPlayerExisting = false;
		this.handler_render_camera_dependant_list.clear();
	}

	public void clearAll() {
		clearFront();
		clearBack();
	}

}
