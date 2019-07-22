/**
 * 
 */
package multiThreadedMS.threads;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;

import multiThreadedMS.util.FileProcessor;
import multiThreadedMS.util.MergeSort;
import multiThreadedMS.util.MyLogger;
import multiThreadedMS.util.Results;
import multiThreadedMS.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *This class is used to implement Runnable for running operations on threads
 */
public class ThreadWorker implements Runnable{

	
	private String fileName =null;
	Results robj;
	
	/**
	 * Constructor of class ThreadWorker
	 * @param inputFile : InputFile which is currently being read
	 * @param robj : Results instance
	 */
	public ThreadWorker(String inputFile, Results robj) {
		
		this.fileName = inputFile;
		this.robj = robj;
		MyLogger.writeMessage("ThreadWorker Contructor is called.", DebugLevel.CONSTRUCTOR);
	}
	

	/**
	 * Run method of threads is overridden to work according our requirements
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			
			FileProcessor fpobj = new FileProcessor();
			BufferedReader br1 = fpobj.OpenFile(fileName);
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<Integer> fullList = new ArrayList<Integer>();
			
			String line = fpobj.readLine(br1);
			
			//System.out.println("\nStart reading file : "+fileName);
				
			while (line != null) {
			
				int num = Integer.parseInt(line);
				
				/**
				 * Validation to check if input file contains number between 10000 to 99999
				 * if there is such element omit it and continue further
				 */
				if(num<10000 || num>99999) {
					
					//System.out.println("\nInput file should have 5 digit numbers from 10000 to 99999");	
					System.out.println("\nElement "+num+" omitted from inputfile " + fileName +" as elements should be between 10000 to 99999\n");
					line = fpobj.readLine(br1);
				
				}
				else {
					list.add(Integer.parseInt(line));
					line = fpobj.readLine(br1);
				}
			}
				
			//System.out.println("End reading file : "+fileName);

			MergeSort msobj = new MergeSort(list);		//MergeSort is called for individual arraylist
			msobj.sortGivenArray();
			fullList = robj.storeLine(list);
			
			MergeSort msobj1 = new MergeSort(fullList);	//MergeSort is called finally for whole shared arraylist
			msobj1.sortGivenArray();
			
		}
		catch (Exception e)
		{
			System.out.println("Exception in threads for run caught");
		}
		
	}
}
	