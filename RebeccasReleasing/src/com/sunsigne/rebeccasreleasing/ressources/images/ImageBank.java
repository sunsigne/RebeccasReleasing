package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageBank {

	private static Map<ImageBank, BufferedImage> images = new HashMap<>();

	// Even if this method is only used in this class, I prefered to let it public
	// to make it easier for modders and devellopers in adding content 
	public static void addImage(ImageBank imageBank, BufferedImage bufferedImage) {

		if (bufferedImage != null)
			images.put(imageBank, bufferedImage);
	}

	public static BufferedImage getImage(ImageBank imageBank) {
		return images.get(imageBank);
	}
	
	
	// tool
	public static final ImageBank tool_sword_sheet = new ImageBank();
	public static final ImageBank tool_key_sheet = new ImageBank();
	
	// puzzler
	public static final ImageBank puzzler_wallcracked_sheet = new ImageBank();
	public static final ImageBank puzzler_computer_sheet = new ImageBank();
	public static final ImageBank puzzler_case_sheet = new ImageBank();
	public static final ImageBank puzzler_door_sheet = new ImageBank();
	
	// destroyable
	public static final ImageBank destroyable_plant_sheet = new ImageBank();
	
	// living
	public static final ImageBank living_rebecca_battle_sheet = new ImageBank();
	
	
	

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
	public static final ImageBank neodesk_sheet = new ImageBank();
	
	public static final ImageBank couch_sheet = new ImageBank();
	public static final ImageBank bomb_sheet = new ImageBank();
	public static final ImageBank item_sheet = new ImageBank();
	public static final ImageBank tool_sheet = new ImageBank();
	
	
	
	
	

	

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

	public static void loadRessources() {
		
		// tool
		addImage(tool_sword_sheet, ImageTask.loadImage("tool\\sword_sheet.png"));
		addImage(tool_key_sheet, ImageTask.loadImage("tool\\key_sheet.png"));
		
		// puzzler
		addImage(puzzler_wallcracked_sheet, ImageTask.loadImage("puzzler\\wallcracked_sheet.png"));
		addImage(puzzler_computer_sheet, ImageTask.loadImage("puzzler\\computer_sheet.png"));
		addImage(puzzler_case_sheet, ImageTask.loadImage("puzzler\\case_sheet.png"));
		addImage(puzzler_door_sheet, ImageTask.loadImage("puzzler\\door_sheet.png"));
		
		// destroyable
		addImage(destroyable_plant_sheet, ImageTask.loadImage("destroyable\\plant_sheet.png"));
		
		// living
		addImage(living_rebecca_battle_sheet, ImageTask.loadImage("living\\rebecca_battle_sheet.png"));
		
		
		
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
		addImage(neodesk_sheet, ImageTask.loadImage("neodesk_sheet.png"));
		
		addImage(couch_sheet, ImageTask.loadImage("couch_sheet.png"));
		addImage(bomb_sheet, ImageTask.loadImage("bomb_sheet.png"));
		addImage(item_sheet, ImageTask.loadImage("item_sheet.png"));
		addImage(tool_sheet, ImageTask.loadImage("tool_sheet.png"));
		addImage(hack_sheet, ImageTask.loadImage("hack_sheet.png"));
		addImage(virus_sheet, ImageTask.loadImage("virus_sheet.png"));
		
		

		
		

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

}
