package com.sunsigne.rebeccasreleasing.main;

import javax.swing.JOptionPane;

import com.sunsigne.rebeccasreleasing.ressources.FileTask;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundBank;
import com.sunsigne.rebeccasreleasing.ressources.sounds.SoundTask;
import com.sunsigne.rebeccasreleasing.system.conductor.Conductor;
import com.sunsigne.rebeccasreleasing.system.handler.HandlerTick;
import com.sunsigne.rebeccasreleasing.system.handler.ITick;

public class DualChecker implements ITick {

	private static final String dualcheck = "dualcheck";
	private static boolean hasbeenchecked;
	private static boolean closing;
	
	@Override
	public void tick() {
		if (!hasbeenchecked) {
			if (!FileTask.existing(dualcheck))
				FileTask.write(dualcheck, "true");
			else {
				String dualcheckertxt = FileTask.read(dualcheck, 0);
				boolean dualcheckerboolean = Boolean.parseBoolean(dualcheckertxt);
				if (!dualcheckerboolean) {
					FileTask.write(dualcheck, "true");
					SoundTask.playSound(SoundBank.error);
					JOptionPane.showMessageDialog(null, "An error has occured. Please try again");
					Conductor.stop();
				}
			}
			hasbeenchecked = true;
		}

		String dualcheckertxt = FileTask.read(dualcheck, 0);
		boolean dualcheckerboolean = Boolean.parseBoolean(dualcheckertxt);

		if (dualcheckerboolean || !FileTask.existing(dualcheck) && !closing)
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
