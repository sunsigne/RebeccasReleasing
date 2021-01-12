package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageBank {

	private static Map<ImageBank, BufferedImage>images = new HashMap<>();
	
	// title
	public static final ImageBank title_1 = new ImageBank();
	public static final ImageBank title_2 = new ImageBank();

	public static final ImageBank jouer = new ImageBank();
	public static final ImageBank options = new ImageBank();
	public static final ImageBank quitter = new ImageBank();
	public static final ImageBank play = new ImageBank();
	public static final ImageBank quit = new ImageBank();

	public static final ImageBank chest = new ImageBank();
	public static final ImageBank arms = new ImageBank();
	public static final ImageBank head = new ImageBank();
	public static final ImageBank foe = new ImageBank();
	public static final ImageBank hat = new ImageBank();

	// map
	public static final ImageBank lvl01 = new ImageBank();
	public static final ImageBank lvl01_cutout = new ImageBank();
	public static final ImageBank lvl02 = new ImageBank();
	public static final ImageBank lvl02_cutout = new ImageBank();
	public static final ImageBank lvl03 = new ImageBank();
	public static final ImageBank lvl03_cutout = new ImageBank();

	// sheet
	public static final ImageBank battery_sheet = new ImageBank();
	public static final ImageBank desk_sheet = new ImageBank();
	public static final ImageBank door_sheet = new ImageBank();
	public static final ImageBank couch_sheet = new ImageBank();
	public static final ImageBank bomb_sheet = new ImageBank();
	public static final ImageBank item_sheet = new ImageBank();
	public static final ImageBank tool_sheet = new ImageBank();
	public static final ImageBank wallcracked_sheet = new ImageBank();

	// chara
	public static final ImageBank chatbox = new ImageBank();
	public static final ImageBank gamma = new ImageBank();
	public static final ImageBank rebecca = new ImageBank();
	public static final ImageBank sarah = new ImageBank();
	public static final ImageBank stephan = new ImageBank();
	public static final ImageBank rebecca_walking = new ImageBank();
	public static final ImageBank foe_walking = new ImageBank();

	public static final ImageBank hack_sheet = new ImageBank();
	public static final ImageBank virus_sheet = new ImageBank();

	// cards
	public static final ImageBank card_frame = new ImageBank();
	public static final ImageBank card_attack = new ImageBank();
	public static final ImageBank card_critical = new ImageBank();
	public static final ImageBank card_defense = new ImageBank();
	public static final ImageBank card_folder_gamma = new ImageBank();
	public static final ImageBank card_folder_soldier = new ImageBank();

	// other
	public static final ImageBank search_folder = new ImageBank();


	public void loadRessources() {

		
		
		// title
		addImage(title_1, ImageTask.loadImage("title_screen\\title_1.png"));
		addImage(title_2, ImageTask.loadImage("title_screen\\title_2.png"));

		addImage(jouer, ImageTask.loadImage("title_screen\\jouer.png"));
		addImage(options, ImageTask.loadImage("title_screen\\options.png"));
		addImage(quitter, ImageTask.loadImage("title_screen\\quitter.png"));
		addImage(play, ImageTask.loadImage("title_screen\\play.png"));
		addImage(quit, ImageTask.loadImage("title_screen\\quit.png"));

		addImage(chest, ImageTask.loadImage("title_screen\\chest.png"));
		addImage(arms, ImageTask.loadImage("title_screen\\arms.png"));
		addImage(head, ImageTask.loadImage("title_screen\\head.png"));
		addImage(foe, ImageTask.loadImage("title_screen\\foe.png"));
		addImage(hat, ImageTask.loadImage("title_screen\\hat.png"));

		// map
		addImage(lvl01, ImageTask.loadImage("lvl01.png"));
		addImage(lvl01_cutout, ImageTask.loadImage("lvl01_cutout.png"));
		addImage(lvl02, ImageTask.loadImage("lvl02.png"));
		addImage(lvl02_cutout, ImageTask.loadImage("lvl02_cutout.png"));
		addImage(lvl03, ImageTask.loadImage("lvl03.png"));
		addImage(lvl03_cutout, ImageTask.loadImage("lvl03_cutout.png"));

		// sheet
		addImage(battery_sheet, ImageTask.loadImage("battery_sheet.png"));
		addImage(desk_sheet, ImageTask.loadImage("desk_sheet.png"));
		addImage(door_sheet, ImageTask.loadImage("door_sheet.png"));
		addImage(couch_sheet, ImageTask.loadImage("couch_sheet.png"));
		addImage(bomb_sheet, ImageTask.loadImage("bomb_sheet.png"));
		addImage(item_sheet, ImageTask.loadImage("item_sheet.png"));
		addImage(tool_sheet, ImageTask.loadImage("tool_sheet.png"));
		addImage(hack_sheet, ImageTask.loadImage("hack_sheet.png"));
		addImage(virus_sheet, ImageTask.loadImage("virus_sheet.png"));
		addImage(wallcracked_sheet, ImageTask.loadImage("wallcracked_sheet.png"));

		// chara
		addImage(chatbox, ImageTask.loadImage("chatbox.png"));
		addImage(gamma, ImageTask.loadImage("portrait\\gamma.png"));
		addImage(rebecca, ImageTask.loadImage("portrait\\rebecca.png"));
		addImage(sarah, ImageTask.loadImage("portrait\\sarah.png"));
		addImage(stephan, ImageTask.loadImage("portrait\\stephan.png"));
		addImage(rebecca_walking, ImageTask.loadImage("rebecca_walking.png"));
		addImage(foe_walking, ImageTask.loadImage("foe_walking.png"));

		// cards
		addImage(card_frame, ImageTask.loadImage("card_frame.png"));
		addImage(card_attack, ImageTask.loadImage("card_attack.png"));
		addImage(card_critical, ImageTask.loadImage("card_critical.png"));
		addImage(card_defense, ImageTask.loadImage("card_defense.png"));
		addImage(card_folder_gamma, ImageTask.loadImage("card_folder_gamma.png"));
		addImage(card_folder_soldier, ImageTask.loadImage("card_folder_soldier.png"));

		// other
		addImage(search_folder, ImageTask.loadImage("search_folder.png"));

	}
	
	// imageBank doesn't need to be more than new ImageBank()
	// bufferedImage is the path of the image
	public void addImage(ImageBank imageBank, BufferedImage bufferedImage) {

		if (bufferedImage != null)
			images.put(imageBank, bufferedImage);
	}
	
	public static BufferedImage getImage(ImageBank imageBank)
	{
		return images.get(imageBank);
	}
		
	

}
