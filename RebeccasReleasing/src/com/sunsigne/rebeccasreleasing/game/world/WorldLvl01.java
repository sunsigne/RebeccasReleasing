package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.chat.Chat;
import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.event.Event;
import com.sunsigne.rebeccasreleasing.game.event.EventContext;
import com.sunsigne.rebeccasreleasing.game.event.EventListener;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.system.Conductor;
import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.system.STATE;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.system.util.Size;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
import objects.characters.living.FoeObject;
import objects.world.puzzler.Door;
import objects.world.puzzler.IPuzzler;

public class WorldLvl01 implements ILvl {

	private static final ChatMap frlvl01 = new ChatMap(LANGUAGE.FRENCH, new GameFile("/dialogues/french/lvl01"));
	private static final ChatMap englvl01 = new ChatMap(LANGUAGE.ENGLISH, new GameFile("/dialogues/english/lvl01"));

	@Override
	public int getLvlNumber() {
		return 1;
	}

	@Override
	public BufferedImage getCutoutLvlImage() {
		return ImageBank.getImage(ImageBank.lvl01_cutout);
	}

	@Override
	public BufferedImage getLvlImage() {
		return ImageBank.getImage(ImageBank.lvl01);
	}

	@Override
	public void loadEvent() {
		if (!Game.isDebugMode()) {
			eventFirstStep();
			eventHereIAm();
			eventClosedDoor();
			eventIHadTheKey();
			eventDoorFail1();
			eventDoorFail2();
			eventThatWasEasy();
			eventSpawningHp();
			eventNearFoe();
			eventIHaveNoSword();
			eventFoeFail();
			eventFoeSuccess();
		}
	}

	private void eventFirstStep() {
		new Event("First Step", new EventContext() {

			// When the level start
			@Override
			public boolean startingCondition() {
				return Conductor.getState() == STATE.LEVEL;
			}

			// Set to player infinite hp (so generous!)
			// Move player to the right
			@Override
			public void startEvent() {
				World.gui.setInfinitHp(true);
				HandlerObject.getInstance().player.setVelY(0);
				HandlerObject.getInstance().player.setVelX(Size.TILE / 16);
			}
		});
	}

	private void eventHereIAm() {
		new Event("Here I Am", new EventContext() {

			// When the player took a few steps
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 2400;
			}

			// Talk with sarah about the mission
			@Override
			public void startEvent() {
				World.loadChat(new Chat(1, null, frlvl01, englvl01));
			}
		});
	}

	private void eventClosedDoor() {
		new Event("Closed Door", new EventContext() {

			// When the player is close to the very first door
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 4450;
			}

			// Prepare the dialogue in the case where the player already had the key
			// Talk with sarah about how opening it
			// Prepare the door for dialogue if falling
			@Override
			public void startEvent() {
				Event event = HandlerEvent.getInstance().getEvent("I Had The Key");
				EventListener listener = null;
				if (World.gui.getTool(Tool.KEY).getCurrentLvl() > 0)
					listener = () -> event.mustOccur(true);
				World.loadChat(new Chat(2, listener, frlvl01, englvl01));
				Event event1 = HandlerEvent.getInstance().getEvent("Door Fail 1");
				Door door = (Door) HandlerObject.getInstance().getObjectAtPos(4608, 2784);
				((IPuzzler) door).setEventOnClose(() -> event1.mustOccur(true), false);
			}
		});
	}

	private void eventIHadTheKey() {
		new Event("I Had The Key", new EventContext() {

			// When the previous chat close and if the player already had the key
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about how stupid Rebecca is
			@Override
			public void startEvent() {
				World.loadChat(new Chat(3, null, frlvl01, englvl01));
			}
		});
	}

	private void eventDoorFail1() {
		new Event("Door Fail 1", new EventContext() {

			// When the player fail at opening the door
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about tips
			// Prepare the door for dialogue if failling again
			@Override
			public void startEvent() {
				moveThePlayerFutherFromDoor();
				World.loadChat(new Chat(4, null, frlvl01, englvl01));
				Event event = HandlerEvent.getInstance().getEvent("Door Fail 2");
				Door door = (Door) HandlerObject.getInstance().getObjectAtPos(4608, 2784);
				((IPuzzler) door).setEventOnClose(() -> event.mustOccur(true), false);
			}
		});
	}

	private void eventDoorFail2() {
		new Event("Door Fail 2", new EventContext() {

			// When the player fail at opening the door again
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about more tips
			@Override
			public void startEvent() {
				moveThePlayerFutherFromDoor();
				World.loadChat(new Chat(5, null, frlvl01, englvl01));
			}
		});
	}

	private void moveThePlayerFutherFromDoor() {
		int playerPosX = HandlerObject.getInstance().player.getX();
		HandlerObject.getInstance().player.setX(playerPosX - Size.TILE / 2);
	}

	private void eventThatWasEasy() {
		new Event("That was Easy", new EventContext() {

			// When the player has passed the 2 first doors
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 6280;
			}

			// Besure failing-opening-door-event won't occur anymore
			// Talk with sarah about hp and stuff
			@Override
			public void startEvent() {
				HandlerEvent.getInstance().getEvent("Door Fail 1").canOccur(false);
				HandlerEvent.getInstance().getEvent("Door Fail 2").canOccur(false);
				// event 7 during chat
				World.loadChat(new Chat(6, null, frlvl01, englvl01));
			}
		});
	}

	private void eventSpawningHp() {
		new Event("Spawning Hp", new EventContext() {

			// When the previous chat is at the middle
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Give the player 3 nicely hearts
			@Override
			public void startEvent() {
				World.gui.setInfinitHp(false);
			}
		});
	}

	private void eventNearFoe() {
		new Event("Near Foe", new EventContext() {

			// When the player is close to the very first foe
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 7900;
			}

			// Prepare the dialogue in the case where the player don't have the sword yet
			// Talk with sarah about how pass him
			// Prepare the foe for dialogue if failling or winning
			@Override
			public void startEvent() {
				Event event = HandlerEvent.getInstance().getEvent("I Have No Sword");
				EventListener listener = null;
				if (World.gui.getTool(Tool.SWORD).getCurrentLvl() < 1)
					listener = () -> event.mustOccur(true);
				World.loadChat(new Chat(7, listener, frlvl01, englvl01));

				Event event1 = HandlerEvent.getInstance().getEvent("Foe Fail");
				Event event2 = HandlerEvent.getInstance().getEvent("Foe Success");
				FoeObject foe = (FoeObject) HandlerObject.getInstance().getObjectAtPos(8640, 3264);
				((IPuzzler) foe).setEventOnClose(() -> event1.mustOccur(true), false);
				((IPuzzler) foe).setEventOnClose(() -> event2.mustOccur(true), true);
			}
		});
	}

	private void eventIHaveNoSword() {
		new Event("I Have No Sword", new EventContext() {

			// When the previous chat close and if the player had no sword
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with Sarah about finding it before the fight
			@Override
			public void startEvent() {
				World.loadChat(new Chat(8, null, frlvl01, englvl01));
			}
		});
	}

	private void eventFoeFail() {
		new Event("Foe Fail", new EventContext() {

			// When the player fail at killing the foe
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about tips
			@Override
			public void startEvent() {
				World.loadChat(new Chat(9, null, frlvl01, englvl01));
			}
		});
	}

	private void eventFoeSuccess() {
		new Event("Foe Success", new EventContext() {

			// When the player success at killing the foe
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about your mission
			@Override
			public void startEvent() {
				HandlerEvent.getInstance().getEvent("Foe Fail").canOccur(false);
				World.loadChat(new Chat(10, null, frlvl01, englvl01));
			}
		});
	}

}
