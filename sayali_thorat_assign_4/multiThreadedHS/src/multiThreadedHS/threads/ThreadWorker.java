/**
 * 
 */
package multiThreadedMS.threads;

import java.io.BufferedReader;
import java.util.ArrayList;


import multiThreadedMS.util.FileProcessor;
import multiThreadedMS.util.MergeSort;
import multiThreadedMS.util.Results;

/**
 * @author sayali
 *
 */
public class ThreadWorker implements Runnable{

	
	private String fileName =null;
	
	Results robj;
	
	public ThreadWorker(String inputFile, Results robj) {
		
		this.fileName = inputFile;
		this.robj = robj;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			
			
			FileProcessor fpobj = new FileProcessor();
			
		//	Results robj = new Results(output);
			
			
			BufferedReader br1 = fpobj.OpenFile(fileName);
			ArrayList<Integer> list = new ArrayList<Integer>();
			ArrayList<Integer> fullList = new ArrayList<Integer>();
			
			String line = fpobj.readLine(br1);
			
			System.out.println("\nStart reading file : "+fileName);
				
			while (line != null) {
			
				list.add(Integer.parseInt(line));
				System.out.println(line);
				line = fpobj.readLine(br1);
					
			}
				
			System.out.println("End reading file : "+fileName);
			System.out.println(list);
			MergeSort msobj = new MergeSort(list);
			msobj.sortGivenArray();
			//System.out.println("hola : " + list);		//sorted list
			fullList = robj.storeLine(list);
			
			System.out.println("hola : " + fullList);		//sorted list
			//MergeSort msobj1 = new MergeSort(fullList);
			//msobj1.sortGivenArray();
		}
		catch (Exception e)
		{
			System.out.println("Exception in threads for run caught");
		}
		
	}
}
	