<h3 align="center"> Counting Sort </h3>

> _`Arrays` , `Sorting`_

#### `Prob:`
Given a string arr consisting of lowercase english letters, arrange all its letters in lexicographical order using Counting Sort.

Example 1:
```
Input:
  N = 5
  S = "edsab"
Output: 
  "abdes"
Explanation: 
  In lexicographical order, string will be "abdes".
```

<p><details>
  <summary><em>Click to view more... :point_down:</em></summary>

Example 2:
```
Input:
  N = 13
  S = "geeksforgeeks"
Output:
  "eeeefggkkorss"
Explanation:
  In lexicographical order, string will be "eeeefggkkorss".
```

**Task:** <br>
To complete the function `countSort()` that takes `string arr` as a parameter and `returns` the sorted string.
The printing is done by the driver code.
</details></p>

*Expected Time Complexity: O(N).<br>
Expected Auxiliary Space: O(N).*

**Constraints:**
- _1 ≤ N ≤ 10_<sup><em>5</em></sup>

> C++ Solution Code 
 
 ```Cpp
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
```
<p>
<details>
<summary><strong><em>Comments: </em></strong></summary>
<br>
  
**Algorithm:**
1) Take a count array to store the count of each unique object.
2) Modify the count array such that each element at each index stores the sum of previous counts. The modified count array indicates the position of each object in the output sequence.
3) Output each object from the input sequence followed by decreasing its count by 1.

- [Goto Page :point_left:](https://practice.geeksforgeeks.org/problems/counting-sort/1)
</details> </p>
