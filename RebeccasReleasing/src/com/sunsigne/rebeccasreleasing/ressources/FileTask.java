package com.sunsigne.rebeccasreleasing.ressources;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTask {

	public static boolean doesExist(String filename) {
		File file = new File("ressources/data/" + filename + ".csv");
		return file.exists();
	}

	public static String read(String filename) {

		File file = new File("ressources/data/" + filename + ".csv");
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

	public static void write(String filename, String text) {
		File file = new File("ressources/data/" + filename + ".csv");
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
		File file = new File("ressources/data/" + filename + ".csv");
		if (file.exists())
			file.delete();
	}
}
