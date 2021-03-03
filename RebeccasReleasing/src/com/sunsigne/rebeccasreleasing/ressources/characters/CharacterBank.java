package com.sunsigne.rebeccasreleasing.ressources.characters;

import java.util.HashMap;
import java.util.Map;

public class CharacterBank {

	// map or list

	public static Map<CharacterBank, BufferedCharacter> characters = new HashMap<>();

	// Even if this method is only used in this class, I prefere to let it public
	// to make it easier for modders and devellopers in adding content
	public static void addCharacter(CharacterBank characterBank, BufferedCharacter bufferedCharacter) {

		if (bufferedCharacter != null)
			characters.put(characterBank, bufferedCharacter);
	}

	public static BufferedCharacter getCharacter(CharacterBank characterBank) {
		return characters.get(characterBank);
	}

	// main
	// female
	public static final CharacterBank rebecca = new CharacterBank();
	public static final CharacterBank sarah = new CharacterBank();
	public static final CharacterBank sarah_helmet = new CharacterBank();
	public static final CharacterBank alicia = new CharacterBank();
	// male
	public static final CharacterBank vladimir = new CharacterBank();
	public static final CharacterBank gamma = new CharacterBank();

	// dummies
	// female
	public static final CharacterBank f_01 = new CharacterBank();
	// male
	public static final CharacterBank m_01 = new CharacterBank();
	public static final CharacterBank m_02 = new CharacterBank();

	public static void loadRessources() {

		// main
		// female
		addCharacter(rebecca, new BufferedCharacter(true, 1, 1));
		addCharacter(sarah, new BufferedCharacter(true, 2, 1));
		addCharacter(sarah_helmet, new BufferedCharacter(true, 3, 1));
		addCharacter(alicia, new BufferedCharacter(true, 4, 1));
		// male
		addCharacter(vladimir, new BufferedCharacter(true, 1, 2));
		addCharacter(gamma, new BufferedCharacter(true, 2, 2));

		// dummies
		// female
		addCharacter(f_01, new BufferedCharacter(false, 1, 3));
		// male
		addCharacter(m_01, new BufferedCharacter(false, 1, 4));
		addCharacter(m_02, new BufferedCharacter(false, 2, 4));
	}

}
