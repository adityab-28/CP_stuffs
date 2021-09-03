/***********************       Stickler_Thief         *********************/
 
    
Easy Accuracy: 50.32% Submissions: 35696 Points: 2
   Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses.
   According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots.
   The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy.
   He asks for your help to find the maximum money he can get if he strictly follows the rule. 
   Each house has a[i] amount of money present in it.

    Example 1:
      Input:
        n = 6
        a[] = {5,5,10,100,10,5}
      Output: 110
        Explanation: 5+100+5=110
    
    Example 2:
      Input:
        n = 3
        a[] = {1,2,3}
    Output: 4
      Explanation: 1+3=4
    Your Task:
      Complete the function FindMaxSum() which takes an array arr[] and n as input which returns the maximum money he can get following the rules

    Expected Time Complexity: O(N).
    Expected Space Complexity: O(N).

    Constraints:
      1 ≤ n ≤ 104
      1 ≤ a[i] ≤ 104

    Company Tags
      Topic Tags
        Arrays Dynamic Programming
        
/********************************* ---------- Solution ----------------*********************************/
  
  import java.util.*;
  import java.io.*;

  class GFG
   {
    public static void main (String[] args)
     {

      //taking input using Scanner class
      Scanner sc = new Scanner(System.in);

      //taking count of testcases
      int t = sc.nextInt();
      while(t-- > 0){

          //taking count of houses
          int n = sc.nextInt();
          int arr[] = new int[n];

          //inserting money present in 
          //each house in the array
          for(int i = 0; i<n; ++i)
               arr[i] = sc.nextInt();

            //calling method FindMaxSum() of class solve
            System.out.println(new Solution().FindMaxSum(arr, n));
     }
     }
  }

  class Solution
  {
      //Function to find the maximum money the thief can get.
      public int FindMaxSum(int arr[], int n)
      {
          // Your code here
          int inc, exc;
          inc = arr[0];
          exc = 0;
          for (int i=1; i<n; i++) {
              int newInc = exc + arr[i];
              int newExc = Math.max(inc, exc);

              inc = newInc;
              exc = newExc;
          }

          return Math.max(inc, exc);
      }
  }
