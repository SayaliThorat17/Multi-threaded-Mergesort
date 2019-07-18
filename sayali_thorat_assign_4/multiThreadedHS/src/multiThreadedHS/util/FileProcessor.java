/**
 * 
 */
package multiThreadedHS.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author sayali
 *this class is used to read the input file and process it.
 */
public class FileProcessor {

	
private String fileName;
	
	
	/*
	 * method to open input file
	 */
	public BufferedReader OpenFile(String fileName) throws FileNotFoundException {
		BufferedReader br;
		
		this.fileName=fileName;
		
			br = new BufferedReader(new FileReader(fileName));
	
		return br;
	}
	
	
	/*
	 * method to read a single line from input file
	 */
	public String readLine(BufferedReader br) {
		String line="";
		try {
			line = br.readLine();
		} catch (IOException e) {
			System.err.print("Error Reading file");
			e.printStackTrace();
		}
			return line;
	}
	
	/*
	 * method to close inputfile
	 */
	public void closeFile(BufferedReader br) throws IOException {
		br.close();
		
	}

}
