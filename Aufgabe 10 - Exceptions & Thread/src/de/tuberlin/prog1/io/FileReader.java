package de.tuberlin.prog1.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * This class is used to read a file line by line and store each line.
 * @author Sebastian Werner
 *
 */
public class FileReader implements Iterable<String >{
	private final File file;
	private final ArrayList<String> lines = new ArrayList<String>();
	
	/**
	 * reads a given file and stores all lines for ease of use.
	 * 
	 * @param file a exisitng file reference
	 * 
	 * @throws IOException if the file cannot be processed e.g. if the file cannot be read. 
	 * @throws IllegalArgumentException if the parameter is wrong 
	 * 	e.g. if the file is null, is not a valid file. 
	 */
	public FileReader(File file) throws IOException{
		if(file == null){
			throw new IllegalArgumentException("File must not be null!");
		}
		this.file = file;
		if(!file.isFile()){
			throw new IllegalArgumentException("The File object must point to a File");
		}
		
		if(!file.canRead()){
			throw new IOException("Cannot read file.");
		}
		
		readContents();
	}
	
	//helper method that reads all lines of a file
	private void readContents() throws IOException {
		try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
			br.lines().forEach({(s)->{lines.add(s);});
		} 
	}
	
	/**
	 * @param index a valid index between 0 and {@link #getNumberOfLines()}
	 * @return the line at a given index
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 */
	public String getLine(int index){
		checkBounds(index);
		return lines.get(index);
	}

	//helper method to check bounds
	private void checkBounds(int index) throws IndexOutOfBoundsException {
		if(index < 0 || index > lines.size()){
			throw new IndexOutOfBoundsException(index+" in not within bounds: [0,"+lines.size()+"]");
		}
	}
	
	/**
	 * @return the number of processed lines
	 */
	public int getNumberOfLines(){
		return lines.size();
	}

	/**
	 * @return a itterator over all lines
	 */
	@Override
	public Iterator<String> iterator() {
		return lines.iterator();
	}
	

	/**
	 * @return a list of all lines
	 */
	public ArrayList<String> getLines(){
		return new ArrayList<>(lines);
	}
	
	/**
	 * @return an iterator over all lines starting after the provided offset
	 * @param offset a value between 0 and {@link #getNumberOfLines()}
	 * 
	 * @throws IndexOutOfBoundsException if the index is invalid.
	 */
	public Iterator<String> iterator(int offset) {
		checkBounds(offset);
		return new Iterator<String>() {
			Iterator<String> src = lines.iterator();
			
			{
				for (int i = 0; i < offset; i++) {
					src.next();
				}
			}
			
			@Override
			public String next() {
				return src.next();
			}
			
			@Override
			public boolean hasNext() {
				return src.hasNext();
			}
		};
	}
	
}
