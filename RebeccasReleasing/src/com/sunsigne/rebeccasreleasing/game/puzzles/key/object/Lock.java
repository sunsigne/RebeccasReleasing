package com.sunsigne.rebeccasreleasing.game.puzzles.key.object;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.sunsigne.rebeccasreleasing.game.object.GameObject;
import com.sunsigne.rebeccasreleasing.game.object.collision.ICollisionReaction;
import com.sunsigne.rebeccasreleasing.game.puzzles.PuzzleObject;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.OBJECTID;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;
import com.sunsigne.rebeccasreleasing.toverify.system.util.Size;

public class Lock extends PuzzleObject implements ICollisionReaction {

	public Lock(int x, int y) {
		super(x, y, OBJECTID.DELETE);
	}

	private boolean inverseMouse;

	public void setInverseMouse(boolean inverseMouse) {
		this.inverseMouse = inverseMouse;
	}

	////////// SIZE ////////////

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x + w / 4, y + h / 4, w / 2, h / 2);
	}

	////////// TICK ////////////

	private final int ymin = Size.Y0 + Size.TILE_PUZZLE;
	private final int ymax = Size.Y0 + 6 * Size.TILE_PUZZLE;

	@Override
	public void tick() {
		if (Conductor.getState() == STATE.PUZZLE) {
			if (new GameCursor().getPos().y < ymin)
				y = inverseMouse ? ymax : ymin;
			else if (new GameCursor().getPos().y > ymax)
				y = inverseMouse ? ymin : ymax;
			else {
				int ymouse = new GameCursor().getPos().y;
				y = inverseMouse ? ymax + ymin - ymouse : ymouse;
			}

		}
	}

	////////// RENDER ////////////

	@Override
	public void render(Graphics g) {

		BufferedImage img = texture.puzzle_key[1];
		g.drawImage(img, x, y, w, h, null);
	}

	////////// COLLISION ////////////

	@Override
	public void collidingReaction(GameObject collidingObject) {
		if (collidingObject instanceof KeyForward)
			collidingReaction(collidingObject, false, this, () -> {
				HandlerObject.getInstance().getPlayer().puzzle.setWinning(true);
				HandlerObject.getInstance().getPlayer().puzzle.close();
			});
	}
}