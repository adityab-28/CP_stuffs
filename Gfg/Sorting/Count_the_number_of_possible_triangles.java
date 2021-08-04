        /*****  _______________________________________  Count the number of possible triangles ____________________________________________ *****/
/*
Medium Accuracy: 45.44% Submissions: 29599 Points: 4

 Prob: Given an unsorted array arr[] of n positive integers. Find the number of triangles that can be formed with three different array elements as lengths of three sides of triangles. 

        Example 1:
        Input: 
          n = 3
          arr[] = {3, 5, 4}
        Output: 
          1
        Explanation: 
          A triangle is possible 
          with all the elements 5, 3 and 4.
        
        Example 2:
        Input: 
          n = 5
          arr[] = {6, 4, 9, 7, 8}
        Output: 
          10
        Explanation: 
          There are 10 triangles
          possible  with the given elements like
          (6,4,9), (6,7,8),...
  -----------------------
    
    Your Task: 
        This is a function problem. You only need to complete the function findNumberOfTriangles() that takes arr[] and n as input parameters and returns the count of total possible triangles.

        Expected Time Complexity: O(n2).
        Expected Space Complexity: O(1).

        Constraints:
        3 <= n <= 103
        1 <= arr[i] <= 103

        Company Tags
        Topic Tags
         Arrays Sorting
*/
                /*** ---___---___---___---___---___---___---___---___--- ____ My Solution   ___---___---___---___---___---___---___---___---___--- ***/

//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        while(t > 0)
        {
            //taking elements count
            int n = sc.nextInt();
            
            //creating an array of length n
            int arr[] = new int[n];
            
            //adding elements to the array
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            
            //creating an object of class Solutions
            Solution ob = new Solution();
            
            //calling the method findNumberOfTriangles()
            //of class Solutions and printing the results
            System.out.println(ob.findNumberOfTriangles(arr,n));
            t--;
        }
    }
}

class Solution
{
    static int findNumberOfTriangles(int arr[], int n)
    {
        // code here
        int count=0,a=0,b=0;
        Arrays.sort(arr);
        for(int i=n-1;i>1;i--){
            int x=0, y=i-1, z=i;
            while(y>0 && x<y){
                if(arr[x]+arr[y]>arr[z]){
                    count = count+(y-x);
                    y--;
                }
                else{
                    x++;
                }
            }
        }
        return count;
    }
}
