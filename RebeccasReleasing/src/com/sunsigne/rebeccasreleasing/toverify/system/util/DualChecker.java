package com.sunsigne.rebeccasreleasing.toverify.system.util;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.GameFile;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;
import com.sunsigne.rebeccasreleasing.toverify.system.conductor.Conductor;

public class DualChecker implements ITick {

	private static final GameFile dualcheck = new GameFile("data/dualcheck");
	private static boolean hasbeenchecked;
	private static boolean closing;
	
	@Override
	public void tick() {
		if (!hasbeenchecked) {
			if (!FileTask.doesExist(dualcheck))
				FileTask.write(dualcheck, "true");
			else {
				String dualcheckertxt = FileTask.read(dualcheck);
				boolean dualcheckerboolean = Boolean.parseBoolean(dualcheckertxt);
				if (!dualcheckerboolean) {
					FileTask.write(dualcheck, "true");
					Conductor.fatalError("An error has occured. Please try again");
				}
			}
			hasbeenchecked = true;
		}

		String dualcheckertxt = FileTask.read(dualcheck);
		boolean dualcheckerboolean = Boolean.parseBoolean(dualcheckertxt);

		if (dualcheckerboolean || !FileTask.doesExist(dualcheck) && !closing)
			FileTask.write(dualcheck, "false");
	}

	public void start() {
		HandlerTick.getInstance().addObject(this);
		tick();
	}
	
	public void stop()
	{
		closing = true;
		FileTask.delete(DualChecker.dualcheck);
	}

}
