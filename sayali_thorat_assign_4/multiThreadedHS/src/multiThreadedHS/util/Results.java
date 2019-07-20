/**
 * 
 */
package multiThreadedHS.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class implements 2 interfaces FileDisplay and StdoutDisplay to generate output files
 */
public class Results {
	
	 private BufferedWriter bw;
	    private String outputFileName;
	    private File fileWriter;
	    
	    public Results(String outfilename)  {
			// TODO Auto-generated constructor stub
	    	outputFileName=outfilename;
	    	fileWriter = new File(outputFileName);
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
	    
	    /*
	     * This is used to print the output on commandline
	     * @param string s : which will be printed
	     */
		public void writeToStdout( String s)
		{
			System.out.println(s);
		}
		
		
		
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
		public void closeFile() throws IOException {
			bw.close();
		}


}
