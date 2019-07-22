/**
 * 
 */
package multiThreadedMS.driver;


import multiThreadedMS.threads.ThreadWorker;
import multiThreadedMS.util.Results;
import multiThreadedMS.util.MyLogger.DebugLevel;
import multiThreadedMS.util.MyLogger;

/**
 * @author sayali
 *this class is used to create all objects and to deal with command line arguments
 */
public class Driver {
	
	
/**
 * This function is used to create threads based on the value of N provided.
 * Also thread's execution is started here. 
 */
public void createT(int NumOfThreads, String[] InputArr, Results robj) {
		
		for(int i=0; i < NumOfThreads; i++) {
		
			Thread obj = new Thread(new ThreadWorker(InputArr[i], robj), "obj_" + i);
			MyLogger.writeMessage("Thread is created", DebugLevel.THREAD_CREATE);
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
	
	
	/**
	 * the arguments passed to the main file are
	 * @param args N, InputFiles.txt (depending on N), OutputFile.txt and debugger value
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

		int NumOfThreads= Integer.parseInt(args[0]);
		
		String[] InputArr = new String[3];
		
		
		Driver dobj = new Driver();
		
		/**
		 * When you are provided value of N as 3
		 */
		if(NumOfThreads == 3) {					
			
			String inputFile1 =args[1];
			String inputFile2=args[2];
			String inputFile3=args[3];
			String outputFile = args[4];
			String debug_num= args[5];
			
			System.out.println("OutputFile : "+outputFile+"\n");
			
			InputArr[0]= inputFile1;
			InputArr[1]= inputFile2;
			InputArr[2]= inputFile3;
			
			
			int debugValue = Integer.parseInt(args[5]);
			
			if((debugValue >4) || (debugValue<0)) {
				
				System.out.println("Invalid debug argument .Please enter debug value from 0 to 4");
				System.exit(0);
			}
			MyLogger.setDebugValue(debugValue); 
			
			/**
			 * Result instance is created
			 */
			Results obj = new Results(outputFile);	
			
			dobj.createT(NumOfThreads, InputArr,obj);
			
			/**
			 * Writing result to outputfile
			 */
			obj.writeToFile("Final Sorted Output is :\n ");
			obj.print();
			obj.closeFile();
			
			
		}
		
		/**
		 * When you are provided value of N as 2
		 */
		else if(NumOfThreads == 2) {
			
			String inputFile1 =args[1];
			String inputFile2=args[2];
			String outputFile = args[3];
			String debug_num= args[4];
			
			System.out.println("OutputFile : "+outputFile+"\n");
			
			InputArr[0]= inputFile1;
			InputArr[1]= inputFile2;
			InputArr[2]= null;
			
			int debugValue = Integer.parseInt(args[4]);
			
			if((debugValue >4) || (debugValue<0)) {
				
				System.out.println("Invalid debug argument .Please enter debug value from 0 to 4");
				System.exit(0);
			}
			MyLogger.setDebugValue(debugValue); 
			
			/**
			 * Result instance is created
			 */
			Results obj = new Results(outputFile);
			
			dobj.createT(NumOfThreads, InputArr,obj);
			
			/**
			 * Writing result to outputfile
			 */
			obj.writeToFile("Final Sorted Output is :\n ");
			obj.print();
			obj.closeFile();
			
		}
		
		/**
		 * When you are provided value of N as 1
		 */
		else if(NumOfThreads == 1) {
			
			String inputFile1 =args[1];
			String outputFile = args[2];
			String debug_num= args[3];
			
			System.out.println("OutputFile : "+outputFile+"\n");
			
			InputArr[0]= inputFile1;
			InputArr[1]= null;
			InputArr[2]= null;
			
			int debugValue = Integer.parseInt(args[3]);
			
			if((debugValue >4) || (debugValue<0)) {
				
				System.out.println("Invalid debug argument .Please enter debug value from 0 to 4");
				System.exit(0);
			}
			MyLogger.setDebugValue(debugValue);
			
			
			/**
			 * Result instance is created
			 */
			Results obj = new Results(outputFile);
			dobj.createT(NumOfThreads, InputArr,obj);
			
			/**
			 * Writing result to outputfile
			 */
			obj.writeToFile("Final Sorted Output is :\n ");
			obj.print();
			obj.closeFile();
			
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