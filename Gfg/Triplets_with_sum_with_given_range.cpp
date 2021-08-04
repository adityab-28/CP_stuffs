
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
