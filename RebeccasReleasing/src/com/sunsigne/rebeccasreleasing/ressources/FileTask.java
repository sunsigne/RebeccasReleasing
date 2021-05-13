package com.sunsigne.rebeccasreleasing.ressources;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTask {

	public static boolean doesExist(GameFile gamefile) {
		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		return file.exists();
	}

	public static String read(GameFile gamefile) {

		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		Scanner scan = null;
		String fileContent = "";

		try {
			if (file.exists()) {
				scan = new Scanner(file, "UTF-8");
				boolean flag = false;

				while (scan.hasNextLine()) {
					if (!flag) {
						fileContent = fileContent.concat(scan.nextLine());
						flag = true;
					} else
						fileContent = fileContent.concat(String.format("%n" + scan.nextLine()));
				}
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileContent;
	}

	public static String read(GameFile gamefile, int lineToRead) {

		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		Scanner scan = null;
		String lineContent = "";
		int count = 0;

		try {
			if (file.exists()) {
				scan = new Scanner(file, "UTF-8");
				while (count != lineToRead) {
					if (lineToRead < 0)
						break;
					lineContent = scan.nextLine();
					count++;
				}
				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lineContent;
	}

	public static void write(GameFile gamefile, String text) {
		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		FileWriter writer = null;

		try {
			writer = new FileWriter(file);
			writer.write(text);
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void write(GameFile gamefile, String text, int atLine) {
		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		String fileContent = read(gamefile);
		String[] alllines = fileContent.split(System.getProperty("line.separator"));
		int size = alllines.length;

		FileWriter writer = null;

		try {
			writer = new FileWriter(file);
			for (int i = 0; i < size; i++) {
				if (i != atLine)
					writer.write(String.format(alllines[i] + "%n"));
				else
					writer.write(String.format(text + "%n"));
			}
			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void delete(GameFile gamefile) {
		File file = new File("ressources/data/" + gamefile.getFilename() + ".csv");
		if (file.exists())
			file.delete();
	}
}
