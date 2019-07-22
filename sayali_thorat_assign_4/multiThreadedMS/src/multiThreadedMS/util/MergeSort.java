/**
 * 
 */
package multiThreadedMS.util;
import java.util.ArrayList;
import multiThreadedMS.util.MyLogger.DebugLevel;

/**
 * @author sayali
 *MergeSort is implemented to sort the ArrayList
 *Code citation for MergeSort : https://www.withexample.com/merge-sort-using-arraylist-java-example/
 */
public class MergeSort {
	
	private ArrayList<Integer> inputArray;
	    
	    public ArrayList<Integer> getSortedArray() {
	        return inputArray;
	    }
	 
	    /**
	     * Constructor of MergeSort
	     * @param inputArray : An ArrayList to be sorted
	     */
	    public MergeSort(ArrayList<Integer> inputArray){
	    	
	        this.inputArray = inputArray;
	        MyLogger.writeMessage("MergeSort Contructor is called.", DebugLevel.CONSTRUCTOR);
	    }
	    
	    
	    
	    public void sortGivenArray(){  
	    	
	        divide(0, this.inputArray.size()-1);
	        MyLogger.writeMessage("MergeSort is called", DebugLevel.MERGESORT);
	        
	        
	    }
	    
	    public void divide(int startIndex,int endIndex){
	        
	        //Divide till you breakdown your list to single element
	        if(startIndex<endIndex && (endIndex-startIndex)>=1){
	            int mid = (endIndex + startIndex)/2;
	            divide(startIndex, mid);
	            divide(mid+1, endIndex);        
	            
	            //merging Sorted array produce above into one sorted array
	            merger(startIndex,mid,endIndex);            
	        }       
	    }   
	    
	    public void merger(int startIndex,int midIndex,int endIndex){
	        
	        //Below is the mergedarray that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
	        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
	        
	        int leftIndex = startIndex;
	        int rightIndex = midIndex+1;
	        
	        while(leftIndex<=midIndex && rightIndex<=endIndex){
	            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
	                mergedSortedArray.add(inputArray.get(leftIndex));
	                leftIndex++;
	            }else{
	                mergedSortedArray.add(inputArray.get(rightIndex));
	                rightIndex++;
	            }
	        }       
	        
	        //Either of below while loop will execute
	        while(leftIndex<=midIndex){
	            mergedSortedArray.add(inputArray.get(leftIndex));
	            leftIndex++;
	        }
	        
	        while(rightIndex<=endIndex){
	            mergedSortedArray.add(inputArray.get(rightIndex));
	            rightIndex++;
	        }
	        
	        int i = 0;
	        int j = startIndex;
	        //Setting sorted array to original one
	        while(i<mergedSortedArray.size()){
	            inputArray.set(j, mergedSortedArray.get(i++));
	            j++;
	        }
	    }
	    

}
