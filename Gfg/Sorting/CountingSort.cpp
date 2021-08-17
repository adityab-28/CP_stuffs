/*****  _______________________________________  Counting Sort  ____________________________________________ *****/
//Comment Here..........
    Easy Accuracy: 50.34% Submissions: 18575 Points: 2
    
 Prob:  Given a string arr consisting of lowercase english letters, arrange all its letters in lexicographical order using Counting Sort.

    Example 1:
      Input:
      N = 5
      S = "edsab"
      Output:
      abdes
      Explanation: 
      In lexicographical order, string will be 
      abdes.
        
    Example 2:
      Input:
      N = 13
      S = "geeksforgeeks"
      Output:
      eeeefggkkorss
      Explanation:
      In lexicographical order, string will be 
      eeeefggkkorss.
        
-------------------------------
    Your Task:
      This is a function problem.
      You only need to complete the function countSort() that takes string arr as a parameter and returns the sorted string.
      The printing is done by the driver code.

    Expected Time Complexity: O(N).
    Expected Auxiliary Space: O(N).

    Constraints:
    1 ≤ N ≤ 105

// Comment End Here...............
/*** ---___---___---___---___---___---___---___---___--- ____ My Solution   ___---___---___---___---___---___---___---___---___--- ***/
 
 //Initial Template for C++

  #include <bits/stdc++.h>
  using namespace std;
  #define RANGE 255

  class Solution{
      public:
      //Function to arrange all letters of a string in lexicographical 
      //order using Counting Sort.
      string countSort(string arr){
          // code here
          int len = arr.length();
          int count[26] = {0};
          for(int i=0; i<len; i++) {
              count[arr[i] - 'a']++;
          }
          for(int j=1; j<26; j++){
              count[j] += count[j-1];
          }
          char *ans = new char[len];
          int pos=0;
          for(int i=0;i<len; i++) {
              pos = (int)(arr[i] - 'a');
              ans[count[pos]-1] = arr[i];
              count[pos]--;
          }
          string str = "";
          pos = 0;
          while(pos<len){
              str += ans[pos++];
          }
          //for(int i=0; i<len; i++) cout<<ans[i]<<", ";
          return str;
      }
  };

  int main()
  {
      int t;
      cin>>t;
      while(t--)
      {
          int n;
          cin>>n;
          string arr;
          cin>>arr;
          Solution obj;
          cout<<obj.countSort(arr)<<endl;
      }
      return 0;
  }
  // } Driver Code Ends     
