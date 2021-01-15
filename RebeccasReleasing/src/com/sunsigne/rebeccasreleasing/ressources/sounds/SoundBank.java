package com.sunsigne.rebeccasreleasing.ressources.sounds;

import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.Todo;

public class SoundBank {

	private static Map<SoundBank, BufferedSound> sounds = new HashMap<>();

	public static void addSound(SoundBank soundBank, BufferedSound bufferedSound) {

		if (bufferedSound != null)
			sounds.put(soundBank, bufferedSound);
	}

	public static BufferedSound getSound(SoundBank soundBank) {
		return sounds.get(soundBank);
	}

	public static final SoundBank error = new SoundBank();

	// music
	public static final SoundBank soundtrack_1 = new SoundBank();
	public static final SoundBank soundtrack_2 = new SoundBank();
	public static final SoundBank soundtrack_3 = new SoundBank();

	// other
	public static final SoundBank popup = new SoundBank();

	// talking
	public static final SoundBank talking_rebecca = new SoundBank();
	public static final SoundBank talking_sarah = new SoundBank();

	// sound normal
	// bomb
	public static final SoundBank explosion_big = new SoundBank();
	public static final SoundBank explosion_little = new SoundBank();
	public static final SoundBank explosion_medium = new SoundBank();
	// card
	public static final SoundBank hit_attack = new SoundBank();
	public static final SoundBank hit_critical = new SoundBank();
	public static final SoundBank hit_defense = new SoundBank();
	// hack
	public static final SoundBank computer = new SoundBank();
	public static final SoundBank virus_bite = new SoundBank();
	public static final SoundBank virus_explore = new SoundBank();
	// key
	public static final SoundBank opening_door = new SoundBank();
	// top
	public static final SoundBank place_word = new SoundBank();
	// world
	public static final SoundBank fail = new SoundBank();
	public static final SoundBank looting = new SoundBank();
	public static final SoundBank poterie = new SoundBank();
	public static final SoundBank push = new SoundBank();

	// sound reversed
	// bomb
	public static final SoundBank r_explosion_big = new SoundBank();
	public static final SoundBank r_explosion_little = new SoundBank();
	public static final SoundBank r_explosion_medium = new SoundBank();
	// card
	public static final SoundBank r_hit_attack = new SoundBank();
	public static final SoundBank r_hit_critical = new SoundBank();
	public static final SoundBank r_hit_defense = new SoundBank();
	// hack
	public static final SoundBank r_computer = new SoundBank();
	public static final SoundBank r_virus_bite = new SoundBank();
	public static final SoundBank r_virus_explore = new SoundBank();
	// key
	public static final SoundBank r_opening_door = new SoundBank();
	// top
	public static final SoundBank r_place_word = new SoundBank();
	// world
	public static final SoundBank r_fail = new SoundBank();
	public static final SoundBank r_looting = new SoundBank();
	public static final SoundBank r_poterie = new SoundBank();
	public static final SoundBank r_push = new SoundBank();

	@Todo("les bruits d'attaques et de defense ne conviennent pas bien")
	public static void loadRessources() {

		addSound(error, new BufferedSound("error.wav"));

		// music
		addSound(soundtrack_1, new BufferedSound("music\\soundtrack_1.wav"));
		addSound(soundtrack_2, new BufferedSound("music\\soundtrack_2.wav"));
		addSound(soundtrack_3, new BufferedSound("music\\soundtrack_3.wav"));

		// other
		addSound(popup, new BufferedSound("sound\\other\\popup.wav"));

		// talking
		addSound(talking_rebecca, new BufferedSound("sound\\other\\talking\\rebecca.wav"));
		addSound(talking_sarah, new BufferedSound("sound\\other\\talking\\sarah.wav"));

		// sound normal
		// bomb
		addSound(explosion_big, new BufferedSound("sound\\normal\\bomb\\explosion_big.wav"));
		addSound(explosion_little, new BufferedSound("sound\\normal\\bomb\\explosion_little.wav"));
		addSound(explosion_medium, new BufferedSound("sound\\normal\\bomb\\explosion_medium.wav"));
		// card
		addSound(hit_attack, new BufferedSound("sound\\normal\\card\\hit_attack.wav"));
		addSound(hit_critical, new BufferedSound("sound\\normal\\card\\hit_critical.wav"));
		addSound(hit_defense, new BufferedSound("sound\\normal\\card\\hit_defense.wav"));
		// hack
		addSound(computer, new BufferedSound("sound\\normal\\hack\\computer.wav"));
		addSound(virus_bite, new BufferedSound("sound\\normal\\hack\\virus_bite.wav"));
		addSound(virus_explore, new BufferedSound("sound\\normal\\hack\\virus_explore.wav"));
		// key
		addSound(opening_door, new BufferedSound("sound\\normal\\key\\opening_door.wav"));
		// top
		addSound(place_word, new BufferedSound("sound\\normal\\top\\place_word.wav"));
		// world
		addSound(fail, new BufferedSound("sound\\normal\\world\\fail.wav"));
		addSound(looting, new BufferedSound("sound\\normal\\world\\looting.wav"));
		addSound(poterie, new BufferedSound("sound\\normal\\world\\poterie.wav"));
		addSound(push, new BufferedSound("sound\\normal\\world\\push.wav"));

		// sound normal
		// bomb
		addSound(r_explosion_big, new BufferedSound("sound\\reversed\\bomb\\explosion_big.wav"));
		addSound(r_explosion_little, new BufferedSound("sound\\reversed\\bomb\\explosion_little.wav"));
		addSound(r_explosion_medium, new BufferedSound("sound\\reversed\\bomb\\explosion_medium.wav"));
		// card
		addSound(r_hit_attack, new BufferedSound("sound\\reversed\\card\\hit_attack.wav"));
		addSound(r_hit_critical, new BufferedSound("sound\\reversed\\card\\hit_critical.wav"));
		addSound(r_hit_defense, new BufferedSound("sound\\reversed\\card\\hit_defense.wav"));
		// hack
		addSound(r_computer, new BufferedSound("sound\\reversed\\hack\\computer.wav"));
		addSound(r_virus_bite, new BufferedSound("sound\\reversed\\hack\\virus_bite.wav"));
		addSound(r_virus_explore, new BufferedSound("sound\\reversed\\hack\\virus_explore.wav"));
		// key
		addSound(r_opening_door, new BufferedSound("sound\\reversed\\key\\opening_door.wav"));
		// top
		addSound(r_place_word, new BufferedSound("sound\\reversed\\top\\place_word.wav"));
		// world
		addSound(r_fail, new BufferedSound("sound\\reversed\\world\\fail.wav"));
		addSound(r_looting, new BufferedSound("sound\\reversed\\world\\looting.wav"));
		addSound(r_poterie, new BufferedSound("sound\\reversed\\world\\poterie.wav"));
		addSound(r_push, new BufferedSound("sound\\reversed\\world\\push.wav"));
	}

}
