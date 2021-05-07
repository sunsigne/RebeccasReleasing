package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class ImageBank {

	// map or list

	private static Map<ImageBank, BufferedImage> images = new HashMap<>();

	// Even if this method is only used in this class, I prefere to let it public
	// to make it easier for modders and devellopers in adding content
	public static void addImage(ImageBank imageBank, BufferedImage bufferedImage) {

		if (bufferedImage != null)
			images.put(imageBank, bufferedImage);
	}

	public static BufferedImage getImage(ImageBank imageBank) {
		return images.get(imageBank);
	}

	// living
	static final ImageBank living_face_sheet = new ImageBank();
	static final ImageBank living_walking_sheet = new ImageBank();
	static final ImageBank living_battle_sheet = new ImageBank();
	
	static final ImageBank living_foe_face_sheet = new ImageBank();
	static final ImageBank living_foe_walking_sheet = new ImageBank();	
	static final ImageBank living_foe_battle_sheet = new ImageBank();

	// gui
	static final ImageBank gui_battery_sheet = new ImageBank();
	static final ImageBank gui_data_sheet = new ImageBank();
	static final ImageBank gui_tool_sheet = new ImageBank();

	// puzzle
	static final ImageBank puzzle_bomb_sheet = new ImageBank();
	static final ImageBank puzzle_card_sheet = new ImageBank();
	static final ImageBank puzzle_hack_sheet = new ImageBank();
	static final ImageBank puzzle_key_sheet = new ImageBank();
	static final ImageBank puzzle_lazer_sheet = new ImageBank();
	static final ImageBank puzzle_search = new ImageBank();

	// puzzler
	static final ImageBank puzzler_wallcracked_sheet = new ImageBank();
	static final ImageBank puzzler_computer_sheet = new ImageBank();
	static final ImageBank puzzler_case_sheet = new ImageBank();
	static final ImageBank puzzler_door_sheet = new ImageBank();
	static final ImageBank puzzler_lazer_sheet = new ImageBank();

	// destroyable
	static final ImageBank destroyable_desk_sheet = new ImageBank();
	static final ImageBank destroyable_plant_sheet = new ImageBank();

	// loot
	static final ImageBank loot_tool_sheet = new ImageBank();

	// decor
	static final ImageBank decor_small_sheet = new ImageBank();
	static final ImageBank decor_wall_sheet = new ImageBank();

	// interface
	static final ImageBank interface_chat = new ImageBank();

	// title
	static final ImageBank pierre_feuille_ciseaux_sheet = new ImageBank();
	public static final ImageBank pierre_feuille_ciseaux_com = new ImageBank();
	public static final ImageBank helmet_of_releasing = new ImageBank();
	
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
	public static final ImageBank lvltest = new ImageBank();
	public static final ImageBank lvltest_cutout = new ImageBank();
	public static final ImageBank lvl001 = new ImageBank();
	public static final ImageBank lvl001_cutout = new ImageBank();
	public static final ImageBank lvl01 = new ImageBank();
	public static final ImageBank lvl01_cutout = new ImageBank();
	public static final ImageBank lvl02 = new ImageBank();
	public static final ImageBank lvl02_cutout = new ImageBank();
	public static final ImageBank lvl010 = new ImageBank();
	public static final ImageBank lvl010_cutout = new ImageBank();

	public static void loadRessources() {

		// living
		addImage(living_face_sheet, ImageTask.loadImage("living\\face_sheet.png"));
		addImage(living_walking_sheet, ImageTask.loadImage("living\\walking_sheet.png"));
		addImage(living_battle_sheet, ImageTask.loadImage("living\\battle_sheet.png"));
		
		addImage(living_foe_face_sheet, ImageTask.loadImage("living\\foe_face_sheet.png"));
		addImage(living_foe_walking_sheet, ImageTask.loadImage("living\\foe_walking_sheet.png"));
		addImage(living_foe_battle_sheet, ImageTask.loadImage("living\\foe_battle_sheet.png"));

		// gui
		addImage(gui_battery_sheet, ImageTask.loadImage("gui\\battery_sheet.png"));
		addImage(gui_data_sheet, ImageTask.loadImage("gui\\data_sheet.png"));
		addImage(gui_tool_sheet, ImageTask.loadImage("gui\\tool_sheet.png"));

		// puzzle
		addImage(puzzle_bomb_sheet, ImageTask.loadImage("puzzle\\bomb_sheet.png"));
		addImage(puzzle_card_sheet, ImageTask.loadImage("puzzle\\card_sheet.png"));
		addImage(puzzle_hack_sheet, ImageTask.loadImage("puzzle\\hack_sheet.png"));
		addImage(puzzle_key_sheet, ImageTask.loadImage("puzzle\\key_sheet.png"));
		addImage(puzzle_lazer_sheet, ImageTask.loadImage("puzzle\\lazer_sheet.png"));
		addImage(puzzle_search, ImageTask.loadImage("puzzle\\search.png"));

		// puzzler
		addImage(puzzler_wallcracked_sheet, ImageTask.loadImage("puzzler\\wallcracked_sheet.png"));
		addImage(puzzler_computer_sheet, ImageTask.loadImage("puzzler\\computer_sheet.png"));
		addImage(puzzler_case_sheet, ImageTask.loadImage("puzzler\\case_sheet.png"));
		addImage(puzzler_door_sheet, ImageTask.loadImage("puzzler\\door_sheet.png"));
		addImage(puzzler_lazer_sheet, ImageTask.loadImage("puzzler\\lazer_sheet.png"));

		// destroyable
		addImage(destroyable_desk_sheet, ImageTask.loadImage("destroyable\\desk_sheet.png"));
		addImage(destroyable_plant_sheet, ImageTask.loadImage("destroyable\\plant_sheet.png"));

		// loot
		addImage(loot_tool_sheet, ImageTask.loadImage("loot\\tool_sheet.png"));

		// decor
		addImage(decor_small_sheet, ImageTask.loadImage("decor\\small_sheet.png"));
		addImage(decor_wall_sheet, ImageTask.loadImage("decor\\wall_sheet.png"));

		// interface
		addImage(interface_chat, ImageTask.loadImage("interface\\chat.png"));

		// title
		addImage(pierre_feuille_ciseaux_sheet, ImageTask.loadImage("title_screen\\pierre_feuille_ciseaux_sheet.png"));
		addImage(pierre_feuille_ciseaux_com, ImageTask.loadImage("title_screen\\pierre_feuille_ciseaux_com.png"));
		addImage(helmet_of_releasing, ImageTask.loadImage("title_screen\\helmet_of_releasing.png"));

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
		addImage(lvltest, ImageTask.loadMapImage("lvltest.png"));
		addImage(lvltest_cutout, ImageTask.loadMapImage("lvltest_cutout.png"));
		addImage(lvl001, ImageTask.loadMapImage("lvl001.png"));
		addImage(lvl001_cutout, ImageTask.loadMapImage("lvl001_cutout.png"));
		addImage(lvl01, ImageTask.loadMapImage("lvl01.png"));
		addImage(lvl01_cutout, ImageTask.loadMapImage("lvl01_cutout.png"));
		addImage(lvl02, ImageTask.loadMapImage("lvl02.png"));
		addImage(lvl02_cutout, ImageTask.loadMapImage("lvl02_cutout.png"));
		addImage(lvl010, ImageTask.loadMapImage("lvl010.png"));
		addImage(lvl010_cutout, ImageTask.loadMapImage("lvl010_cutout.png"));

	}

}
