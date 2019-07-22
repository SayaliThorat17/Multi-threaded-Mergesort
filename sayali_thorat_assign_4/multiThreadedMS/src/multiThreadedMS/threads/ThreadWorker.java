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
	 * @param inputFile
	 * @param robj
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
			
				list.add(Integer.parseInt(line));
				//System.out.println(line);
				line = fpobj.readLine(br1);
					
			}
				
			//System.out.println("End reading file : "+fileName);
			//System.out.println(list);
			
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
	