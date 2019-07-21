/**
 * 
 */
package multiThreadedHS.threads;
import java.io.BufferedReader;
import java.util.ArrayList;

import multiThreadedHS.util.FileProcessor;

/**
 * @author sayali
 *
 */
public class RunThreads implements Runnable{

	
	private String fileName =null;
	//private String input2 =null;
	
	public RunThreads(String inputFile) {
		
		this.fileName = inputFile;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			
			
			FileProcessor fpobj = new FileProcessor();
			
			BufferedReader br1 = fpobj.OpenFile(fileName);
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			String line = fpobj.readLine(br1);
			
			System.out.println("\nStart reading file : "+fileName);
				
			while (line != null) {
			
				list.add(Integer.parseInt(line));
				System.out.println(line);
				line = fpobj.readLine(br1);
					
			}
				
			System.out.println("End reading file : "+fileName);
			System.out.println(list);
			
		}
		catch (Exception e)
		{
			System.out.println("Exception in threads for run caught");
		}
		
	}


}
