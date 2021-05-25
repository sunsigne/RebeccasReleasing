package com.sunsigne.rebeccasreleasing.system.util;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.Conductor;

public class DualChecker implements ITick {

	private static final GameFile dualcheck = new GameFile("data/dualcheck");
	private static boolean firstStart = true;;
	private static boolean closing;

	@Override
	public void tick() {

		FileTask fileTask = new FileTask();
		String dualCheckerTxt;
		boolean dualCheckerBoolean = true;

		if (fileTask.doesExist(dualcheck)) {
			dualCheckerTxt = fileTask.read(dualcheck);
			dualCheckerBoolean = Boolean.parseBoolean(dualCheckerTxt);
		}

		if (firstStart) {
			if (fileTask.doesExist(dualcheck)) {
				if (!dualCheckerBoolean) {
					fileTask.write(dualcheck, "true");
					Conductor.fatalError("An error has occured. Please try again");
				} else
					fileTask.write(dualcheck, "true");
			}
			firstStart = false;
		}

		if (!closing) {
			if (!fileTask.doesExist(dualcheck) || dualCheckerBoolean)
				fileTask.write(dualcheck, "false");
		}
	}

	public void start() {
		HandlerTick.getInstance().addObject(this);
		tick();
	}

	public void stop() {
		closing = true;
		new FileTask().delete(DualChecker.dualcheck);
	}

}
