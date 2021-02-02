package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.options.LANGUAGE;

import objects.IFacing.FACING;

public class TextureBank {

	// singleton
	
	private static TextureBank instance = null;

	public static TextureBank getInstance() {
		if (instance == null)
			instance = new TextureBank();
		return instance;
	}

	// living
	private SpriteSheet living_foe_battle_sheet;
	private SpriteSheet living_gamma_battle_sheet;
	private SpriteSheet living_rebecca_battle_sheet;
	private SpriteSheet living_sarah_battle_sheet;
	private SpriteSheet living_vladimir_battle_sheet;

	private SpriteSheet living_foe_walking_sheet;
	private SpriteSheet living_gamma_walking_sheet;
	private SpriteSheet living_rebecca_walking_sheet;
	private SpriteSheet living_sarah_walking_sheet;
	private SpriteSheet living_vladimir_walking_sheet;

	private SpriteSheet living_foe_face_sheet;
	private SpriteSheet living_gamma_face_sheet;
	private SpriteSheet living_rebecca_face_sheet;
	private SpriteSheet living_sarah_face_sheet;
	private SpriteSheet living_vladimir_face_sheet;
	
	// gui
	private SpriteSheet gui_battery_sheet;
	private SpriteSheet gui_data_sheet;
	private SpriteSheet gui_tool_sheet;

	// puzzle
	private SpriteSheet puzzle_bomb_sheet;
	private SpriteSheet puzzle_card_sheet;
	private SpriteSheet puzzle_hack_sheet;
	private SpriteSheet puzzle_key_sheet;

	// puzzler
	private SpriteSheet puzzler_wallcracked_sheet;
	private SpriteSheet puzzler_computer_sheet;
	private SpriteSheet puzzler_case_sheet;
	private SpriteSheet puzzler_door_sheet;

	// destroyable
	private SpriteSheet destroyable_desk_sheet;
	private SpriteSheet destroyable_plant_sheet;

	// loot
	private SpriteSheet loot_tool_sheet;

	// decor
	private SpriteSheet decor_small_sheet;
	private SpriteSheet decor_wall_sheet;

	//title
	private SpriteSheet pierre_feuille_ciseaux_sheet;
	
	// living
	public BufferedImage[][] living_foe_battle = new BufferedImage[2][21]; // - facing - state
	public BufferedImage[][] living_gamma_battle = new BufferedImage[2][21]; // - facing - state
	public BufferedImage[][] living_rebecca_battle = new BufferedImage[2][21]; // - facing - state
	public BufferedImage[][][] living_sarah_battle = new BufferedImage[2][2][21]; // - helmet - facing - state
	public BufferedImage[][] living_vladimir_battle = new BufferedImage[2][21]; // - facing - state
	public BufferedImage[][] living_err_battle = new BufferedImage[2][21]; // - facing - state

	public BufferedImage[][][] living_foe_walking = new BufferedImage[7][4][4]; // - difficulty - facing - state
	public BufferedImage[][] living_gamma_walking = new BufferedImage[4][4]; // - facing - state
	public BufferedImage[][] living_rebecca_walking = new BufferedImage[4][4]; // - facing - state
	public BufferedImage[][][] living_sarah_walking = new BufferedImage[2][4][4]; // - helmet - facing - state
	public BufferedImage[][] living_vladimir_walking = new BufferedImage[4][4]; // - facing - state

	public BufferedImage[] living_foe_face = new BufferedImage[1]; // - state
	public BufferedImage[] living_gamma_face = new BufferedImage[1]; // - state
	public BufferedImage[] living_rebecca_face = new BufferedImage[1]; // - state
	public BufferedImage[][] living_sarah_face = new BufferedImage[2][1]; // - helmet - state
	public BufferedImage[] living_vladimir_face = new BufferedImage[1]; // - state
	
	// gui
	public BufferedImage[][] gui_battery = new BufferedImage[8][8]; // - number of charge - max charge
	public BufferedImage[] gui_data = new BufferedImage[3]; // - state
	public BufferedImage[] gui_tool = new BufferedImage[4]; // - state

	// puzzle
	public BufferedImage[] puzzle_bomb = new BufferedImage[10]; // - state
	public BufferedImage[][] puzzle_card = new BufferedImage[3][3]; // - language - state
	public BufferedImage[] puzzle_hack = new BufferedImage[15]; // - state
	public BufferedImage[] puzzle_key = new BufferedImage[2]; // - state
	public BufferedImage puzzle_search;

	// puzzler
	public BufferedImage[] puzzler_wallcracked = new BufferedImage[7]; // - difficulty
	public BufferedImage[][] puzzler_computer = new BufferedImage[7][2]; // - difficulty - state
	public BufferedImage[][] puzzler_case = new BufferedImage[7][2]; // - difficulty - state
	public BufferedImage[][] puzzler_door = new BufferedImage[7][4]; // - difficulty - state

	// destroyable
	public BufferedImage[][] destroyable_desk = new BufferedImage[4][6]; // - facing - state
	public BufferedImage[][] destroyable_plant = new BufferedImage[2][4]; // - facing - state

	// loot
	public BufferedImage[][] loot_tool = new BufferedImage[7][4]; // - difficulty - state

	// decor
	public BufferedImage[] decor_small = new BufferedImage[3]; // - state
	public BufferedImage[] decor_wall = new BufferedImage[5]; // - state

	// title
	public BufferedImage[] pierre_feuille_ciseaux = new BufferedImage[4]; // - state
	
	// interface
	public BufferedImage interface_chat;
	
	
	public void loadRessources() {

		// living
		living_foe_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_battle_sheet));
		living_gamma_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_gamma_battle_sheet));
		living_rebecca_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_rebecca_battle_sheet));
		living_sarah_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_sarah_battle_sheet));
		living_vladimir_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_vladimir_battle_sheet));

		living_foe_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_walking_sheet));
		living_gamma_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_gamma_walking_sheet));
		living_rebecca_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_rebecca_walking_sheet));
		living_sarah_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_sarah_walking_sheet));
		living_vladimir_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_vladimir_walking_sheet));

		living_foe_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_face_sheet));
		living_gamma_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_gamma_face_sheet));
		living_rebecca_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_rebecca_face_sheet));
		living_sarah_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_sarah_face_sheet));
		living_vladimir_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_vladimir_face_sheet));
		
		// gui
		gui_battery_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_battery_sheet));
		gui_data_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_data_sheet));
		gui_tool_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_tool_sheet));

		// puzzle
		puzzle_bomb_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_bomb_sheet));
		puzzle_card_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_card_sheet));
		puzzle_hack_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_hack_sheet));
		puzzle_key_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_key_sheet));
		puzzle_search = ImageBank.getImage(ImageBank.puzzle_search);

		// puzzler
		puzzler_wallcracked_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_wallcracked_sheet));
		puzzler_computer_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_computer_sheet));
		puzzler_case_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_case_sheet));
		puzzler_door_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_door_sheet));

		// destroyable
		destroyable_desk_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.destroyable_desk_sheet));
		destroyable_plant_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.destroyable_plant_sheet));

		// loot
		loot_tool_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.loot_tool_sheet));

		// decor
		decor_small_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.decor_small_sheet));
		decor_wall_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.decor_wall_sheet));

		// title
		pierre_feuille_ciseaux_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.pierre_feuille_ciseaux_sheet));
		
		// interface
		interface_chat = ImageBank.getImage(ImageBank.interface_chat);
		
		getTextures();
	}

	@Todo("le design de la clef et du cadena font vieux & le desing du canapé est trop simpliste")
	private void getTextures() {

		// living
		for (int i = 0; i < 21; i++) {
			living_foe_battle[FACING.LEFT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_foe_battle[FACING.RIGHT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_gamma_battle[FACING.LEFT.getNum()][i] = living_gamma_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_gamma_battle[FACING.RIGHT.getNum()][i] = living_gamma_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_rebecca_battle[FACING.LEFT.getNum()][i] = living_rebecca_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_rebecca_battle[FACING.RIGHT.getNum()][i] = living_rebecca_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_sarah_battle[0][FACING.LEFT.getNum()][i] = living_sarah_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_sarah_battle[0][FACING.RIGHT.getNum()][i] = living_sarah_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_sarah_battle[1][FACING.LEFT.getNum()][i] = living_sarah_battle_sheet.grabImage(i + 1, 3, 64, 64);
			living_sarah_battle[1][FACING.RIGHT.getNum()][i] = living_sarah_battle_sheet.grabImage(i + 1, 4, 64, 64);
			living_vladimir_battle[FACING.LEFT.getNum()][i] = living_vladimir_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_vladimir_battle[FACING.RIGHT.getNum()][i] = living_vladimir_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_err_battle[FACING.LEFT.getNum()][i] = ImageTask.drawMissingTexture(64, 64);
			living_err_battle[FACING.RIGHT.getNum()][i] = ImageTask.drawMissingTexture(64, 64);
		}

		for (int i = 0; i < 4; i++) {
			living_gamma_walking[FACING.LEFT.getNum()][i] = living_gamma_walking_sheet.grabImage(i + 1, 1, 48, 48);
			living_gamma_walking[FACING.RIGHT.getNum()][i] = living_gamma_walking_sheet.grabImage(i + 1, 2, 48, 48);
			living_gamma_walking[FACING.UP.getNum()][i] = living_gamma_walking_sheet.grabImage(i + 1, 3, 48, 48);
			living_gamma_walking[FACING.DOWN.getNum()][i] = living_gamma_walking_sheet.grabImage(i + 1, 4, 48, 48);
			
			living_rebecca_walking[FACING.LEFT.getNum()][i] = living_rebecca_walking_sheet.grabImage(i + 1, 1, 48, 48);
			living_rebecca_walking[FACING.RIGHT.getNum()][i] = living_rebecca_walking_sheet.grabImage(i + 1, 2, 48, 48);
			living_rebecca_walking[FACING.UP.getNum()][i] = living_rebecca_walking_sheet.grabImage(i + 1, 3, 48, 48);
			living_rebecca_walking[FACING.DOWN.getNum()][i] = living_rebecca_walking_sheet.grabImage(i + 1, 4, 48, 48);
			
			living_sarah_walking[0][FACING.LEFT.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 1, 48, 48);
			living_sarah_walking[0][FACING.RIGHT.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 2, 48, 48);
			living_sarah_walking[0][FACING.UP.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 3, 48, 48);
			living_sarah_walking[0][FACING.DOWN.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 4, 48, 48);
			
			living_sarah_walking[1][FACING.LEFT.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 5, 48, 48);
			living_sarah_walking[1][FACING.RIGHT.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 6, 48, 48);
			living_sarah_walking[1][FACING.UP.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 7, 48, 48);
			living_sarah_walking[1][FACING.DOWN.getNum()][i] = living_sarah_walking_sheet.grabImage(i + 1, 8, 48, 48);
			
			living_vladimir_walking[FACING.LEFT.getNum()][i] = living_vladimir_walking_sheet.grabImage(i + 1, 1, 48, 48);
			living_vladimir_walking[FACING.RIGHT.getNum()][i] = living_vladimir_walking_sheet.grabImage(i + 1, 2, 48, 48);
			living_vladimir_walking[FACING.UP.getNum()][i] = living_vladimir_walking_sheet.grabImage(i + 1, 3, 48, 48);
			living_vladimir_walking[FACING.DOWN.getNum()][i] = living_vladimir_walking_sheet.grabImage(i + 1, 4, 48, 48);
		}

		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 4; i++) {
				living_foe_walking[j][FACING.LEFT.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						1, 48, 48);
				living_foe_walking[j][FACING.RIGHT.getNum()][i] = living_foe_walking_sheet
						.grabImage(i + 1 + 4 * (j - 1), 2, 48, 48);
				living_foe_walking[j][FACING.UP.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						3, 48, 48);
				living_foe_walking[j][FACING.DOWN.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						4, 48, 48);
			}
		}
		
		living_foe_face[0] = living_foe_face_sheet.grabImage(1, 1, 144, 144);
		living_gamma_face[0] = living_gamma_face_sheet.grabImage(1, 1, 144, 144);
		living_rebecca_face[0] = living_rebecca_face_sheet.grabImage(1, 1, 144, 144);
		living_sarah_face[0][0] = living_sarah_face_sheet.grabImage(1, 1, 144, 144);
		living_sarah_face[1][0] = living_sarah_face_sheet.grabImage(1, 2, 144, 144);
		living_vladimir_face[0] = living_vladimir_face_sheet.grabImage(1, 1, 144, 144);

		// gui
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 7; i++) {

				gui_battery[i][j] = gui_battery_sheet.grabImage(i, j, 32, 32);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			gui_data[i] = gui_data_sheet.grabImage(i + 1, 1, 32, 32);
		}

		for (int i = 0; i < 4; i++) {
			gui_tool[i] = gui_tool_sheet.grabImage(i + 1, 1, 32, 32);
		}

		// puzzle
		for (int i = 0; i < 10; i++) {
			puzzle_bomb[i] = puzzle_bomb_sheet.grabImage(i + 1, 1, 64, 64);
		}

		for (int i = 0; i < 3; i++) {
			puzzle_card[0][i] = ImageTask.drawMissingTexture(256, 384);
			puzzle_card[LANGUAGE.ENGLISH.getNum()][i] = puzzle_card_sheet.grabImage(i + 2, 1, 256, 384);
			puzzle_card[LANGUAGE.FRENCH.getNum()][i] = puzzle_card_sheet.grabImage(i + 2, 1, 256, 384);
		}

		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 5; i++) {
				puzzle_hack[i + 5 * j] = puzzle_hack_sheet.grabImage(i + 1, j + 1, 48, 48);
			}
		}

		puzzle_key[0] = puzzle_key_sheet.grabImage(1, 1, 32, 32); // key
		puzzle_key[1] = puzzle_key_sheet.grabImage(2, 1, 32, 32); // lock

		// puzzler
		for (int i = 0; i < 7; i++) {

			puzzler_wallcracked[i] = puzzler_wallcracked_sheet.grabImage(i, 1, 32, 32);

			puzzler_computer[i][0] = puzzler_computer_sheet.grabImage(i, 1, 32, 32); // running
			puzzler_computer[i][1] = puzzler_computer_sheet.grabImage(i, 2, 32, 32); // down

			puzzler_case[i][0] = puzzler_case_sheet.grabImage(i, 1, 32, 64); // close
			puzzler_case[i][1] = puzzler_case_sheet.grabImage(i, 2, 32, 64); // open

			puzzler_door[i][0] = puzzler_door_sheet.grabImage(2 * i - 1, 1, 32, 64); // vertical close
			puzzler_door[i][1] = puzzler_door_sheet.grabImage(2 * i, 1, 32, 64); // vertical open
			puzzler_door[i][2] = puzzler_door_sheet.grabImage(i, 3, 64, 32); // horizontal close
			puzzler_door[i][3] = puzzler_door_sheet.grabImage(i, 4, 64, 32); // horizontal open
		}

		// destroyable

		for (int i = 0; i < 6; i++) {
			destroyable_desk[FACING.LEFT.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 1, 64, 64);
			destroyable_desk[FACING.RIGHT.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 2, 64, 64);
			destroyable_desk[FACING.UP.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 4, 64, 64);
			destroyable_desk[FACING.DOWN.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 4, 64, 64);
		}

		for (int i = 0; i < 4; i++) {
			destroyable_plant[FACING.LEFT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 1, 64, 32);
			destroyable_plant[FACING.RIGHT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 2, 64, 32);
		}

		// loot
		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 7; i++) {
				loot_tool[i][j] = loot_tool_sheet.grabImage(i, j + 1, 32, 32);
			}
		}

		// decor

		for (int i = 0; i < 3; i++) {
			decor_small[i] = decor_small_sheet.grabImage(i + 1, 1, 32, 32);
		}

		for (int i = 0; i < 5; i++) {
			decor_wall[i] = decor_wall_sheet.grabImage(i + 1, 1, 32, 32); // world
		}

		// title
		
		for (int i = 0; i < 4; i++) {
			pierre_feuille_ciseaux[i] = pierre_feuille_ciseaux_sheet.grabImage(i + 1, 1, 1186, 613);
		}
		
	}

}
