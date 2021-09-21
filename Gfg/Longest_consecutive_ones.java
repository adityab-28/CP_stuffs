   /******************------------------------ Longest Consecutive 1's  -------------------********************/

  //Easy Accuracy: 57.61% Submissions: 19084 Points: 2
  Given a number N. Find the length of the longest consecutive 1s in its binary representation.

  Example 1:
    Input: N = 14
  Output: 3
  Explanation: 
    Binary representation of 14 is 
    1110, in which 111 is the longest 
    consecutive set bits of length is 3.
  
  Example 2:
    Input: N = 222
  Output: 4
  Explanation: 
    Binary representation of 222 is 
    11011110, in which 1111 is the 
    longest consecutive set bits of length 4. 

  Your Task: 
    You don't need to read input or print anything.
    Your task is to complete the function maxConsecutiveOnes() which returns the length of the longest consecutive 1s in the binary representation of given N.

  Expected Time Complexity: O(log N).
  Expected Auxiliary Space: O(1).

  Constraints:
    1 <= N <= 106
  Company Tags
    Topic Tags
     Bit Magic

/****************-------+++======== LOGIC ==========+++----------************/
 /*
             The idea is based on the concept that if we AND a bit sequence with a left shifted version of itself,
             we’re effectively removing the trailing 1 from every sequence of consecutive 1s.
             
                  11101111   (N)
                & 11011110   (N << 1)
                ---------- 
                  11001110   (N & (N << 1))
                    ^    ^      
                    |    |
               trailing 1 removed
               
            So the operation N = (N & (N << 1)) reduces length of every sequence of 1s by one in binary representation of N.
            If we keep doing this operation in a loop, we end up with N = 0.
            The number of iterations required to reach 0 is actually length of the longest consecutive sequence of 1s.
*/

/************************-------+======= Java Code ------------============****************/

import java.io.*;
import java.util.*;

class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    public static int maxConsecutiveOnes(int N) {
        
        // Your code here
        int count = 0;
        while(N!=0){
            N = N&(N<<1);
            count++;
        }
        return count;
    }
}

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}
