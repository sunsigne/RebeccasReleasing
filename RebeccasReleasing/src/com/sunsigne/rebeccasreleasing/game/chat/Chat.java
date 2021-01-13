package com.sunsigne.rebeccasreleasing.game.chat;

import java.awt.Graphics;

import com.sunsigne.rebeccasreleasing.game.menu.options.Options;
import com.sunsigne.rebeccasreleasing.game.world.World;
import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.conductor.STATE;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.Clickable;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameMouseListener;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.IClick;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;

import objects.characters.CHARA;
import objects.characters.displayer.ChatObject;

public abstract class Chat extends Clickable implements IChat, IClick {

	private static IChat ichat;
	private static String frTxt, engTxt;
	
	private ChatObject chatObject;
	private int number, count;

	/**
	 * WARNING ! Because of the fonctions mouse.clearClickable() and
	 * HandlerObject.getInstance().clearFront(); starting a chat would cause various bugs if a
	 * clickable (like a puzzle for exemple) is already open.
	 */
	public Chat(int number, String lvlFrTxt, String lvlEngTxt) {
		super(STATE.CHATTING);
		ichat = this;
		this.number = number;
		SoundTask.changeMusicVol(0.2);
		loadingTxt(lvlFrTxt, lvlEngTxt);
		chat(number);
	}

	@Override
	public boolean isCameraDependant() {
		return false;
	}
	
	private void loadingTxt(String lvlFrTxt, String lvlEngTxt) {
		frTxt = lvlFrTxt;
		engTxt = lvlEngTxt;
	}

	private String read(int line) {
		switch (Options.getLanguage()) {
		case FRENCH:
			return FileTask.read(frTxt, line);
		case ENGLISH:
		default:
			return FileTask.read(engTxt, line);
		}
	}

	@Override
	public void mousePressed(int mx, int my) {
		if (chatObject.isFulldisplayed())
			chat(number);
		else
			chatObject.setFulldisplayed(true);
	}

	@Override
	public void mouseReleased(int mx, int my) {
	}

	protected void chat(int lineID, int secondLine) {
		
		lineID = lineID + 1;
		secondLine = secondLine + 1;
		
		String dataline = read(lineID);
		String [] data = dataline.split(";");
		CHARA chara = CHARA.getChara(Integer.valueOf(data[1]));
		String line = data[3].replace("\"", "");
		String secondline = null;
		
		if(secondLine == lineID + 1)
		{
			String seconddataline = read(secondLine);
			String [] seconddata = seconddataline.split(";");	
			secondline = seconddata[3].replace("\"", "");;
		}
		
		chatObject = new ChatObject(chara, line, secondline);
		HandlerObject.getInstance().addObject(chatObject);
	}	

	protected void chat(int number) {
		HandlerObject.getInstance().clearFront();
		HandlerObject.getInstance().addObject(World.gui);
		count++;

		switch (number) {
		case 0:
			ichat.chat00(count);
			break;
		case 1:
			ichat.chat01(count);
			break;
		case 2:
			ichat.chat02(count);
			break;
		case 3:
			ichat.chat03(count);
			break;
		case 4:
			ichat.chat04(count);
			break;
		case 5:
			ichat.chat05(count);
			break;
		case 6:
			ichat.chat06(count);
			break;
		case 7:
			ichat.chat07(count);
			break;
		case 8:
			ichat.chat08(count);
			break;
		case 9:
			ichat.chat09(count);
			break;
		case 10:
			ichat.chat10(count);
			break;
		case 11:
			ichat.chat11(count);
			break;
		case 12:
			ichat.chat12(count);
			break;
		case 13:
			ichat.chat13(count);
			break;
		case 14:
			ichat.chat14(count);
			break;
		case 15:
			ichat.chat15(count);
			break;
		}

	}

	public void close() {
		ichat = null;
		GameMouseListener.getInstance().clearClickable();
		HandlerObject.getInstance().addObject(World.gui);
		World.stunAllFoes();
		Conductor.setState(STATE.LEVEL);
		HandlerObject.getInstance().player.loadBasicState();
		SoundTask.changeMusicVol(0.5);
	}

	@Override
	public void render(Graphics g) {

	}

}
