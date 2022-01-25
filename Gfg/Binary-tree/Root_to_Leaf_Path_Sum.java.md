<h3 align="center">Root to Leaf Path Sum </h3>

> _`Binary Tree` , `Recursion`_

Given a binary tree and an integer S, check whether there is root to leaf path with its sum as S.

Example 1:
```
Input:
Tree = 
            1
          /   \
        2      3
S = 2

Output: 0

Explanation:
There is no root to leaf path with sum 2.
```
Example 2:
```
Input:
Tree = 
            1
          /   \
        2      3
S = 4

Output: 1

Explanation:
The sum of path from leaf node 3 to root 1 is 4.
```
> **Task:**<br>

Complete the function `hasPathSum()` which takes root node and target sum S as input parameter and returns `true` if path exists otherwise it returns `false`.

***Expected Time Complexity: O(N)<br>
Expected Auxiliary Space: O(height of tree)***

> **Constraints:**
- 1 ≤ N ≤ 10<sup>4</sup>
- 1 ≤ S ≤ 10<sup>6</sup>

> **JAVA Solution Code:**
```JAVA
/*
// A Binary Tree node
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int S) {
        // Your code here
        /*Recursively check if left or right child has
           path sum equal to ( number – value at current node)*/
        if(S==0 && root==null) return true;
        if(S==0 || root==null) return false;
        return hasPathSum(root.left, S-(root.data))||hasPathSum(root.right, S-(root.data));
    }
}
```
