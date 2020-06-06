# CSX42: Design Patterns - Assignment 4

## Architecture :

-> Spawn N threads to read from the input file. Depending on the value of N, created N appropriate data structures(ArrayList) to store the input values.

-> Each thread does the following:

  o	Thread-M read from inputM.txt and store the values in data structure.

  o	The data in the data structure is sorted (using mergesort)).

  o	Thread-M writes its data into a data structure in Results.java that is shared by all the threads.
  

## Description:

I have used ArrayList to store my the input values from input files.
ArrayLists are useful when we have to do lot of manipulations in our program. So I have used ArrayList
as a data structure since we have to sort these input values.
For sorting MergeSort is used which works on Divide and Conquer principle.Time Complexity of MergeSort is O(nlogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and take linear time to merge two halves.

Finally again I have used ArrayList for storing sorted output values which is shared among three threads.

I have created threads based on value of N provided in 1st cmd argument and my ThreadWorker class implements Runnable to run the threads.

Synchronization is used to store output values in shared arraylist of threads in Results.




