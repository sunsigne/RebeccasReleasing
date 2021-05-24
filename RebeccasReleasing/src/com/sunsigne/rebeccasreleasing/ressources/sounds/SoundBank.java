package com.sunsigne.rebeccasreleasing.ressources.sounds;

import java.util.HashMap;
import java.util.Map;

import com.sunsigne.rebeccasreleasing.ressources.Ressource;

public class SoundBank implements Ressource {

	////////// MAP OR LIST ////////////

	private static Map<SoundBank, BufferedSound> sounds = new HashMap<>();

	// public for devs
	public void addSound(SoundBank soundBank, BufferedSound bufferedSound) {

		if (bufferedSound != null)
			sounds.put(soundBank, bufferedSound);
	}

	public BufferedSound getSound(SoundBank soundBank) {
		return sounds.get(soundBank);
	}

	////////// BANK ////////////

	public static final SoundBank ERROR = new SoundBank();
	public static final SoundBank NOPE = new SoundBank();

	// music
	public static final SoundBank MUSIC_INTRODUCTION = new SoundBank();
	public static final SoundBank MUSIC_TITLE = new SoundBank();
	public static final SoundBank MUSIC_LEVEL = new SoundBank();

	// sound forward
	public static final SoundBank DOOR_OPEN = new SoundBank();
	public static final SoundBank EXPLOSION_LITTLE = new SoundBank();
	public static final SoundBank EXPLOSION_MEDIUM = new SoundBank();
	public static final SoundBank EXPLOSION_BIG = new SoundBank();
	public static final SoundBank HIT_LITTLE = new SoundBank();
	public static final SoundBank HIT_MEDIUM = new SoundBank();
	public static final SoundBank HIT_BIG = new SoundBank();
	public static final SoundBank PLAYER_FAIL = new SoundBank();
	public static final SoundBank PLAYER_JUMP = new SoundBank();
	public static final SoundBank PLAYER_LOOT = new SoundBank();
	public static final SoundBank POT = new SoundBank();
	public static final SoundBank SHORT_CIRCUIT = new SoundBank();
	public static final SoundBank TOP_SECRET = new SoundBank();
	public static final SoundBank VIRUS_BITE = new SoundBank();
	public static final SoundBank VIRUS_EXPLORE = new SoundBank();

	// sound reversed
	public static final SoundBank REVERSED_DOOR_OPEN = new SoundBank();
	public static final SoundBank REVERSED_EXPLOSION_LITTLE = new SoundBank();
	public static final SoundBank REVERSED_EXPLOSION_MEDIUM = new SoundBank();
	public static final SoundBank REVERSED_EXPLOSION_BIG = new SoundBank();
	public static final SoundBank REVERSED_HIT_LITTLE = new SoundBank();
	public static final SoundBank REVERSDED_HIT_MEDIUM = new SoundBank();
	public static final SoundBank REVERSED_HIT_BIG = new SoundBank();
	public static final SoundBank REVERSED_PLAYER_FAIL = new SoundBank();
	public static final SoundBank REVERSED_PLAYER_LOOT = new SoundBank();
	public static final SoundBank REVERSED_PLAYER_JUMP = new SoundBank();
	public static final SoundBank REVERSED_POT = new SoundBank();
	public static final SoundBank REVERSED_SHORT_CIRCUIT = new SoundBank();
	public static final SoundBank REVERSED_TOP_SECRET = new SoundBank();
	public static final SoundBank REVERSED_VIRUS_BITE = new SoundBank();
	public static final SoundBank REVERSED_VIRUS_EXPLORE = new SoundBank();

	// sound other
	public static final SoundBank PIERRE_FEUILLE_CISEAUX_COM = new SoundBank();
	public static final SoundBank TALKING_REBECCA = new SoundBank();
	public static final SoundBank TALKING_SARAH = new SoundBank();

	////////// RESSOURCES ////////////

	@Override
	public void loadBareMinimumRessources() {
		addSound(ERROR, new BufferedSound("sound\\error.wav"));
		addSound(NOPE, new BufferedSound("sound\\nope.wav"));
	}

	@Override
	public void loadRessources() {

		// music
		addSound(MUSIC_INTRODUCTION, new BufferedSound("music\\3 Joys & the Truth.wav"));
		addSound(MUSIC_TITLE, new BufferedSound("music\\Hopeful Rays.wav"));
		addSound(MUSIC_LEVEL, new BufferedSound("music\\Atmospheria City.wav"));

		// sound forward
		addSound(DOOR_OPEN, new BufferedSound("sound\\forward\\door_open.wav"));
		addSound(EXPLOSION_BIG, new BufferedSound("sound\\forward\\explosion_big.wav"));
		addSound(EXPLOSION_LITTLE, new BufferedSound("sound\\forward\\explosion_little.wav"));
		addSound(EXPLOSION_MEDIUM, new BufferedSound("sound\\forward\\explosion_medium.wav"));
		addSound(HIT_LITTLE, new BufferedSound("sound\\forward\\hit_little.wav"));
		addSound(HIT_MEDIUM, new BufferedSound("sound\\forward\\hit_medium.wav"));
		addSound(HIT_BIG, new BufferedSound("sound\\forward\\hit_big.wav"));
		addSound(PLAYER_FAIL, new BufferedSound("sound\\forward\\player_fail.wav"));
		addSound(PLAYER_JUMP, new BufferedSound("sound\\forward\\player_jump.wav"));
		addSound(PLAYER_LOOT, new BufferedSound("sound\\forward\\player_loot.wav"));
		addSound(POT, new BufferedSound("sound\\forward\\pot.wav"));
		addSound(SHORT_CIRCUIT, new BufferedSound("sound\\forward\\short_circuit.wav"));
		addSound(TOP_SECRET, new BufferedSound("sound\\forward\\top_secret.wav"));
		addSound(VIRUS_BITE, new BufferedSound("sound\\forward\\hack\\virus_bite.wav"));
		addSound(VIRUS_EXPLORE, new BufferedSound("sound\\forward\\hack\\virus_explore.wav"));

		// sound reversed
		addSound(REVERSED_DOOR_OPEN, new BufferedSound("sound\\reversed\\door_open.wav"));
		addSound(REVERSED_EXPLOSION_BIG, new BufferedSound("sound\\reversed\\bomb\\explosion_big.wav"));
		addSound(REVERSED_EXPLOSION_LITTLE, new BufferedSound("sound\\reversed\\bomb\\explosion_little.wav"));
		addSound(REVERSED_EXPLOSION_MEDIUM, new BufferedSound("sound\\reversed\\bomb\\explosion_medium.wav"));
		addSound(REVERSED_HIT_LITTLE, new BufferedSound("sound\\reversed\\hit_little.wav"));
		addSound(REVERSDED_HIT_MEDIUM, new BufferedSound("sound\\reversed\\hit_medium.wav"));
		addSound(REVERSED_HIT_BIG, new BufferedSound("sound\\reversed\\hit_big.wav"));
		addSound(REVERSED_PLAYER_FAIL, new BufferedSound("sound\\reversed\\player_fail.wav"));
		addSound(REVERSED_PLAYER_JUMP, new BufferedSound("sound\\reversed\\player_jump.wav"));
		addSound(REVERSED_PLAYER_LOOT, new BufferedSound("sound\\reversed\\player_loot.wav"));
		addSound(REVERSED_POT, new BufferedSound("sound\\reversed\\pot.wav"));
		addSound(REVERSED_SHORT_CIRCUIT, new BufferedSound("sound\\reversed\\short_circuit.wav"));
		addSound(REVERSED_TOP_SECRET, new BufferedSound("sound\\reversed\\top_secret.wav"));
		addSound(REVERSED_VIRUS_BITE, new BufferedSound("sound\\reversed\\hack\\virus_bite.wav"));
		addSound(REVERSED_VIRUS_EXPLORE, new BufferedSound("sound\\reversed\\hack\\virus_explore.wav"));

		// sound other
		addSound(PIERRE_FEUILLE_CISEAUX_COM, new BufferedSound("sound\\other\\pierre_feuille_ciseaux_com.wav"));
		addSound(TALKING_REBECCA, new BufferedSound("sound\\other\\talking_rebecca.wav"));
		addSound(TALKING_SARAH, new BufferedSound("sound\\other\\talking_sarah.wav"));

	}

}
