package objects;

import com.sunsigne.rebeccasreleasing.main.Size;
import com.sunsigne.rebeccasreleasing.ressources.images.Animation;

public abstract class AnimatedObject extends FacingObject {

	protected static final int FOE = 4, PLAYER = 3, VIRUS = 2, NULL = 0;
	protected static final int DESK_A = 12, REVERSED_DESK_A = -12;
	protected static final int DESK_B = 13, REVERSED_DESK_B = -13;
	protected static final int DESK_C = 14, REVERSED_DESK_C = -14;
	protected static final int DESK_D = 15, REVERSED_DESK_D = -15;
	protected static final int PLANT = 11, REVERSED_PLANT = -11;
	protected static final int BOMB = 10, REVERSED_BOMB = -10;

	private Animation[] move_animation = new Animation[4];
	private Animation animation;

	public AnimatedObject(int x, int y, boolean facingLeft, boolean horizontal, OBJECTID id, int animation) {
		super(x, y, facingLeft, horizontal, id);

		loadAnimation(animation);
	}

	public AnimatedObject(int x, int y, OBJECTID id, int animation) {
		super(x, y, id);

		loadAnimation(animation);
	}

	public void setAnimation(Animation animation) {
		this.animation = animation;
	}

	public Animation getAnimation() {
		return animation;
	}

	public Animation getAnimation(int facing) {
		return move_animation[facing];
	}

	protected void loadAnimation(int animation) {
		
		switch (animation) {
		case PLAYER:
			loadPlayerAnimation();
			break;

		case VIRUS:
			setAnimation(new Animation(15, texture.virus[0], texture.virus[1]));
			break;

		case DESK_A:
			setAnimation(new Animation(2, texture.desk[0], texture.desk[1], texture.desk[2], texture.desk[3],
					texture.desk[4], texture.desk[5], texture.desk[5]));
			break;

		case DESK_B:
			setAnimation(new Animation(2, texture.desk[6], texture.desk[7], texture.desk[8], texture.desk[9],
					texture.desk[10], texture.desk[11], texture.desk[11]));
			break;

		case DESK_C:
			setAnimation(new Animation(2, texture.desk[12], texture.desk[13], texture.desk[14], texture.desk[15],
					texture.desk[16], texture.desk[17], texture.desk[17]));
			break;

		case DESK_D:
			setAnimation(new Animation(2, texture.desk[18], texture.desk[19], texture.desk[20], texture.desk[21],
					texture.desk[22], texture.desk[23], texture.desk[23]));
			break;

		case REVERSED_DESK_A:
			setAnimation(new Animation(2, texture.desk[5], texture.desk[4], texture.desk[3], texture.desk[2],
					texture.desk[1], texture.desk[0], texture.desk[0]));
			break;

		case REVERSED_DESK_B:
			setAnimation(new Animation(2, texture.desk[11], texture.desk[10], texture.desk[9], texture.desk[8],
					texture.desk[7], texture.desk[6], texture.desk[6]));
			break;

		case REVERSED_DESK_C:
			setAnimation(new Animation(2, texture.desk[17], texture.desk[16], texture.desk[15], texture.desk[14],
					texture.desk[13], texture.desk[12], texture.desk[12]));
			break;

		case REVERSED_DESK_D:
			setAnimation(new Animation(2, texture.desk[23], texture.desk[22], texture.desk[21], texture.desk[20],
					texture.desk[19], texture.desk[18], texture.desk[18]));
			break;

		case PLANT:
			setAnimation(new Animation(2, texture.plant[0], texture.plant[1], texture.plant[2], texture.plant[3],
					texture.plant[3]));
			break;

		case REVERSED_PLANT:
			setAnimation(new Animation(2, texture.plant[3], texture.plant[2], texture.plant[1], texture.plant[0],
					texture.plant[0]));
			break;

		case BOMB:
			setAnimation(new Animation(2, texture.bomb[1], texture.bomb[2], texture.bomb[3], texture.bomb[4],
					texture.bomb[5], texture.bomb[6], texture.bomb[7], texture.bomb[8], texture.bomb[9],
					texture.bomb[9]));
			break;

		case REVERSED_BOMB:
			setAnimation(new Animation(2, texture.bomb[8], texture.bomb[7], texture.bomb[6], texture.bomb[5],
					texture.bomb[4], texture.bomb[3], texture.bomb[2], texture.bomb[1], texture.bomb[9],
					texture.bomb[9]));
			break;

		case NULL:
		default:
			setAnimation(new Animation(1));
			break; // this will draw an empty texture
		}

	}

	private void loadPlayerAnimation() {
		
		move_animation[Size.DIRECTION_UP] = new Animation(10, texture.rebecca_walking[0], texture.rebecca_walking[1],
				texture.rebecca_walking[2], texture.rebecca_walking[1]);

		move_animation[Size.DIRECTION_DOWN] = new Animation(10, texture.rebecca_walking[3], texture.rebecca_walking[4],
				texture.rebecca_walking[5], texture.rebecca_walking[4]);

		move_animation[Size.DIRECTION_LEFT] = new Animation(10, texture.rebecca_walking[6], texture.rebecca_walking[7],
				texture.rebecca_walking[8], texture.rebecca_walking[7]);

		move_animation[Size.DIRECTION_RIGHT] = new Animation(10, texture.rebecca_walking[9], texture.rebecca_walking[10],
				texture.rebecca_walking[11], texture.rebecca_walking[10]);
	}

}
