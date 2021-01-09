package tofinish;

import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.ressources.images.ImageBank;
import com.sunsigne.rebeccasreleasing.ressources.images.SpriteSheet;

@Todo("ranger ce foutoir !")
public class TextureBank {

	private static TextureBank instance = null;
	
	private SpriteSheet rebecca_sheet, desk_sheet, door_sheet, couch_sheet, battery_sheet, bomb_sheet, item_sheet, 
		tool_sheet, hack_sheet,	virus_sheet;

	public BufferedImage[] rebecca_walking = new BufferedImage[12];

	public BufferedImage[] desk = new BufferedImage[24];
	public BufferedImage[] dispenser = new BufferedImage[2];
	public BufferedImage[] lamp = new BufferedImage[1];
	public BufferedImage[][] door = new BufferedImage[6][4];
	public BufferedImage[] plant = new BufferedImage[4];
	public BufferedImage[] couch = new BufferedImage[10];
	
	public BufferedImage[][] battery = new BufferedImage[6][6];

	public BufferedImage[] bomb = new BufferedImage[10];
	public BufferedImage[] item = new BufferedImage[38];
	public BufferedImage[] tool = new BufferedImage[2];

	public BufferedImage[] hack = new BufferedImage[15];
	public BufferedImage[] virus = new BufferedImage[2];

	public static TextureBank getInstance() {
		if (instance == null)
			instance = new TextureBank();
		return instance;
	}
	
	public void loadRessources() {

		rebecca_sheet = new SpriteSheet(ImageBank.rebecca_walking);

		desk_sheet = new SpriteSheet(ImageBank.desk_sheet);
		door_sheet = new SpriteSheet(ImageBank.door_sheet);
		couch_sheet = new SpriteSheet(ImageBank.couch_sheet);
		battery_sheet = new SpriteSheet(ImageBank.battery_sheet);

		bomb_sheet = new SpriteSheet(ImageBank.bomb_sheet);
		item_sheet = new SpriteSheet(ImageBank.item_sheet);
		tool_sheet = new SpriteSheet(ImageBank.tool_sheet);

		virus_sheet = new SpriteSheet(ImageBank.virus_sheet);
		hack_sheet = new SpriteSheet(ImageBank.hack_sheet);

		getTextures();
	}

	@Todo("le design de la clef et du cadena font vieux, alors que celui de la porte est très moderne ..."
			+ " " + "Le desing du canapé est trop simpliste")
	private void getTextures() {

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

		for (int i = 0; i < 10; i++) {
			bomb[i] = bomb_sheet.grabImage(i + 1, 1, 64, 64);
		}

		for (int i = 0; i < 12; i++) {
			desk[i] = desk_sheet.grabImage(i + 1, 1, 64, 64); // horizontal
		}

		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < 6; i++) {
				desk[i + 12 + 6 * j] = desk_sheet.grabImage(j + 1, i + 2, 64, 64); // vertical
			}
		}

		dispenser[0] = desk_sheet.grabImage(5, 4, 32, 64); // water
		dispenser[1] = desk_sheet.grabImage(5, 6, 32, 64); // coffe
		lamp[0] = desk_sheet.grabImage(5, 9, 32, 32); // lamp

		for(int i = 1; i < 5; i++)
		{
		door[i][0] = door_sheet.grabImage(1, i, 32, 64); // vertical close
		door[i][1] = door_sheet.grabImage(2, i, 32, 64); // vertical open
		door[i][2] = door_sheet.grabImage(2, i, 64, 32); // horizontal close
		door[i][3] = door_sheet.grabImage(2, i+1, 64, 32); // horizontal open
		}

		plant[0] = desk_sheet.grabImage(3, 3, 64, 32);
		plant[1] = desk_sheet.grabImage(3, 4, 64, 32);
		plant[2] = desk_sheet.grabImage(3, 5, 64, 32);
		plant[3] = desk_sheet.grabImage(3, 6, 64, 32);
		
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

		couch[0] = couch_sheet.grabImage(1, 1, 96, 32); // horizontal trio
		couch[1] = couch_sheet.grabImage(1, 2, 96, 32); // horizontal trio back
		couch[2] = couch_sheet.grabImage(1, 2, 32, 96); // vertical trio
		couch[3] = couch_sheet.grabImage(3, 1, 64, 32); // horizontal dual
		couch[4] = couch_sheet.grabImage(3, 2, 64, 32); // horizontal dual back
		couch[5] = couch_sheet.grabImage(2, 2, 32, 64); // vertical dual
		couch[6] = couch_sheet.grabImage(4, 1, 32, 32); // single
		couch[7] = couch_sheet.grabImage(4, 2, 32, 32); // single back
		couch[8] = couch_sheet.grabImage(3, 2, 32, 64); // vertical dual back
		couch[9] = couch_sheet.grabImage(4, 2, 32, 96); // vertical trio back

		item[0] = item_sheet.grabImage(1, 1, 32, 32); // key
		item[1] = item_sheet.grabImage(2, 1, 32, 32); // lock
		item[2] = item_sheet.grabImage(3, 1, 32, 32); // wall
		item[3] = item_sheet.grabImage(4, 1, 32, 32); // wall maze
		item[4] = item_sheet.grabImage(5, 1, 32, 32); // door horizontal closed left
		item[5] = item_sheet.grabImage(6, 1, 32, 32); // door horizontal closed right
		item[6] = item_sheet.grabImage(7, 1, 32, 32); // door horizontal opened left
		item[7] = item_sheet.grabImage(8, 1, 32, 32); // door horizontal opened right
		item[8] = item_sheet.grabImage(9, 1, 32, 32); // door vertical closed up
		item[9] = item_sheet.grabImage(10, 1, 32, 32); // door vertical closed down
		item[10] = item_sheet.grabImage(1, 2, 32, 32); // door vertical opened up
		item[11] = item_sheet.grabImage(2, 2, 32, 32); // door vertical opened down
		item[12] = item_sheet.grabImage(3, 2, 32, 32); // timer
		item[13] = item_sheet.grabImage(4, 2, 32, 32); // heart full
		item[14] = item_sheet.grabImage(5, 2, 32, 32); // heart empty
		item[15] = item_sheet.grabImage(6, 2, 32, 32); // nails club
		item[16] = item_sheet.grabImage(7, 2, 32, 32); // weapon rack full left
		item[17] = item_sheet.grabImage(8, 2, 32, 32); // weapon rack full right
		item[18] = item_sheet.grabImage(9, 2, 32, 32); // weapon rack empty left
		item[19] = item_sheet.grabImage(10, 2, 32, 32); // weapon rack empty right
		item[20] = item_sheet.grabImage(1, 3, 32, 32); // filing cabinet
		item[21] = item_sheet.grabImage(2, 3, 32, 32); // filing cabinet full up
		item[22] = item_sheet.grabImage(3, 3, 32, 32); // filing cabinet full down
		item[23] = item_sheet.grabImage(4, 3, 32, 32); // filing cabinet empty up
		item[24] = item_sheet.grabImage(5, 3, 32, 32); // filing cabinet empty down
		item[25] = item_sheet.grabImage(6, 3, 32, 32); // wall card
		item[26] = item_sheet.grabImage(7, 3, 32, 32); // desk horizontal 1
		item[27] = item_sheet.grabImage(8, 3, 32, 32); // desk horizontal 2
		item[28] = item_sheet.grabImage(9, 3, 32, 32); // desk vertical 1
		item[29] = item_sheet.grabImage(10, 3, 32, 32); // desk vertical 2
		item[30] = item_sheet.grabImage(1, 4, 32, 32); // wall bomb
		item[31] = item_sheet.grabImage(2, 4, 32, 32); // wall cracked
		item[32] = item_sheet.grabImage(3, 4, 32, 32); // wall hack
		item[33] = item_sheet.grabImage(4, 4, 32, 32); // computer on
		item[34] = item_sheet.grabImage(5, 4, 32, 32); // computer off
		item[35] = item_sheet.grabImage(6, 4, 32, 32); // wall top
		item[36] = item_sheet.grabImage(7, 4, 32, 32); // wc
		item[37] = item_sheet.grabImage(8, 4, 32, 32); // wc watching left
		
		tool[0] = tool_sheet.grabImage(1, 1, 32, 32); // key
		tool[1] = tool_sheet.grabImage(2, 1, 32, 32); // foe
		

		for (int i = 0; i < 5; i++) {
			hack[i] = hack_sheet.grabImage(i + 1, 1, 48, 48);
			hack[i + 5] = hack_sheet.grabImage(i + 1, 2, 48, 48);
			hack[i + 10] = hack_sheet.grabImage(i + 1, 3, 48, 48);
		}

		virus[0] = virus_sheet.grabImage(1, 1, 16, 16);
		virus[1] = virus_sheet.grabImage(2, 1, 16, 16);
	}

}
