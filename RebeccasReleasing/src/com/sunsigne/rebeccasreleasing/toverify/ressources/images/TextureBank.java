package com.sunsigne.rebeccasreleasing.toverify.ressources.images;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.ressources.images.ImageTask;
import com.sunsigne.rebeccasreleasing.ressources.images.SpriteSheet;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.Facing.DIRECTION;
import com.sunsigne.rebeccasreleasing.toverify.ressources.characters.CharacterBank;

public class TextureBank {

	// singleton

	private static TextureBank instance = null;

	public static TextureBank getInstance() {
		if (instance == null)
			instance = new TextureBank();
		return instance;
	}

	// living
	private SpriteSheet living_face_sheet;
	private SpriteSheet living_walking_sheet;
	private SpriteSheet living_battle_sheet;

	private SpriteSheet living_foe_face_sheet;
	private SpriteSheet living_foe_walking_sheet;
	private SpriteSheet living_foe_battle_sheet;

	// gui
	private SpriteSheet gui_battery_sheet;
	private SpriteSheet gui_data_sheet;
	private SpriteSheet gui_tool_sheet;

	// puzzle
	private SpriteSheet puzzle_bomb_sheet;
	private SpriteSheet puzzle_card_sheet;
	private SpriteSheet puzzle_hack_sheet;
	private SpriteSheet puzzle_key_sheet;
	private SpriteSheet puzzle_lazer_sheet;

	// puzzler
	private SpriteSheet puzzler_wallcracked_sheet;
	private SpriteSheet puzzler_computer_sheet;
	private SpriteSheet puzzler_case_sheet;
	private SpriteSheet puzzler_door_sheet;
	private SpriteSheet puzzler_lazer_sheet;

	// destroyable
	private SpriteSheet destroyable_desk_sheet;
	private SpriteSheet destroyable_plant_sheet;

	// loot
	private SpriteSheet loot_tool_sheet;

	// decor
	private SpriteSheet decor_small_sheet;
	private SpriteSheet decor_wall_sheet;

	// title
	private SpriteSheet pierre_feuille_ciseaux_sheet;

	// living
	private BufferedImage[][] living_face = new BufferedImage[9][16]; // - character - facing - state
	private BufferedImage[][][] living_walking = new BufferedImage[9][5][3]; // - character - facing - state
	private BufferedImage[][][] living_battle = new BufferedImage[9][2][18]; // - character - facing - state

	public BufferedImage[] living_foe_face = new BufferedImage[1]; // - state
	public BufferedImage[][][] living_foe_walking = new BufferedImage[7][4][4]; // - difficulty - facing - state
	public BufferedImage[][] living_foe_battle = new BufferedImage[2][21]; // - facing - state
	public BufferedImage[][] living_err_battle = new BufferedImage[2][21]; // - facing - state

	// gui
	public BufferedImage[][] gui_battery = new BufferedImage[8][8]; // - number of charge - max charge
	public BufferedImage[] gui_data = new BufferedImage[3]; // - state
	public BufferedImage[] gui_tool = new BufferedImage[5]; // - state

	// puzzle
	public BufferedImage[] puzzle_bomb = new BufferedImage[10]; // - state
	public BufferedImage[] puzzle_card = new BufferedImage[4]; // - state
	public BufferedImage[] puzzle_hack = new BufferedImage[15]; // - state
	public BufferedImage[] puzzle_key = new BufferedImage[2]; // - state
	public BufferedImage[] puzzle_lazer_color = new BufferedImage[36]; // - state
	public BufferedImage[] puzzle_lazer_wire = new BufferedImage[6]; // - state
	public BufferedImage puzzle_search;

	// puzzler
	public BufferedImage[] puzzler_wallcracked = new BufferedImage[7]; // - difficulty
	public BufferedImage[][] puzzler_computer = new BufferedImage[7][2]; // - difficulty - state
	public BufferedImage[][] puzzler_case = new BufferedImage[7][2]; // - difficulty - state
	public BufferedImage[][] puzzler_door = new BufferedImage[7][4]; // - difficulty - state
	public BufferedImage[][][] puzzler_lazer = new BufferedImage[7][7][2]; // - difficulty - facing - state

	// destroyable
	public BufferedImage[][] destroyable_desk = new BufferedImage[4][6]; // - facing - state
	public BufferedImage[][] destroyable_plant = new BufferedImage[2][4]; // - facing - state

	// loot
	public BufferedImage[][] loot_tool = new BufferedImage[7][5]; // - difficulty - state

	// decor
	public BufferedImage[] decor_small = new BufferedImage[5]; // - state
	public BufferedImage[] decor_wall = new BufferedImage[6]; // - state

	// title
	public BufferedImage[] pierre_feuille_ciseaux = new BufferedImage[4]; // - state

	// interface
	public BufferedImage interface_chat;

	public void loadRessources() {

		// living
		living_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_face_sheet));
		living_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_walking_sheet));
		living_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_battle_sheet));

		living_foe_face_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_face_sheet));
		living_foe_walking_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_walking_sheet));
		living_foe_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_battle_sheet));

		// gui
		gui_battery_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_battery_sheet));
		gui_data_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_data_sheet));
		gui_tool_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.gui_tool_sheet));

		// puzzle
		puzzle_bomb_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_bomb_sheet));
		puzzle_card_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_card_sheet));
		puzzle_hack_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_hack_sheet));
		puzzle_key_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_key_sheet));
		puzzle_lazer_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzle_lazer_sheet));
		puzzle_search = ImageBank.getImage(ImageBank.puzzle_search);

		// puzzler
		puzzler_wallcracked_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_wallcracked_sheet));
		puzzler_computer_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_computer_sheet));
		puzzler_case_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_case_sheet));
		puzzler_door_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_door_sheet));
		puzzler_lazer_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_lazer_sheet));

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

	public BufferedImage getLivingFace(CharacterBank characterBank, int state) {
		return living_face[CharacterBank.getCharacter(characterBank).getId()][state];
	}

	public BufferedImage getLivingWalking(CharacterBank characterBank, int facing, int state) {
		return living_walking[CharacterBank.getCharacter(characterBank).getId()][facing][state];
	}

	public BufferedImage getLivingBattle(CharacterBank characterBank, int facing, int state) {
		BufferedImage img = new ImageTask().drawMissingTexture(64, 64);
		if (CharacterBank.getCharacter(characterBank).hasBattleAnimation())
			img = living_battle[CharacterBank.getCharacter(characterBank).getId()][facing][state];
		return img;
	}

	private void getTextures() {

		// living

		getCharacterTextures();

		// gui
		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 7; i++) {

				gui_battery[i][j] = gui_battery_sheet.grabImage(i, j, 32, 32);
			}
		}

		for (int i = 0; i < 3; i++) {
			gui_data[i] = gui_data_sheet.grabImage(i + 1, 1, 32, 32);
		}

		for (int i = 0; i < 5; i++) {
			gui_tool[i] = gui_tool_sheet.grabImage(i + 1, 1, 32, 32);
		}

		// puzzle
		for (int i = 0; i < 10; i++) {
			puzzle_bomb[i] = puzzle_bomb_sheet.grabImage(i + 1, 1, 64, 64);
		}

		for (int i = 0; i < 4; i++) {
			puzzle_card[i] = puzzle_card_sheet.grabImage(i + 1, 1, 256, 384);
		}

		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 5; i++) {
				puzzle_hack[i + 5 * j] = puzzle_hack_sheet.grabImage(i + 1, j + 1, 48, 48);
			}
		}

		puzzle_key[0] = puzzle_key_sheet.grabImage(1, 1, 32, 32); // key
		puzzle_key[1] = puzzle_key_sheet.grabImage(2, 1, 32, 32); // lock

		for (int i = 0; i < 6; i++) {
			puzzle_lazer_wire[i] = puzzle_lazer_sheet.grabImage(i + 1, 1, 16, 192);
		}

		for (int j = 0; j < 3; j++) {

			for (int i = 0; i < 12; i++) {
				puzzle_lazer_color[i + (j * 12)] = puzzle_lazer_sheet.grabImage(j + 2, i + 1, 96, 16);
			}
		}

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

			for (int j = 0; j < 6; j++) {

				puzzler_lazer[i][j][0] = puzzler_lazer_sheet.grabImage(2 * i - 1, j + 1, 32, 32);
				puzzler_lazer[i][j][1] = puzzler_lazer_sheet.grabImage(2 * i, j + 1, 32, 32);

			}
		}

		// destroyable

		for (int i = 0; i < 6; i++) {
			destroyable_desk[DIRECTION.LEFT.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 1, 64, 64);
			destroyable_desk[DIRECTION.RIGHT.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 2, 64, 64);
			destroyable_desk[DIRECTION.UP.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 3, 64, 64);
			destroyable_desk[DIRECTION.DOWN.getNum()][i] = destroyable_desk_sheet.grabImage(i + 1, 4, 64, 64);
		}

		for (int i = 0; i < 4; i++) {
			destroyable_plant[DIRECTION.LEFT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 1, 64, 32);
			destroyable_plant[DIRECTION.RIGHT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 2, 64, 32);
		}

		// loot
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 7; i++) {
				loot_tool[i][j] = loot_tool_sheet.grabImage(i, j + 1, 32, 32);
			}
		}

		// decor

		for (int i = 0; i < 5; i++) {
			decor_small[i] = decor_small_sheet.grabImage(i + 1, 1, 32, 32);
		}

		for (int i = 0; i < 6; i++) {
			decor_wall[i] = decor_wall_sheet.grabImage(i + 1, 1, 32, 32); // world
		}

		// title

		for (int i = 0; i < 4; i++) {
			pierre_feuille_ciseaux[i] = pierre_feuille_ciseaux_sheet.grabImage(i + 1, 1, 1186, 613);
		}

	}

	private void getCharacterTextures() {
		getNPCTextures();
		getFoesTexture();
	}

	private void getNPCTextures() {

		int count = -1;
		for (CharacterBank characterBank : CharacterBank.characters.keySet()) {
			count++;
			int col = CharacterBank.getCharacter(characterBank).getCol();
			int row = CharacterBank.getCharacter(characterBank).getRow();
			CharacterBank.getCharacter(characterBank).setId(count);

			for (int i = 0; i < 4; i++) {
				living_face[count][i] = living_face_sheet.grabImage(4 * col + i - 3, 1 + (4 * row - 4), 144, 144);
				living_face[count][i + 4] = living_face_sheet.grabImage(4 * col + i - 3, 2 + (4 * row - 4), 144, 144);
				living_face[count][i + 8] = living_face_sheet.grabImage(4 * col + i - 3, 3 + (4 * row - 4), 144, 144);
				living_face[count][i + 12] = living_face_sheet.grabImage(4 * col + i - 3, 4 + (4 * row - 4), 144, 144);
			}

			for (int i = 0; i < 3; i++) {
				living_walking[count][DIRECTION.LEFT.getNum()][i] = living_walking_sheet.grabImage((3 * col + i - 2),
						1 + (5 * row - 5), 48, 48);
				living_walking[count][DIRECTION.RIGHT.getNum()][i] = living_walking_sheet.grabImage((3 * col + i - 2),
						2 + (5 * row - 5), 48, 48);
				living_walking[count][DIRECTION.UP.getNum()][i] = living_walking_sheet.grabImage((3 * col + i - 2),
						3 + (5 * row - 5), 48, 48);
				living_walking[count][DIRECTION.DOWN.getNum()][i] = living_walking_sheet.grabImage((3 * col + i - 2),
						4 + (5 * row - 5), 48, 48);
				living_walking[count][4/* ON THE GROUND */][i] = living_walking_sheet.grabImage((3 * col + i - 2),
						5 + (5 * row - 5), 48, 48);
			}

			if (!CharacterBank.getCharacter(characterBank).hasBattleAnimation())
				continue;

			for (int i = 0; i < 6; i++) {
				living_battle[count][DIRECTION.LEFT.getNum()][i] = living_battle_sheet.grabImage((6 * col + i - 5),
						1 + (6 * row - 6), 64, 64);
				living_battle[count][DIRECTION.LEFT.getNum()][i + 6] = living_battle_sheet.grabImage((6 * col + i - 5),
						2 + (6 * row - 6), 64, 64);
				living_battle[count][DIRECTION.LEFT.getNum()][i + 12] = living_battle_sheet.grabImage((6 * col + i - 5),
						3 + (6 * row - 6), 64, 64);
				living_battle[count][DIRECTION.RIGHT.getNum()][i] = living_battle_sheet.grabImage((6 * col + i - 5),
						4 + (6 * row - 6), 64, 64);
				living_battle[count][DIRECTION.RIGHT.getNum()][i + 6] = living_battle_sheet.grabImage((6 * col + i - 5),
						5 + (6 * row - 6), 64, 64);
				living_battle[count][DIRECTION.RIGHT.getNum()][i + 12] = living_battle_sheet.grabImage((6 * col + i - 5),
						6 + (6 * row - 6), 64, 64);
			}
		}
	}

	private void getFoesTexture() {

		living_foe_face[0] = living_foe_face_sheet.grabImage(1, 1, 144, 144);

		for (int j = 0; j < 7; j++) {
			for (int i = 0; i < 4; i++) {
				living_foe_walking[j][DIRECTION.LEFT.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						1, 48, 48);
				living_foe_walking[j][DIRECTION.RIGHT.getNum()][i] = living_foe_walking_sheet
						.grabImage(i + 1 + 4 * (j - 1), 2, 48, 48);
				living_foe_walking[j][DIRECTION.UP.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						3, 48, 48);
				living_foe_walking[j][DIRECTION.DOWN.getNum()][i] = living_foe_walking_sheet.grabImage(i + 1 + 4 * (j - 1),
						4, 48, 48);
			}
		}

		for (int i = 0; i < 21; i++) {
			living_foe_battle[DIRECTION.LEFT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_foe_battle[DIRECTION.RIGHT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 2, 64, 64);
			living_err_battle[DIRECTION.LEFT.getNum()][i] = new ImageTask().drawMissingTexture(64, 64);
			living_err_battle[DIRECTION.RIGHT.getNum()][i] = new ImageTask().drawMissingTexture(64, 64);
		}
	}

}
