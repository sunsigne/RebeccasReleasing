
package com.sunsigne.rebeccasreleasing.toverify.game.puzzles.hack;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.sunsigne.rebeccasreleasing.ressources.sounds.BufferedSound;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.system.controllers.mouse.GameCursor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerObject;
import com.sunsigne.rebeccasreleasing.toverify.game.objects.world.puzzler.IPuzzler;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.DIFFICULTY;
import com.sunsigne.rebeccasreleasing.toverify.game.puzzles.Puzzle;
import com.sunsigne.rebeccasreleasing.toverify.system.STATE;

public class PuzzleHack extends Puzzle {

	public static Virus virus;

	private static ProcessorCPU[] cpu = new ProcessorCPU[3];
	private static ProcessorLocker[] locker = new ProcessorLocker[3];
	private static ProcessorFolder system32, windows, system;
	private static ProcessorTrash trash;
	private static ProcessorDesktop desktop;

	public PuzzleHack(IPuzzler puzzler, DIFFICULTY difficulty/* , boolean reversed */) {
		super(STATE.PUZZLE, puzzler, difficulty, /* reversed */false);
		new GameCursor().hideCursor(true);
	}

	@Override
	public void randomGenerationTODELETE() {

		cpu[0] = new ProcessorCPU(1, 1, 1);
		cpu[1] = new ProcessorCPU(2, 1, 2);
		cpu[2] = new ProcessorCPU(3, 1, 3);

		locker[0] = new ProcessorLocker(4, 1);
		locker[1] = new ProcessorLocker(2, 1);
		locker[2] = new ProcessorLocker(2, 1);
		int rad = 1 + new Random().nextInt(3);

		system32 = new ProcessorFolder(1, 1, 0, "System32", cpu);
		if (rad == 1)
			system32 = new ProcessorFolder(1, 1, 0, "System32", cpu[0], cpu[1], cpu[2], locker[0]);

		windows = new ProcessorFolder(1, 1, 10, "Windows", system32);
		if (rad == 2)
			windows = new ProcessorFolder(1, 1, 10, "Windows", system32, locker[1]);

		system = new ProcessorFolder(windows);
		if (rad == 3)
			system = new ProcessorFolder(windows, locker[2]);

		trash = new ProcessorTrash();
		desktop = new ProcessorDesktop(system, trash);
	}

	@Override
	public void createPuzzleTODELETE() {
		HandlerObject.getInstance().addObject(desktop);
		virus = new Virus();
		HandlerObject.getInstance().addObject(virus);
	}

	@Override
	public void mousePressed(int mx, int my) {
		virus.doAction();
	}

	@Override
	public void mouseReleased(int mx, int my) {
		virus.setClicking(false);
		boolean winning = true;
		for (int i = 0; i <= 2; i++) {
			if (!cpu[i].isDeleted())
				winning = false;
		}
		setWinning(winning);
		if (isWinning())
			close();
	}

	// other

	@Override
	public void render(Graphics g) {
		colorRender(g, new Color(10, 10, 50, 240));
		renderingFakeWall(g, texture.decor_wall[2]);

	}

	@Override
	public SoundBank getSuccessSound() {
		if (!isForward())
			return SoundBank.SHORT_CIRCUIT;
		else
			return SoundBank.NOPE;
	}

}
