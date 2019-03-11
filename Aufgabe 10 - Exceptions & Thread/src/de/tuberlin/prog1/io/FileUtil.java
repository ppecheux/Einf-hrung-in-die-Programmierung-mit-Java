package de.tuberlin.prog1.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {
	/**
	 * Returns all lines of a file in a given folder
	 * @param folder root folder of the file
	 * @param filename filename of the file to read
	 * @return all read lines
	 * @throws IOException can be caused if the path of this file is invalid or the file cannot be read
	 */
	public static ArrayList<String> readLines(String folder,String filename) throws IOException {
		return getReader(join(folder,filename)).getLines();
	}
	
	/**
	 * Returns all lines of a file
	 * @param filename filename of the file to read
	 * @return all read lines
	 * @throws IOException can be caused if the path of this file is invalid or the file cannot be read
	 */
	public static ArrayList<String> readLines(String filename) throws IOException {
		return getReader(filename).getLines();
	}

	/**
	 * Tests if a given String points to a valid folder
	 * @param folder
	 * @return true if the string contains a folder, false otherwise
	 */
	public static boolean isFolder(String folder) {
		return new File(folder).isDirectory();
	}

	/**
	 * creates a string[] of all files contained within a folder (non recursively)
	 * @param folder
	 * @return list of files
	 */
	public static String[] listAllFilesInFolder(String folder) {
		File root = new File(folder);
		return root.list();
	}
	
	/**
	 * creates a file path form a filename and folder.
	 * 
	 * something like: folder\filename
	 * 
	 * @param folder
	 * @param filename
	 * @return
	 */
	public static String join(String folder, String filename) {
		return new File(folder,filename).getAbsolutePath();
	}

	/**
	 * Creates a FileReader object form the provided file
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static FileReader getReader(String filename) throws IOException {
		return new FileReader(new File(filename));
	}
	
	public static void writeArrayListToFile(String filename,ArrayList<String> lines) throws IOException{
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filename)))){
			for(String line : lines) {
				writer.write(line);
				writer.newLine();
			}
		}
	}
}
