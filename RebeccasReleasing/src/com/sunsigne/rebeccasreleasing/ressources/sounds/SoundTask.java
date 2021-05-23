package com.sunsigne.rebeccasreleasing.ressources.sounds;

import java.io.File;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import com.sunsigne.rebeccasreleasing.system.Game;
import com.sunsigne.rebeccasreleasing.toverify.ressources.sounds.SoundBank;

public class SoundTask {

	private final URL loc = Game.class.getProtectionDomain().getCodeSource().getLocation();

	////////// MUSIC ////////////

	private static Clip musicclip;

	public void changeMusicVol(double newvolume) {
		setVol(newvolume, musicclip);
	}

	public void stopMusic() {

		if (musicclip != null)
			musicclip.close();
	}

	// Those two lines of 'comment' into this method would synchronise
	// perfectly the change of volume in real time, instead of latency of 1 sec.
	private void setVol(double volume, Clip clip) {
		try {
//		int pos = clip.getFramePosition();
			FloatControl gain = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float) (Math.log(volume) / Math.log(10) * 20);
			gain.setValue(dB);
//		clip.setFramePosition(pos);
		} catch (Exception e) {
		}
	}

	// WARNING !!! All paths in this method must have their / replaced by double \\
	public void playMusic(double volume, SoundBank sound) {

		stopMusic();
		try {
			String path = "\\ressources\\audio\\" + SoundBank.getSound(sound).getSound();
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

	////////// SOUND ////////////

	private static Clip soundclip;

	// WARNING !!! All paths in this method must have their / replaced by double \\
	public void playSound(SoundBank sound) {
		playSound(1d, sound);
	}

	public void playSound(double volume, SoundBank sound) {

		if (sound != null) {
			try {
				String path = "\\ressources\\audio\\" + SoundBank.getSound(sound).getSound();
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
}