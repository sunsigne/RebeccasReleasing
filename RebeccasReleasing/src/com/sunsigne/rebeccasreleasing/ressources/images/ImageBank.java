package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;

public class ImageBank {

	// title
	public static BufferedImage title_1;
	public static BufferedImage title_2;

	public static BufferedImage jouer;
	public static BufferedImage options;
	public static BufferedImage quitter;
	public static BufferedImage play;
	public static BufferedImage quit;

	public static BufferedImage chest;
	public static BufferedImage arms;
	public static BufferedImage head;
	public static BufferedImage foe;
	public static BufferedImage hat;

	// map
	public static BufferedImage lvl01;
	public static BufferedImage lvl01_cutout;
	public static BufferedImage lvl02;
	public static BufferedImage lvl02_cutout;

	// sheet
	public static BufferedImage desk_sheet;
	public static BufferedImage door_sheet;
	public static BufferedImage couch_sheet;
	public static BufferedImage bomb_sheet;
	public static BufferedImage item_sheet;

	// chara
	public static BufferedImage chatbox;
	public static BufferedImage gamma;
	public static BufferedImage rebecca;
	public static BufferedImage sarah;
	public static BufferedImage stephan;
	public static BufferedImage rebecca_walking;

	public static BufferedImage hack_sheet;
	public static BufferedImage virus_sheet;

	// cards
	public static BufferedImage card_frame;
	public static BufferedImage card_attack;
	public static BufferedImage card_critical;
	public static BufferedImage card_defense;
	public static BufferedImage card_folder_gamma;
	public static BufferedImage card_folder_soldier;

	// other
	public static BufferedImage search_folder;

	public void loadRessources() {

		// title
		title_1 = ImageTask.loadImage("title_screen\\title_1.png");
		title_2 = ImageTask.loadImage("title_screen\\title_2.png");

		jouer = ImageTask.loadImage("title_screen\\jouer.png");
		options = ImageTask.loadImage("title_screen\\options.png");
		quitter = ImageTask.loadImage("title_screen\\quitter.png");
		play = ImageTask.loadImage("title_screen\\play.png");
		quit = ImageTask.loadImage("title_screen\\quit.png");

		chest = ImageTask.loadImage("title_screen\\chest.png");
		arms = ImageTask.loadImage("title_screen\\arms.png");
		head = ImageTask.loadImage("title_screen\\head.png");
		foe = ImageTask.loadImage("title_screen\\foe.png");
		hat = ImageTask.loadImage("title_screen\\hat.png");

		// map
		lvl01 = ImageTask.loadImage("lvl01.png");
		lvl01_cutout = ImageTask.loadImage("lvl01_cutout.png");
		lvl02 = ImageTask.loadImage("lvl02.png");
		lvl02_cutout = ImageTask.loadImage("lvl02_cutout.png");

		// sheet
		desk_sheet = ImageTask.loadImage("desk_sheet.png");
		door_sheet = ImageTask.loadImage("door_sheet.png");
		couch_sheet = ImageTask.loadImage("couch_sheet.png");
		bomb_sheet = ImageTask.loadImage("bomb_sheet.png");
		item_sheet = ImageTask.loadImage("item_sheet.png");
		hack_sheet = ImageTask.loadImage("hack_sheet.png");
		virus_sheet = ImageTask.loadImage("virus_sheet.png");

		// chara
		chatbox = ImageTask.loadImage("chatbox.png");
		gamma = ImageTask.loadImage("portrait\\gamma.png");
		rebecca = ImageTask.loadImage("portrait\\rebecca.png");
		sarah = ImageTask.loadImage("portrait\\sarah.png");
		stephan = ImageTask.loadImage("portrait\\stephan.png");
		rebecca_walking = ImageTask.loadImage("rebecca_walking.png");

		// cards
		card_frame = ImageTask.loadImage("card_frame.png");
		card_attack = ImageTask.loadImage("card_attack.png");
		card_critical = ImageTask.loadImage("card_critical.png");
		card_defense = ImageTask.loadImage("card_defense.png");
		card_folder_gamma = ImageTask.loadImage("card_folder_gamma.png");
		card_folder_soldier = ImageTask.loadImage("card_folder_soldier.png");

		// other
		search_folder = ImageTask.loadImage("search_folder.png");

	}

}
