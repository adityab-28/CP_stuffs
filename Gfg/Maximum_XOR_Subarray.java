/*****  _______________________________________  Maximum XOR Subarray ____________________________________________ *****/
//Comment Here......
  Medium Accuracy: 47.34%   Submissions: 13093 Points: 4
   
  Prob: Given an array arr[] of size, N. Find the subarray with maximum XOR. A subarray is a contiguous part of the array.
  
  Example 1:
      Input:
      N = 4
      arr[] = {1,2,3,4}
      Output: 7
      Explanation: 
      The subarray {3,4} has maximum xor 
      value equal to 7.
    -----------------------------------------
    Your Task:  
      You don't need to read input or print anything. Your task is to complete the function maxSubarrayXOR() which takes the array arr[], its size N as input parameters and returns the maximum xor of any subarray.

    Expected Time Complexity: O(N)
    Expected Auxiliary Space: O(N)

    Constraints:
      1 <= N <= 105
      1 <= arr[i] <= 105

     Topic Tags
       Trie
 // comment end Here      
       
 /*** ---___---___---___---___---___---___---___---___--- ____ My Solution   ___---___---___---___---___---___---___---___---___--- ***/
  
  import java.io.*;
  import java.util.*;

  class GFG
  {
      public static void main(String args[])throws IOException
      {
          BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
          int t = Integer.parseInt(read.readLine());
          while(t-- > 0)
          {
              int N = Integer.parseInt(read.readLine());
              String input_line[] = read.readLine().trim().split("\\s+");
              int arr[]= new int[N];
              for(int i = 0; i < N; i++)
                  arr[i] = Integer.parseInt(input_line[i]);


              Solution ob = new Solution();

              System.out.println(ob.maxSubarrayXOR(N,arr));


          }
      }
  }
  class Solution{

      static int maxSubarrayXOR(int n, int a[]){
          // code here...
          int x=a[0];
          int head=0,tail=0;
          int m=0;
          while(head+1<n){
              head++;
              x^=a[head];
              m=Math.max(m,x);
              if(x<m){
                  tail++;
                  x=a[tail];
                  if(head!=tail)
                      head--;
              }
          }
          Arrays.sort(a);
          if(a[n-1]>m)
              return a[n-1];

          return m;
      }
  }
