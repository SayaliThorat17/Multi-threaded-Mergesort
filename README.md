# CSX42: Design Patterns - Assignment 4


## Description:

I have used ArrayList to store my the input values from input files.
ArrayLists are useful when we have to do lot of manipulations in our program. So I have used ArrayList
as a data structure since we have to sort these input values.
For sorting MergeSort is used which works on Divide and Conquer principle.Time Complexity of MergeSort is O(nlogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and take linear time to merge two halves.

Finally again I have used ArrayList for storing sorted output values which is shared among three threads.

I have created threads based on value of N provided in 1st cmd argument and my ThreadWorker class implements Runnable to run the threads.

Synchronization is used to store output values in shared arraylist of threads in Results.
