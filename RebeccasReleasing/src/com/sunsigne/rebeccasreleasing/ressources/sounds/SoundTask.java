package com.sunsigne.rebeccasreleasing.ressources.sounds;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.sunsigne.rebeccasreleasing.main.Game;

public class SoundTask {

	private static URL loc = Game.class.getProtectionDomain().getCodeSource().getLocation();
	private static Clip musicclip, soundclip;

	// WARNING !!! All paths in this method must have their / replaced by double \\
	public static void playMusic(double volume, BufferedSound sound) {

		stopMusic();
		try {
			String path = "\\ressources\\audio\\" + sound.getSound();
			URL url = new File((new File(loc.toURI())).getParent() + path).toURI().toURL();

			AudioInputStream music = AudioSystem.getAudioInputStream(url);
			musicclip = AudioSystem.getClip();
			musicclip.open(music);
			setVol(volume, musicclip);
			musicclip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// WARNING !!! All paths in this method must have their / replaced by double \\
	public static void playSound(BufferedSound sound) {
		playSound(1d, sound);
	}

	public static void playSound(double volume, BufferedSound sound) {

		if (sound != null) {
			try {
				String path = "\\ressources\\audio\\" + sound.getSound();
				URL url = new File((new File(loc.toURI())).getParent() + path).toURI().toURL();

				AudioInputStream clip = AudioSystem.getAudioInputStream(url);
				soundclip = AudioSystem.getClip();
				soundclip.open(clip);
				setVol(volume, soundclip);
				soundclip.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Those two lines of 'comment' into this method would synchronise
	// perfectly the change of volume in real time, instead of latency of 1 sec.
	private static void setVol(double volume, Clip clip) {
		try {
//		int pos = clip.getFramePosition();
			FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float) (Math.log(volume) / Math.log(10) * 20);
			gain.setValue(dB);
//		clip.setFramePosition(pos);
		} catch (Exception e) {
		}

	}

	public static void changeMusicVol(double newvolume) {
		setVol(newvolume, musicclip);
	}

	public static void stopMusic() {

		if (musicclip != null)
			musicclip.close();
	}

}