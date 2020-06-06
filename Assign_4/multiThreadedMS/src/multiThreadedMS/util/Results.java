/**
 * 
 */
package multiThreadedMS.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import multiThreadedMS.util.MyLogger;
import multiThreadedMS.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class implements 2 interfaces FileDisplay and StdoutDisplay to generate output files
 */
public class Results {
	
	 private BufferedWriter bw;
	    private String outputFileName;
	    private File fileWriter;
	    
	    public ArrayList<Integer> FullArrList  = new ArrayList<Integer>();		//arraylist
	    public String arr ;
	    public ArrayList<String> Arr1  = new ArrayList<String>();
	    
	    
	    /**
	     * Results to write to output file
	     * @param outfilename : name of output file
	     */
	    public Results(String outfilename)  {
			// TODO Auto-generated constructor stub
	    	outputFileName=outfilename;
	    	fileWriter = new File(outputFileName);
	    	
	    	//FullArrList = new ArrayList();		//
	    	
	    	MyLogger.writeMessage("Results Contructor is called.", DebugLevel.CONSTRUCTOR);

	        // Create file
	    	try {
				fileWriter.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	try {
	    		//System.out.println("Output File :- "+outputFileName);
				bw = new BufferedWriter(new FileWriter(outputFileName));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    
	    /**
	     * StoreFunction 
	     * ArrayList is synchronized for threads to give proper output for shared ArrayList 
	     * @param list : arraylist is used to take input of short sorted arraylist passed by each thread
	     * @return FullArrList : Shared ArrayList between threads to store data
	     */
	   public synchronized ArrayList<Integer> storeLine(ArrayList<Integer> list) {
		   
	    	FullArrList.addAll(list); //getting stored into the arrayList
	    	return FullArrList;
	    	
	    } 
	   
	   
	   /**
	    * Print function implemented to write results to file
	    */
	   public void print() {
		   
		   String line;
		   
		   for (Integer element : FullArrList) {
	    	    //System.out.println(element);
	    	    line = Integer.toString(element);
	    	    writeToFile("\n" + line);
	    	}
		   
	   }
	    
	    /**
	     * This is used to print the output on commandline
	     * @param s : string which will be printed on screen
	     */
		public void writeToStdout( String s)
		{
			System.out.println(s);
		}
		
		
		/**
		 * This is used to write results to file
		 * @param text : writing string to the output file
		 */
		public void writeToFile(String text)
	    {
			//System.out.println("Inside Write sToStdOut"+text);
	            if ( text == null )
	            {
	                    return;
	            }
	            try
	            {
	            	MyLogger.writeMessage("Writing results in File", DebugLevel.IN_RESULTS);
	                    bw.write(text);
	                    
	            }
	            catch( IOException e)
	            {
	                    System.err.println("Error while writing");
	                    e.printStackTrace();
	            }
	    }
		
		
		/**
		 * Function to close the output file
		 * @throws IOException : if error occurs while closing file
		 */
		public void closeFile() throws IOException {
			bw.close();
		}


}
