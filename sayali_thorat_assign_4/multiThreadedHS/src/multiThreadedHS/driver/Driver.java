/**
 * 
 */
package multiThreadedHS.driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

import multiThreadedHS.util.FileProcessor;

/**
 * @author sayali
 *this class is used to create all objects and to deal with command line arguments
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException{
		// TODO Auto-generated method stub

		int arguments = args.length;
		
		System.out.println("Number of arguments passed are : "+arguments);
		
		
		/*String inputFile1 =args[0];
		String inputFile2=args[1];
		String inputFile3 = args[2];
		
		FileProcessor fpobj = new FileProcessor();
		String[] filenames = new String[] {inputFile1,inputFile2,inputFile3};
		
		for(String fileName: filenames) {
			
			BufferedReader br1 = fpobj.OpenFile(fileName);
			String line = fpobj.readLine(br1);
			System.out.println("\nStart reading file : "+fileName);
			while (line != null) {
				System.out.println(line);
				line = fpobj.readLine(br1);
				//System.out.println(line);
				
			}
			System.out.println("End reading file : "+fileName);
		}
		 	*/
		
		FileProcessor fpobj = new FileProcessor();
		
		switch(arguments) {
		
		case 6 :
				//String numberArgs =args[0];	
				String inputFile1 =args[1];
				String inputFile2=args[2];
				String inputFile3 = args[3];
				System.out.println("6 Number of args are : "+arguments);
				
				String[] filenames1 = new String[] {inputFile1,inputFile2,inputFile3};
		
				for(String fileName: filenames1) {
			
					BufferedReader br1 = fpobj.OpenFile(fileName);
					String line = fpobj.readLine(br1);
					System.out.println("\nStart reading file : "+fileName);
					while (line != null) {
						System.out.println(line);
						line = fpobj.readLine(br1);
						//System.out.println(line);
				
					}
					System.out.println("End reading file : "+fileName);
				}
		
				break;
				
		case 5 :
				//String nArgs =args[0];
				String input1 =args[1];
				String input2=args[2];
				System.out.println("5 Number of args are : "+arguments);
				
				String[] filenames2 = new String[] {input1,input2};
		
				for(String fileName: filenames2) {
			
					BufferedReader br1 = fpobj.OpenFile(fileName);
					String line = fpobj.readLine(br1);
					System.out.println("\nStart reading file : "+fileName);
					while (line != null) {
						System.out.println(line);
						line = fpobj.readLine(br1);
						//System.out.println(line);
				
					}
					System.out.println("End reading file : "+fileName);
				}
				break;
				
				
		case 4 :
				//String number =args[0];
				String inputF1 =args[1];
				System.out.println("4 Number of args are : "+arguments);
				
				String[] filenames3 = new String[] {inputF1};
		
				for(String fileName: filenames3) {
			
					BufferedReader br1 = fpobj.OpenFile(fileName);
					String line = fpobj.readLine(br1);
					System.out.println("\nStart reading file : "+fileName);
					while (line != null) {
						System.out.println(line);
						line = fpobj.readLine(br1);
						//System.out.println(line);
				
					}
					System.out.println("End reading file : "+fileName);
				}
				break;
				
		default :
				System.out.println("Please enter correct arguments :");
		}
		
		
		
	}

}
