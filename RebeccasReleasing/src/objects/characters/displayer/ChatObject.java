package objects.characters.displayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;

import objects.GameObject;
import objects.OBJECTID;
import objects.characters.CHARA;

public class ChatObject extends GameObject {

	public boolean fulldisplayed;

	private CHARA chara;
	private String[] text = new String[2];
	private String[] currentText = new String[2];

	private char[][] letter = new char[2][64];

	private int speed = 1;
	private int count = 0, index = 0;

	private final int maxpausetime = 25;
	private int pausetime = maxpausetime;
	private boolean pause;

	private boolean[] stop = new boolean[2];

	public ChatObject(CHARA chara, String text0, String text1) {
		super(Size.X0, 750, OBJECTID.DISPLAYER, false);

		this.chara = chara;
		this.text[0] = text0;
		this.text[1] = text1;
		this.currentText[0] = "";
		this.currentText[1] = "";

		w = 1857;
		h = 300;

		for (int i = 0; i < text[0].length(); i++) {
			letter[0][i] = this.text[0].charAt(i);
		}

		if (text[1] != null) {
			for (int j = 0; j < text[1].length(); j++) {
				letter[1][j] = this.text[1].charAt(j);
			}
		}
	}

	// state

	public void setFulldisplayed(boolean fulldisplayed) {
		this.fulldisplayed = fulldisplayed;
		if (fulldisplayed) {
			stop[0] = true;
			stop[1] = true;
			currentText[0] = text[0];
			currentText[1] = text[1];
		}
	}

	public boolean isFulldisplayed() {
		return fulldisplayed;
	}

	public void resetPauseTime() {
		pausetime = maxpausetime;
	}

	@Override
	public void tick() {
		if (pause) {
			pausetime--;
			if (pausetime <= 0) {
				pause = false;
				resetPauseTime();
			}
		}

		if (!stop[0] && !pause) {
			index++;
			if (index > speed) {
				index = 0;
				nextChar(0);
			}
		}
		if (stop[0] && !stop[1] && !pause) {
			index++;
			if (index > speed) {
				index = 0;
				nextChar(1);
			}
		}
	}

	private void nextChar(int line) {
		char newchar = ' ';
		String newletter;

		for (int i = 0; i < text[line].length(); i++) {

			if (count == i) {
				newchar = letter[line][i];
				newletter = String.valueOf(newchar);
				boolean isPauseChar = ":,.!?…".contains(Character.toString(letter[line][i]));
				if (isPauseChar)
					pause = true;
				currentText[line] = currentText[line] + newletter;
				playTalkingSound();
			}
		}
		count++;

		if (count == text[line].length()) {
			count = 0;
			stop[line] = true;
			if (line == 0 && text[1] == null)
				setFulldisplayed(true);
			else if (line == 1)
				setFulldisplayed(true);
		}
	}

	private void playTalkingSound() {
		switch (chara) {
		case Rebecca:
			SoundTask.playSound(0.2, SoundBank.talking_rebecca);
			break;
		case Sarah:
			SoundTask.playSound(0.2, SoundBank.talking_sarah);
			break;
		default:
			break;
		}
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(ImageBank.chatbox, 0, 0, Size.WIDHT, Size.HEIGHT, null);

		BufferedImage img = null;
		img = paintingChara(chara);

		g.drawImage(img, 350, y, -2 * h / 3, 2 * h / 3, null);

		drawText(g);
	}

	private BufferedImage paintingChara(CHARA chara) {
		BufferedImage img = null;

		switch (chara) {
		case Rebecca:
			img = ImageBank.rebecca;
			break;
		case Sarah:
			img = ImageBank.sarah;
			break;
		default:
			img = ImageTask.drawMissingTexture();
			break;
		}
		return img;
	}

	private void drawText(Graphics g) {
		Font font = new Font("arial", 1, 55);
		g.setColor(Color.white);
		g.setFont(font);

		int x0 = 440;

		if (currentText[0] != null)
			g.drawString(currentText[0], x0, y + 80);
		if (currentText[1] != null)
			g.drawString(currentText[1], x0, y + 170);
	}

	@Override
	public Rectangle getBounds() {

		return null;
	}

}
