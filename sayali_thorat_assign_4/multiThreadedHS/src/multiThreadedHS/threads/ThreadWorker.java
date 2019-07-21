/**
 * 
 */
package multiThreadedHS.threads;

import java.io.BufferedReader;

import multiThreadedHS.util.FileProcessor;

/**
 * @author sayali
 *
 */
/*public class ThreadWorker implements Runnable{
	
	private String fileName =null;
	//private String input2 =null;
	
	public ThreadWorker(String inputFile) {
		
		this.fileName = inputFile;
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try 
		{
			
			
			FileProcessor fpobj = new FileProcessor();
			
			BufferedReader br1 = fpobj.OpenFile(fileName);
			String line = fpobj.readLine(br1);
			System.out.println("\nStart reading file : "+fileName);
				
			while (line != null) {
				System.out.println(line);
				line = fpobj.readLine(br1);
					
			}
				
			System.out.println("End reading file : "+fileName);
			
			
		}
		catch (Exception e)
		{
			System.out.println("Exception in threads for run caught");
		}
		
	}


	

} */

public class ThreadWorker {
	
	private String input1 =null;
	private String input2 =null;
	private String input3 =null;
	private String[] InputArr = new String[3];
	
	
	
	
	public ThreadWorker(String inputFile1, String inputFile2, String inputFile3) {
		
		this.input1 = inputFile1;
		this.input2 = inputFile2;
		this.input3 = inputFile3;
		
		this.InputArr[0]= input1;
		this.InputArr[1]= input2;
		this.InputArr[2]= input3;
	}
	
	

	public void createT(int NumOfThreads) {
	
		for(int i=0; i < NumOfThreads; i++) {
		
			Thread obj = new Thread(new RunThreads(InputArr[i]));
			obj.start();
			
			try 
			{
				obj.join();
            } 
			catch (InterruptedException ex) 
			{
					System.out.println("Exception for thread joining caught");
            }
		}
	}
}



