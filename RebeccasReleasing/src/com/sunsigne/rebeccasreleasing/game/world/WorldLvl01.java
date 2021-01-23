package com.sunsigne.rebeccasreleasing.game.world;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.chat.Chat;
import com.sunsigne.rebeccasreleasing.game.chat.ChatMap;
import com.sunsigne.rebeccasreleasing.game.event.INeoEvent;
import com.sunsigne.rebeccasreleasing.game.event.NeoEventBuilder;
import com.sunsigne.rebeccasreleasing.game.event.NeoEventListener;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;
import com.sunsigne.rebeccasreleasing.main.STATE;
import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerEvent;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.Tool;
import com.sunsigne.rebeccasreleasing.toclean.rebuild.onlyconductortorebuild.Conductor;
import com.sunsigne.rebeccasreleasing.toclean.verify.OBJECTID;

import objects.GameObject;
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
		eventFirstStep();
		eventHereIAm();
		eventClosedDoor();
		eventSpawningKey();
		eventDoorFail1();
		eventDoorFail2();
		eventThatWasEasy();
		eventSpawningHp();
		eventNearFoe();
		eventSpawningSword();
		eventFoeFail();
		eventFoeSuccess();
	}

	private void eventFirstStep() {
		new NeoEventBuilder("First Step", new NeoEventListener() {

			// When the level start
			@Override
			public boolean startingCondition() {
				return Conductor.getState() == STATE.LEVEL;
			}

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
		new NeoEventBuilder("Here I Am", new NeoEventListener() {

			// When the player took some steps
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 2400;
			}

			// Talk with sarah about the mission
			@Override
			public void startEvent() {
				new Chat(1, null, frlvl01, englvl01);
			}
		});
	}

	private void eventClosedDoor() {
		new NeoEventBuilder("Closed Door", new NeoEventListener() {

			// When the player is close to the first door location
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 3700
						&& HandlerObject.getInstance().player.getY() < 3000;
			}

			// Talk with sarah about how opening it
			@Override
			public void startEvent() {
				INeoEvent event = HandlerEvent.getInstance().getEvent("Spawing Key");
				new Chat(2, () -> event.mustOccur(true), frlvl01, englvl01);
			}
		});
	}

	@Todo("rendre l'apparition de l'outils + évidente ! (nouveau dessin de cutout ?)"
			+ "éventuellemt faire loot la clef (l'idée est bonne mais il faut justifier le fait de ne pas looter l'épée ...")
	private void eventSpawningKey() {
		new NeoEventBuilder("Spawing Key", new NeoEventListener() {

			// When the event "Closed Door" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Give the player a key, and prepare the door for dialogue if falling
			@Override
			public void startEvent() {
				World.gui.getCharacteristics().getTool(Tool.KEY).upgradeLvlTo(2);
				World.gui.setRedtool(true, 0);
				SoundTask.playSound(SoundBank.getSound(SoundBank.popup));
				Conductor.setState(STATE.LEVEL);
				INeoEvent event = HandlerEvent.getInstance().getEvent("Door Fail 1");
				getMostLeftPuzzler(OBJECTID.DOOR).setEventOnClose(() -> event.mustOccur(true), false);
			}
		});
	}

	private void eventDoorFail1() {
		new NeoEventBuilder("Door Fail 1", new NeoEventListener() {

			// When the event "Spawing Key" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about tips, , and prepare the door for dialogue if falling
			// again
			@Override
			public void startEvent() {
				moveThePlayerFutherFromDoor();
				new Chat(3, null, frlvl01, englvl01);
				INeoEvent event = HandlerEvent.getInstance().getEvent("Door Fail 2");
				getMostLeftPuzzler(OBJECTID.DOOR).setEventOnClose(() -> event.mustOccur(true), false);
			}
		});
	}

	private void eventDoorFail2() {
		new NeoEventBuilder("Door Fail 2", new NeoEventListener() {

			// When the event "Door Fail 1" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about more tips
			@Override
			public void startEvent() {
				moveThePlayerFutherFromDoor();
				new Chat(4, null, frlvl01, englvl01);
			}
		});
	}

	private void eventThatWasEasy() {
		new NeoEventBuilder("That was Easy", new NeoEventListener() {

			// When the player has passed the 2 first doors
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 4530;
			}

			// Talk with sarah about hp and stuff
			@Override
			public void startEvent() {
				HandlerEvent.getInstance().getEvent("Door Fail 1").canOccur(false);
				HandlerEvent.getInstance().getEvent("Door Fail 2").canOccur(false);
				// event 7 during chat
				new Chat(5, null, frlvl01, englvl01);
			}
		});
	}

	private void eventSpawningHp() {
		new NeoEventBuilder("Spawning Hp", new NeoEventListener() {

			// When the chat from "That was Easy" has called this event
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
		new NeoEventBuilder("Near Foe", new NeoEventListener() {

			// When the player is close to the first foe location
			@Override
			public boolean startingCondition() {
				return HandlerObject.getInstance().player.getX() > 5720;
			}

			// Talk with sarah about how pass by
			@Override
			public void startEvent() {
				INeoEvent event = HandlerEvent.getInstance().getEvent("Spawing Sword");
				new Chat(6, () -> event.mustOccur(true), frlvl01, englvl01);
			}
		});
	}

	private void eventSpawningSword() {
		new NeoEventBuilder("Spawing Sword", new NeoEventListener() {

			// When the event "Near Foe" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Give the player a sword, and prepare the door for dialogue if falling
			@Override
			public void startEvent() {
				World.gui.getCharacteristics().getTool(Tool.SWORD).upgradeLvlTo(2);
				World.gui.setRedtool(true, 1);
				SoundTask.playSound(SoundBank.getSound(SoundBank.popup));
				Conductor.setState(STATE.LEVEL);
				INeoEvent event = HandlerEvent.getInstance().getEvent("Foe Fail");
				INeoEvent event2 = HandlerEvent.getInstance().getEvent("Foe Success");
				getMostLeftPuzzler(OBJECTID.FOE).setEventOnClose(() -> event.mustOccur(true), false);
				getMostLeftPuzzler(OBJECTID.FOE).setEventOnClose(() -> event2.mustOccur(true), true);
			}
		});
	}
	

	private void eventFoeFail() {
		new NeoEventBuilder("Foe Fail", new NeoEventListener() {

			// When the event "Spawing Sword" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about tips
			@Override
			public void startEvent() {
				new Chat(7, null, frlvl01, englvl01);
			}
		});
	}
	
	private void eventFoeSuccess() {
		new NeoEventBuilder("Foe Success", new NeoEventListener() {

			// When the event "Spawing Sword" has called this event
			@Override
			public boolean startingCondition() {
				return false;
			}

			// Talk with sarah about your mission
			@Override
			public void startEvent() {
				HandlerEvent.getInstance().getEvent("Foe Fail").canOccur(false);;
				new Chat(8, null, frlvl01, englvl01);
			}
		});
	}


	// !! currently, give the wrong door (because not recalculate when puzzle
	// solved)
	private void moveThePlayerFutherFromDoor() {
		int playerPosX = HandlerObject.getInstance().player.getX();
		HandlerObject.getInstance().player.setX(playerPosX - Size.TILE / 2);
	}

	private IPuzzler getMostLeftPuzzler(OBJECTID objectID) {
		IPuzzler object = null;

		LinkedList<GameObject> list = HandlerObject.getInstance().getList(true);
		for (GameObject tempObject : list) {
			if (tempObject.getId() == objectID) {
				IPuzzler tempPuzzler = (IPuzzler) tempObject;
				if (object == null)
					object = tempPuzzler;
				if (!tempPuzzler.isSolved() && tempObject.getX() < ((GameObject) object).getX())
					object = tempPuzzler;
			}
		}
		return object;
	}

}
