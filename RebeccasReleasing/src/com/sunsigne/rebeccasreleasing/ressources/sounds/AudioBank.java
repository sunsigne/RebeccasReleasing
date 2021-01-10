package com.sunsigne.rebeccasreleasing.ressources.sounds;

import com.sunsigne.rebeccasreleasing.Todo;

public class AudioBank {

	public static String error;

	// music
	public static String soundtrack_1;
	public static String soundtrack_2;
	public static String soundtrack_3;

	//other
	public static String popup;
	
	// talking
	public static String talking_rebecca;
	public static String talking_sarah;

	// sound normal
	// bomb
	public static String explosion_big;
	public static String explosion_little;
	public static String explosion_medium;
	// card
	public static String hit_attack;
	public static String hit_critical;
	public static String hit_defense;
	// hack
	public static String computer;
	public static String virus_bite;
	public static String virus_explore;
	// key
	public static String opening_door;
	// top
	public static String place_word;
	// world
	public static String fail;
	public static String looting;
	public static String poterie;

	// sound reversed
	// bomb
	public static String r_explosion_big;
	public static String r_explosion_little;
	public static String r_explosion_medium;
	// card
	public static String r_hit_attack;
	public static String r_hit_critical;
	public static String r_hit_defense;
	// hack
	public static String r_computer;
	public static String r_virus_bite;
	public static String r_virus_explore;
	// key
	public static String r_opening_door;
	// top
	public static String r_place_word;
	// world
	public static String r_fail;
	public static String r_looting;
	public static String r_poterie;

	@Todo("les bruits d'attaques et de defense ne conviennent pas bien")
	public void loadRessources() {

		error = "error.wav";

		// music
		soundtrack_1 = "music\\soundtrack_1.wav";
		soundtrack_2 = "music\\soundtrack_2.wav";
		soundtrack_3 = "music\\soundtrack_3.wav";

		// other
		popup = "sound\\other\\popup.wav";
		
		// talking
		talking_rebecca = "sound\\other\\talking\\rebecca.wav";
		talking_sarah = "sound\\other\\talking\\sarah.wav";

		// sound normal
		// bomb
		explosion_big = "sound\\normal\\bomb\\explosion_big.wav";
		explosion_little = "sound\\normal\\bomb\\explosion_little.wav";
		explosion_medium = "sound\\normal\\bomb\\explosion_medium.wav";
		// card
		hit_attack = "sound\\normal\\card\\hit_attack.wav";
		hit_critical = "sound\\normal\\card\\hit_critical.wav";
		hit_defense = "sound\\normal\\card\\hit_defense.wav";
		// hack
		computer = "sound\\normal\\hack\\computer.wav";
		virus_bite = "sound\\normal\\hack\\virus_bite.wav";
		virus_explore = "sound\\normal\\hack\\virus_explore.wav";
		// key
		opening_door = "sound\\normal\\key\\opening_door.wav";
		// top
		place_word = "sound\\normal\\top\\place_word.wav";
		// world
		fail = "sound\\normal\\world\\fail.wav";
		looting = "sound\\normal\\world\\looting.wav";
		poterie = "sound\\normal\\world\\poterie.wav";

		// sound normal
		// bomb
		r_explosion_big = "sound\\reversed\\bomb\\explosion_big.wav";
		r_explosion_little = "sound\\reversed\\bomb\\explosion_little.wav";
		r_explosion_medium = "sound\\reversed\\bomb\\explosion_medium.wav";
		// card
		r_hit_attack = "sound\\reversed\\card\\hit_attack.wav";
		r_hit_critical = "sound\\reversed\\card\\hit_critical.wav";
		r_hit_defense = "sound\\reversed\\card\\hit_defense.wav";
		// hack
		r_computer = "sound\\reversed\\hack\\computer.wav";
		r_virus_bite = "sound\\reversed\\hack\\virus_bite.wav";
		r_virus_explore = "sound\\reversed\\hack\\virus_explore.wav";
		// key
		r_opening_door = "sound\\reversed\\key\\opening_door.wav";
		// top
		r_place_word = "sound\\reversed\\top\\place_word.wav";
		// world
		r_fail = "sound\\reversed\\world\\fail.wav";
		r_looting = "sound\\reversed\\world\\looting.wav";
		r_poterie = "sound\\reversed\\world\\poterie.wav";
	}

}
