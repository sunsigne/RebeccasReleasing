package com.sunsigne.rebeccasreleasing.ressources;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileTask {

	public boolean doesExist(GameFile gamefile) {
		File file = new File("ressources/" + gamefile.getFilename() + ".csv");
		return file.exists();
	}

	public String read(GameFile gamefile) {

		return read(gamefile, 0);
	}

	public String read(GameFile gamefile, int lineToRead) {

		File file = new File("ressources/" + gamefile.getFilename() + ".csv");
		Scanner scan = null;
		String content = "";
		int count = 0;

		try {
			if (file.exists()) {
				scan = new Scanner(file, "UTF-8");
				boolean flag = false;

				// read the whole file
				if (lineToRead == 0) {
					while (scan.hasNextLine()) {
						if (!flag) {
							content = content.concat(scan.nextLine());
							flag = true;
						} else
							content = content.concat(String.format("%n" + scan.nextLine()));
					}
				}

				// read one specific line
				else {
					while (count != lineToRead) {
						if (lineToRead < 0)
							break;
						content = scan.nextLine();
						count++;
					}
				}

				scan.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return content;
	}

	public void write(GameFile gamefile, String text) {
		write(gamefile, text, 0);
	}

	public void write(GameFile gamefile, String text, int lineToReplace) {
		File file = new File("ressources/" + gamefile.getFilename() + ".csv");
		String fileContent = read(gamefile);
		String[] alllines = fileContent.split(System.getProperty("line.separator"));
		int size = alllines.length;

		FileWriter writer = null;

		try {
			writer = new FileWriter(file);

			// write the whole file
			if (lineToReplace == 0) {
				writer.write(text);
			}

			// write one specific line
			else {
				for (int i = 0; i < size; i++) {
					if (i != lineToReplace)
						writer.write(String.format(alllines[i] + "%n"));
					else
						writer.write(String.format(text + "%n"));
				}
			}

			writer.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(GameFile gamefile) {
		File file = new File("ressources/" + gamefile.getFilename() + ".csv");
		if (file.exists())
			file.delete();
	}

}
