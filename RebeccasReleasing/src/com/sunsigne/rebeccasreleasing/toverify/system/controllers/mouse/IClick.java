package com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse;

import com.sunsigne.rebeccasreleasing.toverify.system.handler.IRender;

import objects.GameObject;

public interface IClick extends IRender {

	void mousePressed(int mx, int my);

	void mouseReleased(int mx, int my);

}
