package com.sunsigne.rebeccasreleasing.ressources.sounds;

import com.sunsigne.rebeccasreleasing.Todo;

public class SoundBank {

	public static AudioBank error;

	// music
	public static AudioBank soundtrack_1;
	public static AudioBank soundtrack_2;
	public static AudioBank soundtrack_3;

	//other
	public static AudioBank popup;
	
	// talking
	public static AudioBank talking_rebecca;
	public static AudioBank talking_sarah;

	// sound normal
	// bomb
	public static AudioBank explosion_big;
	public static AudioBank explosion_little;
	public static AudioBank explosion_medium;
	// card
	public static AudioBank hit_attack;
	public static AudioBank hit_critical;
	public static AudioBank hit_defense;
	// hack
	public static AudioBank computer;
	public static AudioBank virus_bite;
	public static AudioBank virus_explore;
	// key
	public static AudioBank opening_door;
	// top
	public static AudioBank place_word;
	// world
	public static AudioBank fail;
	public static AudioBank looting;
	public static AudioBank poterie;
	public static AudioBank push;

	// sound reversed
	// bomb
	public static AudioBank r_explosion_big;
	public static AudioBank r_explosion_little;
	public static AudioBank r_explosion_medium;
	// card
	public static AudioBank r_hit_attack;
	public static AudioBank r_hit_critical;
	public static AudioBank r_hit_defense;
	// hack
	public static AudioBank r_computer;
	public static AudioBank r_virus_bite;
	public static AudioBank r_virus_explore;
	// key
	public static AudioBank r_opening_door;
	// top
	public static AudioBank r_place_word;
	// world
	public static AudioBank r_fail;
	public static AudioBank r_looting;
	public static AudioBank r_poterie;
	public static AudioBank r_push;

	@Todo("les bruits d'attaques et de defense ne conviennent pas bien")
	public void loadRessources() {

		error = new AudioBank("error.wav");

		// music
		soundtrack_1 = new AudioBank("music\\soundtrack_1.wav");
		soundtrack_2 = new AudioBank("music\\soundtrack_2.wav");
		soundtrack_3 = new AudioBank("music\\soundtrack_3.wav");

		// other
		popup = new AudioBank("sound\\other\\popup.wav");
		
		// talking
		talking_rebecca = new AudioBank("sound\\other\\talking\\rebecca.wav");
		talking_sarah = new AudioBank("sound\\other\\talking\\sarah.wav");

		// sound normal
		// bomb
		explosion_big = new AudioBank("sound\\normal\\bomb\\explosion_big.wav");
		explosion_little = new AudioBank("sound\\normal\\bomb\\explosion_little.wav");
		explosion_medium = new AudioBank("sound\\normal\\bomb\\explosion_medium.wav");
		// card
		hit_attack = new AudioBank("sound\\normal\\card\\hit_attack.wav");
		hit_critical = new AudioBank("sound\\normal\\card\\hit_critical.wav");
		hit_defense = new AudioBank("sound\\normal\\card\\hit_defense.wav");
		// hack
		computer = new AudioBank("sound\\normal\\hack\\computer.wav");
		virus_bite = new AudioBank("sound\\normal\\hack\\virus_bite.wav");
		virus_explore = new AudioBank("sound\\normal\\hack\\virus_explore.wav");
		// key
		opening_door = new AudioBank("sound\\normal\\key\\opening_door.wav");
		// top
		place_word = new AudioBank("sound\\normal\\top\\place_word.wav");
		// world
		fail = new AudioBank("sound\\normal\\world\\fail.wav");
		looting = new AudioBank("sound\\normal\\world\\looting.wav");
		poterie = new AudioBank("sound\\normal\\world\\poterie.wav");
		push = new AudioBank("sound\\normal\\world\\push.wav");

		// sound normal
		// bomb
		r_explosion_big = new AudioBank("sound\\reversed\\bomb\\explosion_big.wav");
		r_explosion_little = new AudioBank("sound\\reversed\\bomb\\explosion_little.wav");
		r_explosion_medium = new AudioBank("sound\\reversed\\bomb\\explosion_medium.wav");
		// card
		r_hit_attack = new AudioBank("sound\\reversed\\card\\hit_attack.wav");
		r_hit_critical = new AudioBank("sound\\reversed\\card\\hit_critical.wav");
		r_hit_defense = new AudioBank("sound\\reversed\\card\\hit_defense.wav");
		// hack
		r_computer = new AudioBank("sound\\reversed\\hack\\computer.wav");
		r_virus_bite = new AudioBank("sound\\reversed\\hack\\virus_bite.wav");
		r_virus_explore = new AudioBank("sound\\reversed\\hack\\virus_explore.wav");
		// key
		r_opening_door = new AudioBank("sound\\reversed\\key\\opening_door.wav");
		// top
		r_place_word = new AudioBank("sound\\reversed\\top\\place_word.wav");
		// world
		r_fail = new AudioBank("sound\\reversed\\world\\fail.wav");
		r_looting = new AudioBank("sound\\reversed\\world\\looting.wav");
		r_poterie = new AudioBank("sound\\reversed\\world\\poterie.wav");
		r_push = new AudioBank("sound\\reversed\\world\\push.wav");
	}

}
