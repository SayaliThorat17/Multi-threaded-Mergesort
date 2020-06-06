# CSX42: Design Patterns - Assignment 4


-----------------------------------------------------------------------
-----------------------------------------------------------------------
Citations :

https://www.geeksforgeeks.org/java/
https://stackoverflow.com/
https://stackoverflow.com/questions/29339933/read-and-write-files-in-java-using-separate-threads
https://www.tutorialspoint.com/java/java_multithreading

Citation for MergeSort :
https://www.withexample.com/merge-sort-using-arraylist-java-example/

-----------------------------------------------------------------------
-----------------------------------------------------------------------
Following are the commands and the instructions to run ANT on your project.

-----------------------------------------------------------------------
## Instruction to clean:

In the folder: "Assign_4/multiThreadedMS" run the following command:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

In the folder: "sayali_thorat_assign_4/multiThreadedMS" run the following command:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

In the folder: "sayali_thorat_assign_4/multiThreadedMS" run the following command:

####Command: ant -buildfile src/build.xml run -Dargs="3 input1.txt input2.txt input3.txt output.txt 3"

or

####Command: ant -buildfile src/build.xml run -Dargs="2 input1.txt input2.txt output.txt 4"

or

####Command: ant -buildfile src/build.xml run -Dargs="1 input1.txt output.txt 1"

The first argument should be either 1,2 or 3
The last argument of DebugValue should be between 0 to 4
The inputFiles to be provided depends on value of N.


-----------------------------------------------------------------------
## Description:

I have used ArrayList to store my the input values from input files.
ArrayLists are useful when we have to do lot of manipulations in our program. So I have used ArrayList
as a data structure since we have to sort these input values.
For sorting MergeSort is used which works on Divide and Conquer principle.Time Complexity of MergeSort is O(nlogn) in all 3 cases (worst, average and best) as merge sort always divides the array into two halves and take linear time to merge two halves.

Finally again I have used ArrayList for storing sorted output values which is shared among three threads.

I have created threads based on value of N provided in 1st cmd argument and my ThreadWorker class implements Runnable to run the threads.

Synchronization is used to store output values in shared arraylist of threads in Results.


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: -- 07/22/2019
