package com.sunsigne.rebeccasreleasing.toverify.ressources.images;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;

public class ImageBank {

	// map or list

	private static Map<ImageBank, BufferedImage> images = new HashMap<>();

	// public for devs
	public static void addImage(ImageBank imageBank, BufferedImage bufferedImage) {

		if (bufferedImage != null)
			images.put(imageBank, bufferedImage);
	}

	public static BufferedImage getImage(ImageBank imageBank) {
		return images.get(imageBank);
	}

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

	public static final ImageBank options_screen = new ImageBank();

	public static final ImageBank chest = new ImageBank();
	public static final ImageBank arms = new ImageBank();
	public static final ImageBank head = new ImageBank();
	public static final ImageBank foe = new ImageBank();
	public static final ImageBank hat = new ImageBank();

	public static void loadRessources() {

		ImageTask imageTask = new ImageTask();
		
		loadMap();
		loadLiving();		
		
		// gui
		addImage(gui_battery_sheet, imageTask.loadImage("textures\\gui\\battery_sheet.png"));
		addImage(gui_data_sheet, imageTask.loadImage("textures\\gui\\data_sheet.png"));
		addImage(gui_tool_sheet, imageTask.loadImage("textures\\gui\\tool_sheet.png"));

		// puzzle
		addImage(puzzle_bomb_sheet, imageTask.loadImage("textures\\puzzle\\bomb_sheet.png"));
		addImage(puzzle_card_sheet, imageTask.loadImage("textures\\puzzle\\card_sheet.png"));
		addImage(puzzle_hack_sheet, imageTask.loadImage("textures\\puzzle\\hack_sheet.png"));
		addImage(puzzle_key_sheet, imageTask.loadImage("textures\\puzzle\\key_sheet.png"));
		addImage(puzzle_lazer_sheet, imageTask.loadImage("textures\\puzzle\\lazer_sheet.png"));
		addImage(puzzle_search, imageTask.loadImage("textures\\puzzle\\search.png"));

		// puzzler
		addImage(puzzler_wallcracked_sheet, imageTask.loadImage("textures\\puzzler\\wallcracked_sheet.png"));
		addImage(puzzler_computer_sheet, imageTask.loadImage("textures\\puzzler\\computer_sheet.png"));
		addImage(puzzler_case_sheet, imageTask.loadImage("textures\\puzzler\\case_sheet.png"));
		addImage(puzzler_door_sheet, imageTask.loadImage("textures\\puzzler\\door_sheet.png"));
		addImage(puzzler_lazer_sheet, imageTask.loadImage("textures\\puzzler\\lazer_sheet.png"));

		// destroyable
		addImage(destroyable_desk_sheet, imageTask.loadImage("textures\\destroyable\\desk_sheet.png"));
		addImage(destroyable_plant_sheet, imageTask.loadImage("textures\\destroyable\\plant_sheet.png"));

		// loot
		addImage(loot_tool_sheet, imageTask.loadImage("textures\\loot\\tool_sheet.png"));

		// decor
		addImage(decor_small_sheet, imageTask.loadImage("textures\\decor\\small_sheet.png"));
		addImage(decor_wall_sheet, imageTask.loadImage("textures\\decor\\wall_sheet.png"));

		// interface
		addImage(interface_chat, imageTask.loadImage("textures\\interface\\chat.png"));

		// title
		addImage(pierre_feuille_ciseaux_sheet,
				imageTask.loadImage("textures\\title_screen\\pierre_feuille_ciseaux_sheet.png"));
		addImage(pierre_feuille_ciseaux_com,
				imageTask.loadImage("textures\\title_screen\\pierre_feuille_ciseaux_com.png"));
		addImage(helmet_of_releasing, imageTask.loadImage("textures\\title_screen\\helmet_of_releasing.png"));

		addImage(title_1, imageTask.loadImage("textures\\title_screen\\title_1.png"));
		addImage(title_2, imageTask.loadImage("textures\\title_screen\\title_2.png"));

		addImage(options_screen, imageTask.loadImage("textures\\title_screen\\options_screen.png"));

		addImage(chest, imageTask.loadImage("textures\\title_screen\\chest.png"));
		addImage(arms, imageTask.loadImage("textures\\title_screen\\arms.png"));
		addImage(head, imageTask.loadImage("textures\\title_screen\\head.png"));
		addImage(foe, imageTask.loadImage("textures\\title_screen\\foe.png"));
		addImage(hat, imageTask.loadImage("textures\\title_screen\\hat.png"));

	}

	////////// LIVINGS ////////////

	static final ImageBank living_face_sheet = new ImageBank();
	static final ImageBank living_walking_sheet = new ImageBank();
	static final ImageBank living_battle_sheet = new ImageBank();

	static final ImageBank living_foe_face_sheet = new ImageBank();
	static final ImageBank living_foe_walking_sheet = new ImageBank();
	static final ImageBank living_foe_battle_sheet = new ImageBank();

	private static void loadLiving() {
		
		ImageTask imageTask = new ImageTask();
		
		addImage(living_face_sheet, imageTask.loadImage("textures\\living\\face_sheet.png"));
		addImage(living_walking_sheet, imageTask.loadImage("textures\\living\\walking_sheet.png"));
		addImage(living_battle_sheet, imageTask.loadImage("textures\\living\\battle_sheet.png"));

		addImage(living_foe_face_sheet, imageTask.loadImage("textures\\living\\foe_face_sheet.png"));
		addImage(living_foe_walking_sheet, imageTask.loadImage("textures\\living\\foe_walking_sheet.png"));
		addImage(living_foe_battle_sheet, imageTask.loadImage("textures\\living\\foe_battle_sheet.png"));
	}

	////////// MAPS ////////////

	public static final int FULL_MAP = 0;
	public static final int CUTOUT_MAP = 1;

	public static final ImageBank[] lvl01 = { new ImageBank(), new ImageBank() };
	public static final ImageBank[] lvl02 = { new ImageBank(), new ImageBank() };
	public static final ImageBank[] lvlTest = { new ImageBank(), new ImageBank() };

	private static void loadMap() {
		
		ImageTask imageTask = new ImageTask();
		
		addImage(lvl01[FULL_MAP], imageTask.loadImage("map\\lvl01.png"));
		addImage(lvl01[CUTOUT_MAP], imageTask.loadImage("map\\lvl01_cutout.png"));

		addImage(lvl02[FULL_MAP], imageTask.loadImage("map\\lvl02.png"));
		addImage(lvl02[CUTOUT_MAP], imageTask.loadImage("map\\lvl02_cutout.png"));

		addImage(lvlTest[FULL_MAP], imageTask.loadImage("map\\lvltest.png"));
		addImage(lvlTest[CUTOUT_MAP], imageTask.loadImage("map\\lvltest_cutout.png"));
	}

}
