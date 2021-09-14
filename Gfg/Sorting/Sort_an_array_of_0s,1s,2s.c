//Initial Template for C

#include <stdio.h>


 // } Driver Code Ends
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
}
  // } Driver Code Ends

/*************************-------------------- Problem Discription --------------------------***************************/
             /* ============================== Sort an array of 0s, 1s and 2s =============================*/
  /*  Easy Accuracy: 51.36% Submissions: 100k+ Points: 2   */
  
  Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
  
  Example 1:
  Input: 
    N = 5
    arr[]= {0 2 1 2 0}
  Output:
    0 0 1 2 2
  Explanation:
    0s 1s and 2s are segregated 
    into ascending order.
  
  Example 2:
  Input: 
    N = 3
    arr[] = {0 1 0}
  Output:
    0 0 1
  Explanation:
    0s 1s and 2s are segregated 
    into ascending order.

  Your Task:
    You don't need to read input or print anything. Your task is to complete the function sort012() that takes an array arr and N as input parameters and sorts the array in-place.


  Expected Time Complexity: O(N)
  Expected Auxiliary Space: O(1)


  Constraints:
    1 <= N <= 10^6
    0 <= A[i] <= 2

  Company Tags
    Topic Tags
     Arrays Sorting
