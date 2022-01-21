<h3 align="center">Leaves to DLL</h3>

Given a Binary Tree of size N, extract all its leaf nodes to form a Doubly Link List starting from the left most leaf. Modify the original tree to make the DLL thus removing the leaf nodes from the tree. Consider the left and right pointers of the tree to be the previous and next pointer of the DLL respectively.

Example 1:
```
Input :
        1
      /   \
     2     3
    / \   / \
   4   5 6   7    

Output: 
Modified Tree :
        1
      /   \
     2     3

Doubly Link List :
4 <-> 5 <-> 6 <-> 7

Explanation:
The leaf nodes are modified to form the DLL 
in-place. Thus their links are removed from 
the tree.
```

**Your Task:**<br> 
Complete the function `convertToDLL()` which takes root of the given tree as input parameter and returns the `head` of the doubly link list.

**Note:**<br>
The generated output will contain the inorder traversal of the modified tree, the DLL from left to right and the DLL from right to left.

*Expected Time Complexity: O(N)<br>
Expected Auxiliary Space: O(height of tree)*


**Constraints:**<br>
- 1 ≤ N ≤ 10<sup>4</sup>

> ***Java Solution Code***
```JAVA
/*
Node is as follows:
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

class Tree{
    // return the head of the DLL and remove those node from the tree as well.
    //List<Node> li = new ArrayList<>();
    Node head=null, prev=null;
    public Node convertToDLL(Node root)
    {
        // Code here
        modifyTree(root);
        return head;
    }
    Node modifyTree(Node root){
        if(root == null) return null;
        if(root.left==null && root.right==null){
            if(head==null) head=prev=root;
            else{
                prev.right = root;
                root.left = prev;
                prev = root;
            }
            return null;
        }
        root.left = modifyTree(root.left);
        root.right = modifyTree(root.right);
        return root;
    }
    
}
```
