![Screenshot 2023-03-27 151851](https://user-images.githubusercontent.com/128548730/227948823-c4101d14-c898-4828-b477-d882266094bf.png)
# Algorithms-
In this problem, there are nine clocks in a 3*3 array shown in figure. The goal is to return all the dials to 12 o'clock with as few moves as possible. There are nine different allowed ways to turn the dials on the clocks. Each such way is called a move. Select for each move a number 1 to 9. That number will turn the dials 90o clockwise on those clocks which are affected according to figure. Write a parallel algorithm using 3 processors to implement this job. Find the speed up and efficiency of your algorithm.


# Input Data
Read nine numbers from the INPUT.TXT file .
These numbers give the start positions of the dials. 12=0 o'clock, 1=3 o'clock, 2=6 o'clock, 3=9
o'clock .The example in figure gives the following input data file:
![Screenshot 2023-03-27 152051](https://user-images.githubusercontent.com/128548730/227950597-407e7bcc-f7bc-4df1-ba93-2ae009a0123c.png)

Output Data
Write to the OUTPUT.TXT file the shortest sequence of moves
(numbers), which returns all the dials to 12 o'clock. In case there are
many solutions, only one is required. In this example
the OUTPUT.TXT file could look as follows 5849:
Example of Method
Each number represents a time according to following table:
0 = 12 o'clock
1 = 3 o'clock
2 = 6 o'clock
3 = 9 o'clock

![Screenshot 2023-03-27 161149](https://user-images.githubusercontent.com/128548730/227965242-54c24b8a-ad7d-439d-8256-631d7b9a83b4.png)


# how to solve this problem 
 we first studies all possible possibilities and presents the best possible And minimum moves and define nine clock's , define all moves and it's affected clock's A-1 B-2 C-3 D-4 E-5 F-6 G-7 H-8 I-9 , move 1 ABDE 1245 , move 2 ABC 123 , move 3 BCEF 2356 , move 4 ADG 147 , move 5 BDEFH 24568 , move 6 CFI 369 , move 7 DEGH 4578 , move 8 GHI 789 , move 9 EFHI 5689 , checks if all clock's in 0 or 12 clock or not , we will use it later , generate all solutions , I moved on all the possibilities,and let move the clocks,each one of them after that , If reached an answer,would put this output in the answer, I moved on all the possibilities,and let move the clocks,each one of them after that , If reached an answer,would put this output in the answer. but we divided into 3 processors , will divide on 3 processors proc1 , proc2 , proc3 , loop moves the processors , find max number of posabilities , find mimimum moves of sequential and possibilities and find minimum moves of parallel and possibilities .
