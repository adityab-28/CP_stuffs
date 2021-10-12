<h3 align="center"> Sort an array of 0s, 1s and 2s </h3>

> *`Arrays`,		`Sorting`*

#### `Prob:`
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.

Example 1:
```
Input: 
	N = 5
	arr[]= {0 2 1 2 0}
Output:
	0 0 1 2 2
Explanation:
	0s 1s and 2s are segregated 
	into ascending order.
```

Example 2:
```
Input: 
	N = 3
	arr[] = {0 1 0}
Output:
	0 0 1
Explanation:
	0s 1s and 2s are segregated 
	into ascending order.
```

> **`Task:`**

Task is to complete the function `sort012()` that takes an array `arr` and N as input parameters and sorts the array in-place.

*Expected Time Complexity: O(N) <br>
Expected Auxiliary Space: O(1)*


**`Constraints:`** <br>
-	*1 <= N <= 10<sup>6</sup>*
- *0 <= A[i] <= 2*

<br>

> **C Solution Code:**

```C
//Initial Template for C

#include <stdio.h>
//User function Template for C
void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}
void sort012(int a[], int n)
{
    int low=0, mid=0, high=n-1;
    while(mid<=high) {
        if(a[mid]==0) {
            // swap it with low
            swap(&a[mid], &a[low]);
            low++;
            mid++;
        }
        else if(a[mid]==2){
            swap(&a[mid], &a[high]);
            high--;
        }
        else mid++;
    }
} 
```

<p> <details>
<summary>Driver Code <i>(Click to Expand)</i></summary>

```C
// { Driver Code Starts.

int main() {

    int t;
    scanf("%d", &t);

    while(t--){
        int n;
        scanf("%d", &n);
        int arr[n];
        for(int i=0;i<n;i++){
            scanf("%d", &arr[i]);
        }

        sort012(arr, n);

        for (int i = 0; i < n; i++)
            printf("%d ", arr[i]);
        printf("\n");
    }
    return 0;
} // } Driver Code Ends
```
</details> </p>

---

<p>
	<details>
		<summary><strong><em>Comments:</em></strong></summary>
<br>
These are the folowing steps:-
-	Maintain 3 variables low, high and mid
	- low - all elements before low are 0
	- mid - all elements between low and mid are 1
	- high - all elements after high are 2

- Initially low, mid are set at 0 and high is at n-1
-	Now, we iterate mid from 0 to high, and for every element
	- if it is equal to 0, we swap it with element at low, and increement low and mid
	- else if it is equal to 2, we swap it with element at high, and decreement high
	-	else we just increement mid (i.e element is equla to 1)
- This method ensures partition, as low and high maintain elements according to their values, and then change their positions, ensuring all elements before low are lower than low_value and all elements after high are higher than high_value.
	
	</details>
</p>
