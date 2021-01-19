package com.sunsigne.rebeccasreleasing.ressources.images;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.puzzles.DIFFICULTY;

import objects.IFacing.FACING;

@Todo("ranger ce foutoir !")
public class TextureBank {

	private static TextureBank instance = null;

	// tool
	private SpriteSheet tool_sword_sheet;
	private SpriteSheet tool_key_sheet;

	// puzzler
	private SpriteSheet puzzler_wallcracked_sheet;
	private SpriteSheet puzzler_computer_sheet;
	private SpriteSheet puzzler_case_sheet;
	private SpriteSheet puzzler_door_sheet;

	// destroyable
	private SpriteSheet destroyable_plant_sheet;
	
	// living
	private SpriteSheet living_foe_battle_sheet;
	private SpriteSheet living_rebecca_battle_sheet;

	// tool
	public BufferedImage[] tool_sword = new BufferedImage[7];
	public BufferedImage[] tool_key = new BufferedImage[7];

	// puzzler
	public BufferedImage[] puzzler_wallcracked = new BufferedImage[7];
	public BufferedImage[][] puzzler_computer = new BufferedImage[7][2];
	public BufferedImage[][] puzzler_case = new BufferedImage[7][2];
	public BufferedImage[][] puzzler_door = new BufferedImage[7][4];

	// destroyable
	public BufferedImage[][] destroyable_plant = new BufferedImage[2][4];
	
	// living
	public BufferedImage[][] living_foe_battle = new BufferedImage[2][9];
	public BufferedImage[][] living_rebecca_battle = new BufferedImage[2][9];
	
	

	private SpriteSheet rebecca_sheet, foe_sheet, desk_sheet, neodesk_sheet, couch_sheet, battery_sheet, bomb_sheet,
			item_sheet, tool_sheet, hack_sheet, virus_sheet;

	public BufferedImage[] rebecca_walking = new BufferedImage[12];
	public BufferedImage[][] foe_walking = new BufferedImage[DIFFICULTY.MAX + 1][12];

	public BufferedImage[] desk = new BufferedImage[36];
	public BufferedImage[] neodesk = new BufferedImage[18];
	public BufferedImage[] dispenser = new BufferedImage[2];
	public BufferedImage[] lamp = new BufferedImage[1];

	public BufferedImage[][] couch = new BufferedImage[4][4];

	public BufferedImage[][] battery = new BufferedImage[DIFFICULTY.MAX + 1][DIFFICULTY.MAX + 1];

	public BufferedImage[] bomb = new BufferedImage[10];
	public BufferedImage[] item = new BufferedImage[38];
	public BufferedImage[] tool = new BufferedImage[2];
	public BufferedImage[] tool_cutout = new BufferedImage[2];

	public BufferedImage[] hack = new BufferedImage[15];
	public BufferedImage[] virus = new BufferedImage[2];


	public static TextureBank getInstance() {
		if (instance == null)
			instance = new TextureBank();
		return instance;
	}

	public void loadRessources() {

		// tool
		tool_sword_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.tool_sword_sheet));
		tool_key_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.tool_key_sheet));

		// puzzler
		puzzler_wallcracked_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_wallcracked_sheet));
		puzzler_computer_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_computer_sheet));
		puzzler_case_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_case_sheet));
		puzzler_door_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.puzzler_door_sheet));

		// destroyable
		destroyable_plant_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.destroyable_plant_sheet));

		//living
		living_foe_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_foe_battle_sheet));
		living_rebecca_battle_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.living_rebecca_battle_sheet));
		
		rebecca_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.rebecca_walking));
		foe_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.foe_walking));

		desk_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.desk_sheet));
		neodesk_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.neodesk_sheet));

		couch_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.couch_sheet));
		battery_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.battery_sheet));

		bomb_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.bomb_sheet));
		item_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.item_sheet));
		tool_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.tool_sheet));

		virus_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.virus_sheet));
		hack_sheet = new SpriteSheet(ImageBank.getImage(ImageBank.hack_sheet));

		

		getTextures();
	}

	@Todo("le design de la clef et du cadena font vieux, alors que celui de la porte est très moderne ..." + " "
			+ "Le desing du canapé est trop simpliste")
	private void getTextures() {

		for (int i = 0; i < 7; i++) {
			tool_sword[i] = tool_sword_sheet.grabImage(i, 1, 32, 32);
			tool_key[i] = tool_key_sheet.grabImage(i, 1, 32, 32);

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

		for (int i = 0; i < 4; i++) {
			destroyable_plant[FACING.LEFT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 1, 64, 32);
			destroyable_plant[FACING.RIGHT.getNum()][i] = destroyable_plant_sheet.grabImage(i + 1, 2, 64, 32);
		}
		
		for (int i = 0; i < 9; i++) {
			living_foe_battle[FACING.LEFT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_foe_battle[FACING.RIGHT.getNum()][i] = living_foe_battle_sheet.grabImage(i + 1, 2, 64, 64);			
			living_rebecca_battle[FACING.LEFT.getNum()][i] = living_rebecca_battle_sheet.grabImage(i + 1, 1, 64, 64);
			living_rebecca_battle[FACING.RIGHT.getNum()][i] = living_rebecca_battle_sheet.grabImage(i + 1, 2, 64, 64);
		}


		rebecca_walking[0] = rebecca_sheet.grabImage(1, 1, 48, 48); // up
		rebecca_walking[1] = rebecca_sheet.grabImage(2, 1, 48, 48);
		rebecca_walking[2] = rebecca_sheet.grabImage(3, 1, 48, 48);
		rebecca_walking[3] = rebecca_sheet.grabImage(1, 2, 48, 48); // down
		rebecca_walking[4] = rebecca_sheet.grabImage(2, 2, 48, 48);
		rebecca_walking[5] = rebecca_sheet.grabImage(3, 2, 48, 48);
		rebecca_walking[6] = rebecca_sheet.grabImage(1, 3, 48, 48); // left
		rebecca_walking[7] = rebecca_sheet.grabImage(2, 3, 48, 48);
		rebecca_walking[8] = rebecca_sheet.grabImage(3, 3, 48, 48);
		rebecca_walking[9] = rebecca_sheet.grabImage(1, 4, 48, 48); // right
		rebecca_walking[10] = rebecca_sheet.grabImage(2, 4, 48, 48);
		rebecca_walking[11] = rebecca_sheet.grabImage(3, 4, 48, 48);

		for (int i = DIFFICULTY.MIN; i < DIFFICULTY.MAX + 1; i++) {
			foe_walking[i][0] = foe_sheet.grabImage(1, 4 * i - 3, 48, 48); // up
			foe_walking[i][1] = foe_sheet.grabImage(2, 4 * i - 3, 48, 48);
			foe_walking[i][2] = foe_sheet.grabImage(3, 4 * i - 3, 48, 48);
			foe_walking[i][3] = foe_sheet.grabImage(1, 4 * i - 2, 48, 48); // down
			foe_walking[i][4] = foe_sheet.grabImage(2, 4 * i - 2, 48, 48);
			foe_walking[i][5] = foe_sheet.grabImage(3, 4 * i - 2, 48, 48);
			foe_walking[i][6] = foe_sheet.grabImage(1, 4 * i - 1, 48, 48); // left
			foe_walking[i][7] = foe_sheet.grabImage(2, 4 * i - 1, 48, 48);
			foe_walking[i][8] = foe_sheet.grabImage(3, 4 * i - 1, 48, 48);
			foe_walking[i][9] = foe_sheet.grabImage(1, 4 * i, 48, 48); // right
			foe_walking[i][10] = foe_sheet.grabImage(2, 4 * i, 48, 48);
			foe_walking[i][11] = foe_sheet.grabImage(3, 4 * i, 48, 48);
		}

		for (int i = 0; i < 10; i++) {
			bomb[i] = bomb_sheet.grabImage(i + 1, 1, 64, 64);
		}

		for (int i = 0; i < 12; i++) {
			desk[i] = desk_sheet.grabImage(i + 1, 1, 64, 64); // horizontal
		}

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 6; i++) {
				desk[i + 12 + 6 * j] = desk_sheet.grabImage(j + 1, i + 2, 64, 64); // vertical
				desk[i + 24 + 6 * j] = desk_sheet.grabImage(j + 5, i + 2, 64, 64); // vertical
			}
		}

		for (int i = 0; i < 6; i++) {
			neodesk[i] = neodesk_sheet.grabImage(1 + i, 1, 64, 64); // horizontal
			neodesk[i + 6] = neodesk_sheet.grabImage(1 + i, 2, 64, 64); // left
			neodesk[i + 12] = neodesk_sheet.grabImage(1 + i, 3, 64, 64); // right
		}

		dispenser[0] = desk_sheet.grabImage(5, 4, 32, 64); // water
		dispenser[1] = desk_sheet.grabImage(5, 6, 32, 64); // coffe
		lamp[0] = desk_sheet.grabImage(5, 9, 32, 32); // lamp

		battery[1][2] = battery_sheet.grabImage(1, 1, 32, 32);
		battery[2][2] = battery_sheet.grabImage(2, 1, 32, 32);
		battery[1][3] = battery_sheet.grabImage(1, 2, 32, 32);
		battery[2][3] = battery_sheet.grabImage(2, 2, 32, 32);
		battery[3][3] = battery_sheet.grabImage(3, 2, 32, 32);
		battery[1][4] = battery_sheet.grabImage(1, 3, 32, 32);
		battery[2][4] = battery_sheet.grabImage(2, 3, 32, 32);
		battery[3][4] = battery_sheet.grabImage(3, 3, 32, 32);
		battery[4][4] = battery_sheet.grabImage(4, 3, 32, 32);
		battery[1][5] = battery_sheet.grabImage(1, 4, 32, 32);
		battery[2][5] = battery_sheet.grabImage(2, 4, 32, 32);
		battery[3][5] = battery_sheet.grabImage(3, 4, 32, 32);
		battery[4][5] = battery_sheet.grabImage(4, 4, 32, 32);
		battery[5][5] = battery_sheet.grabImage(5, 4, 32, 32);

		couch[FACING.LEFT.getNum()][1] = ImageTask.drawMissingTexture(32, 32);
		couch[FACING.LEFT.getNum()][2] = couch_sheet.grabImage(2, 3, 32, 64);
		couch[FACING.LEFT.getNum()][3] = couch_sheet.grabImage(3, 2, 32, 96);
		couch[FACING.RIGHT.getNum()][1] = ImageTask.drawMissingTexture(32, 32);
		couch[FACING.RIGHT.getNum()][2] = couch_sheet.grabImage(5, 3, 32, 64);
		couch[FACING.RIGHT.getNum()][3] = couch_sheet.grabImage(4, 2, 32, 96);
		couch[FACING.UP.getNum()][1] = couch_sheet.grabImage(1, 1, 32, 32);
		couch[FACING.UP.getNum()][2] = couch_sheet.grabImage(1, 2, 64, 32);
		couch[FACING.UP.getNum()][3] = couch_sheet.grabImage(1, 3, 96, 32);
		couch[FACING.DOWN.getNum()][1] = couch_sheet.grabImage(6, 1, 32, 32);
		couch[FACING.DOWN.getNum()][2] = couch_sheet.grabImage(3, 2, 64, 32);
		couch[FACING.DOWN.getNum()][3] = couch_sheet.grabImage(2, 3, 96, 32);
		
		item[0] = item_sheet.grabImage(1, 1, 32, 32); // key
		item[1] = item_sheet.grabImage(2, 1, 32, 32); // lock
		item[2] = item_sheet.grabImage(3, 1, 32, 32); // wall
		item[3] = item_sheet.grabImage(4, 1, 32, 32); // wall maze
		item[12] = item_sheet.grabImage(3, 2, 32, 32); // timer
		item[13] = item_sheet.grabImage(4, 2, 32, 32); // heart full
		item[14] = item_sheet.grabImage(5, 2, 32, 32); // heart empty
		item[25] = item_sheet.grabImage(6, 3, 32, 32); // wall card
		item[30] = item_sheet.grabImage(1, 4, 32, 32); // wall bomb
		item[31] = item_sheet.grabImage(2, 4, 32, 32); // wall cracked
		item[32] = item_sheet.grabImage(3, 4, 32, 32); // wall hack
		item[35] = item_sheet.grabImage(6, 4, 32, 32); // wall top

		tool[0] = tool_sheet.grabImage(1, 1, 32, 32); // key
		tool[1] = tool_sheet.grabImage(2, 1, 32, 32); // foe
		tool_cutout[0] = tool_sheet.grabImage(1, 2, 32, 32); // key
		tool_cutout[1] = tool_sheet.grabImage(2, 2, 32, 32); // foe

		for (int i = 0; i < 5; i++) {
			hack[i] = hack_sheet.grabImage(i + 1, 1, 48, 48);
			hack[i + 5] = hack_sheet.grabImage(i + 1, 2, 48, 48);
			hack[i + 10] = hack_sheet.grabImage(i + 1, 3, 48, 48);
		}

		virus[0] = virus_sheet.grabImage(1, 1, 16, 16);
		virus[1] = virus_sheet.grabImage(2, 1, 16, 16);

	
	}

}
