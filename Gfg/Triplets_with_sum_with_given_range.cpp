/****************** Problem Description *******************/

/*  ---   Triplets with sum with given range   ---
    ---   Medium Accuracy: 39.71% Submissions: 5079 Points: 4  ---
      ________________________________________________________________________________
      Given an array Arr[] of N distinct integers and a range from L to R, the task is to count the number of triplets having a sum in the range [L, R].

      Example 1:
      Input:
      N = 4
      Arr = {8 , 3, 5, 2}
      L = 7, R = 11
      Output: 1
      Explaination: There is only one triplet {2, 3, 5}
      having sum 10 in range [7, 11].

      Example 2:

      Input:
      N = 5
      Arr = {5, 1, 4, 3, 2}
      L = 2, R = 7
      Output: 2
      Explaination: There two triplets having 
      sum in range [2, 7] are {1,4,2} and {1,3,2}.

      Your Task:
      You don't need to read input or print anything. Your task is to complete the function countTriplets() which takes the array Arr[] and its size N and L and R as input parameters and returns the count.


      Expected Time Complexity: O(N2)
      Expected Auxiliary Space: O(1)


      Constraints:
      1 ≤ N ≤ 103
      1 ≤ Arr[i] ≤ 103
      1 ≤ L ≤ R ≤ 109

      #Topic Tags
       Sorting
*/
//  ________________________________________________________________
/*************************    Solution     *************************/

#include<bits/stdc++.h> 
using namespace std; 

class Solution {
  public:
    int countSum(int Arr[], int N, int x){
        int count=0;
        int pre = 0;
        cout<<"\nfor val="<<x<<endl;
        while(pre<N-2){
            cout<<" pre="<<pre<<endl<<"\t";
            int cur = pre+1;
            int nxt = N-1;
            while(cur!=nxt){
                int sum = Arr[pre] + Arr[cur] + Arr[nxt];
                if(sum>x) 
                    nxt--;
                else{
                    count += (nxt-cur);
                    cout<<"count="<<count<<",";
                    cur++;
                }cout<<"in("<<cur<<", "<<nxt<<"), ";
            }
            pre++;
        }
        return count;
    }
    int countTriplets(int Arr[], int N, int L, int R) {
        // code here
        if(N<3) return 0;
        
        std::sort(Arr, Arr+N);
        for(int i=0;i<N;i++) cout<<Arr[i]<<", ";
        int R_val = countSum(Arr, N, R);
        int L_val = countSum(Arr, N, L-1);
        return R_val-L_val;
    }
};
// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        int Arr[N];
        for (int i = 0; i < N; i++) cin >> Arr[i];
        int L, R;
        cin >> L >> R;
        Solution obj;
        cout << "\nThe answer is: " << obj.countTriplets(Arr, N, L, R) << endl;
    }
    return 0;
}  // } Driver Code Ends
