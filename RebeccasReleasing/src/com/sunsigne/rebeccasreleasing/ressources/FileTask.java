package com.sunsigne.rebeccasreleasing.ressources;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTask {

	public static boolean existing(String filename) {
		File file = new File("ressources/data/" + filename + ".csv");
		return file.exists();
	}

	public static String read(String filename, int lineToRead) {

		File file = new File("ressources/data/" + filename + ".csv");
		Scanner scan = null;
		String fileContent = "";
		int readingline = 0;

		try {
			if (file.exists()) {
				scan = new Scanner(file, "UTF-8");
				boolean flag = false;

				while (scan.hasNextLine()) {
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
