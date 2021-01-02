package com.sunsigne.rebeccasreleasing.ressources;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import com.sunsigne.rebeccasreleasing.Todo;
import com.sunsigne.rebeccasreleasing.game.menu.options.Options;

@Todo("passer d'un système de sauvegarde .txt à un système .csv ? + améliorer le reader")
public class FileTask {

	public static boolean existing(String filename) {
		File file = new File("ressources/data/" + filename + ".txt");
		return file.exists();
	}

	public static String read(String filename, int lineToRead) {

		File file = new File("ressources/data/" + filename + ".txt");
		Scanner scan = null;
		String fileContent = "";
		int readingline = 0;

		if (lineToRead >= 256) {
			switch (Options.getLanguage()) {

			case FRENCH:
				fileContent = "La ligne à lire ne peut pas être plus grande que 255.";
				break;
			case ENGLISH:
			default:
				fileContent = "The line to read can not be higher than 255.";
				break;

			}
			return fileContent;
		}

		try {
			if (file.exists()) {
				scan = new Scanner(file, "UTF-8");
				boolean flag = false;

				while (scan.hasNextLine() && readingline != 256) {
					if (lineToRead == 0) {
						if (!flag) {
							fileContent = fileContent.concat(scan.nextLine());
							flag = true;
						} else
							fileContent = fileContent.concat(String.format("%n" + scan.nextLine()));
					} else {
						readingline++;
						String linecontent = scan.nextLine();

						if (readingline == lineToRead)
							fileContent = fileContent.concat(linecontent);
					}
				}
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileContent;
	}

	public static void write(String filename, String text) {
		File file = new File("ressources/data/" + filename + ".txt");
		FileWriter writer = null;

		try {
			writer = new FileWriter(file);
			writer.write(text);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(String filename) {
		File file = new File("ressources/data/" + filename + ".txt");
		if (file.exists())
			file.delete();
	}
}
