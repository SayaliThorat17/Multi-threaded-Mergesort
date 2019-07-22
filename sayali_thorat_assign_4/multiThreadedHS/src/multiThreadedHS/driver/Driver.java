/**
 * 
 */
package multiThreadedMS.driver;


import multiThreadedMS.threads.ThreadWorker;
import multiThreadedMS.util.Results;

/**
 * @author sayali
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	
	
public void createT(int NumOfThreads, String[] InputArr, Results robj) {
		
		for(int i=0; i < NumOfThreads; i++) {
		
			Thread obj = new Thread(new ThreadWorker(InputArr[i], robj), "obj_" + i);
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
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

		int NumOfThreads= Integer.parseInt(args[0]);
		String[] InputArr = new String[3];
		
		
		Driver dobj = new Driver();
		
		if(NumOfThreads == 3) {
			
			String inputFile1 =args[1];
			String inputFile2=args[2];
			String inputFile3=args[3];
			String outputFile = args[4];
			
			InputArr[0]= inputFile1;
			InputArr[1]= inputFile2;
			InputArr[2]= inputFile3;
			
			Results obj = new Results(outputFile);
			dobj.createT(NumOfThreads, InputArr,obj);
			
			
			
		}
		else if(NumOfThreads == 2) {
			
			String inputFile1 =args[1];
			String inputFile2=args[2];
			String outputFile = args[3];
			
			InputArr[0]= inputFile1;
			InputArr[1]= inputFile2;
			InputArr[2]= null;
			
			Results obj = new Results(outputFile);
			dobj.createT(NumOfThreads, InputArr,obj);
			
			
		}
		else if(NumOfThreads == 1) {
			
			String inputFile1 =args[1];
			String outputFile = args[2];
			

			InputArr[0]= inputFile1;
			InputArr[1]= null;
			InputArr[2]= null;
			
			Results obj = new Results(outputFile);
			dobj.createT(NumOfThreads, InputArr,obj);
			
			
		}
		else{
			
			System.out.println("Missing Input or Output File or Debug Value");
		}
		
	 
	}	//try
	catch (Exception e)
	{
		System.out.println("Exception for main caught : Invalid number of Arguments");
	}
	
	}	//main
}