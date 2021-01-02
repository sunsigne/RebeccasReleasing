package com.sunsigne.rebeccasreleasing.system.controllers.mouse;

import com.sunsigne.rebeccasreleasing.system.handler.IRender;

public interface IClick extends IRender {

	void mousePressed(int mx, int my);

	void mouseReleased(int mx, int my);
}
