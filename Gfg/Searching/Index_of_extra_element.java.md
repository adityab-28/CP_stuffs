<h3 align="center"> Index of Extra Element </h3>

##### `Arrays` `Searching`
  
> _Easy Accuracy: 50.04% Submissions: 54766 Points: 2_

`Prob:` Given two sorted arrays of distinct elements. There is only 1 difference between the arrays. First array has one element extra added in between. Find the index of the extra element.

Example 1:
```
  Input:
    N = 7
    A[] = {2,4,6,8,9,10,12}
    B[] = {2,4,6,8,10,12}
  
  Output: 4
  Explanation: In the second array, 9 is missing and it's index in the first array is 4.
```

Example 2:
```
Input:
  N = 6
  A[] = {3,5,7,9,11,13}
  B[] = {3,5,7,11,13}

Output: 3
```

**`Task:`**

  Complete the provided function `findExtra()` that takes array A[], B[] and size of A[] and `return` the valid index (0 based indexing).

**Expected Time Complexity: O(log N).<br>
Expected Auxiliary Space: O(1).**

<em>
***Constraints:***<br>
- 2<=N<=10<sup>4</sup><br>
- 1<=A <sub>i</sub> <=10 <sup>5</sup>
</em>

>JAVA CODE Solutions
<p>
<details>
<summary>Driver Code (Click to Expand) </summary>

```JAVA
import java.util.*;
class ExtraElement {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int t = sc.nextInt();
      while (t-- > 0) {
          int n = sc.nextInt();
          int[] a = new int[n];
          int[] b = new int[n - 1];
          for (int i = 0; i < n; i++) a[i] = sc.nextInt();
          for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
          Solution g = new Solution();
          System.out.println(g.findExtra(a, b, n));
      }
  }
}// } Driver Code Ends
```
</details>
</p>

```Java
class Solution {
  public int findExtra(int a[], int b[], int n) {
      // add code here.
      int l=0, r=n-1, mid;
      if(a[n-2]==b[n-2]) return n-1;
      while(l<=r){
          mid = l + (r-l)/2;
          if(a[mid]==b[mid]) l=mid+1;
          else r=mid-1;
      }
      return l;
  }
}
```

> ***Comments:***
