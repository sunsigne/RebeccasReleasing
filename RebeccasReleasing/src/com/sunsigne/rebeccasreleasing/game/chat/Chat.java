package com.sunsigne.rebeccasreleasing.game.chat;

import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.main.Conductor;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

public class Chat extends ChatBuilder {

	private EventListener eventOnClose;
	private int count;

	public Chat(int chatID, EventListener eventOnClose, ChatMap chatMap, ChatMap... chatMaps) {
		super(chatID, chatMap, chatMaps);
		this.eventOnClose = eventOnClose;
	}

	@Override
	public void mousePressed(int mx, int my) {
		goToNextSentence();
	}

	@Override
	public void mouseReleased(int mx, int my) {
	}

	@Override
	protected void displayChat() {
		HandlerObject.getInstance().clearFront();
		HandlerObject.getInstance().addObject(World.gui);
		HandlerObject.getInstance().addObject(chatObject[count]);
		chatObject[count].startEvent();
	}

	private void goToNextSentence() {

		if (chatObject[count] != null) {
			if (!chatObject[count].isFulldisplayed())
				chatObject[count].setFulldisplayed(true);
			else {
				count++;
				if (chatObject[count] != null)
					displayChat();
				else
					close();
			}
		}
	}

	@Override
	public void close() {
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);
		World.stunAllFoes();
		Conductor.setState(STATE.LEVEL);
		HandlerObject.getInstance().player.loadBasicState();
		SoundTask.changeMusicVol(0.5);
		if (eventOnClose != null)
			eventOnClose.startEvent();
	}

}
