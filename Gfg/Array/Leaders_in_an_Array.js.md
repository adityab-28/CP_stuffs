<h2 align="center"> Leader in an Array </h2>

> *Easy Accuracy: 49.96% Submissions: 88053 Points: 2*

### `Prob:`

Given an array A of positive integers. Your task is to find the leaders in the array.

An element of array is leader if it is greater than or equal to all the elements to its right side.

The rightmost element is always a leader. 


Example 1:
```
Input:
  n = 6
  A[] = {16,17,4,3,5,2}
Output: 17 5 2
Explanation: 
  The first leader is 17 as it is greater than all the elements to its right.
  Similarly, the next leader is 5. The right most element is always a leader so it is also included.
```

Example 2:
 ```
Input:
  n = 5
  A[] = {1,2,3,4,0}
Output: 4 0
```

**Your Task:**<br>
  You don't need to read input or print anything. The task is to complete the function `leader()` which takes array A and n as input parameters and `returns` an array of leaders in order of their appearance.

**Expected Time Complexity:  O(n)<br>
Expected Auxiliary Space:  O(n)**
<br>

***`Constraints:`***
- _1 <= n <= 107_
- _0 <= Ai <= 107_


> ** JavaScript Solution Code**

<p>
<details>
<summary>Driver Code (Click to Expand)</summary>

These details <em>remain</em> <strong>hidden</strong> until expanded.

<pre><code>
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let a = new Array(n);
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        for(let i=0;i<n;i++)
            a[i] = input_ar1[i];
        let obj = new Solution();
        let ans = obj.leaders(a, n);
        let S = '';
        for(let i=0;i<ans.length;i++)
        {
            S+=ans[i];
            S+=' ';
        }
        console.log(S);
    }
}
/**
 * @param {number[]} a
 * @param {number} n
 * @returns {number[]}
 */
 javaScript
  //Initial Template for javascript
 'use strict';
</code></pre>

</details>
</p>
 
```JavaScript
class Solution {
    //Function to find the leaders in the array.
    leaders(arr, n){
        // code here
        let res = [];
        res.push(arr[n-1]);
        if(n==1) return res;
        
        var max = arr[n-1];
        for(let i=n-2; i>=0; i--){
            if(arr[i]>=max) {
                max = arr[i];
                res.push(arr[i]);
            }
        }
        res.reverse();
        return res;
    }
}

```

>> <b>Comments :-<b>
 
`Logic/Approach`<br>
- The  main catch in this problem is to traverse from back-side. If we try to see from left to right, the it will be very difficult to find any soltion with time complexed O(n) time complexity.

- So, Traverse all the elements from right to left in array and check whether the current element is greater than the maximum stored till now.

---

Link :- [https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/?track=md-arrays&batchId=144](https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1/?track=md-arrays&batchId=144)
