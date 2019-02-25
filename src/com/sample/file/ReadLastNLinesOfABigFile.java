package com.sample.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadLastNLinesOfABigFile {

	public static void main(String[] args) {
		ReadLastNLinesOfABigFile rf = new ReadLastNLinesOfABigFile();
		File file = new File(
				"C:\\Workspace\\Eclipse-TextUML\\Eclipse-Neon\\workspace-inter\\SampleProject\\src\\com\\sample\\file\\aa.txt");

		System.out.println("The number of lines to be printed from last of the file:");
		Scanner scan = new Scanner(System.in);
		int numberOfLinesToBePrintedFromLast = scan.nextInt();
		// calling method
		rf.readFromLast(file, numberOfLinesToBePrintedFromLast);

	}

	public void readFromLast(File file, int numberOfLinesToPrintFromLast) {

		StringBuilder builder = new StringBuilder();
		RandomAccessFile randomAccessFile = null;
		try {
			randomAccessFile = new RandomAccessFile(file, "r");
			long fileLength = file.length() - 1;
			// Set the pointer at the last of the file
			randomAccessFile.seek(fileLength);
			int lineCountFromLast = 0;
			for (long pointer = fileLength; pointer >= 0; pointer--) {
				randomAccessFile.seek(pointer);
				char c;
				// read from the last one char at the time
				c = (char) randomAccessFile.read();

				if (c == '\n') {
					lineCountFromLast++;
					if (numberOfLinesToPrintFromLast == lineCountFromLast) {
						break;
					}
				}
				builder.append(c);
			}
			// Since line is read from the last so it
			// is in reverse so use reverse method to make it right
			builder.reverse();
			System.out.println(builder.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (randomAccessFile != null) {
				try {
					randomAccessFile.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
