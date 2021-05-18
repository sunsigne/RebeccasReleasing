package com.sunsigne.rebeccasreleasing.toverify.system.controllers.mouse;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.system.handler.IRender;

public interface IClick extends IRender {

	void mousePressed(int mx, int my);

	void mouseReleased(int mx, int my);

}
