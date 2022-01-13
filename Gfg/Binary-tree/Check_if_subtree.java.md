<h3 align="center"> Check if Subtree </h3>

> _`Binary Tree`_

#### `Prob:` 

Given two binary trees with head reference as T and S having at most N nodes. The task is to check if S is present as subtree in T.
A subtree of a tree T1 is a tree T2 consisting of a node in T1 and all of its descendants in T1.

Example 1:
```
Input:
  T:      1          S:   3
        /   \            /
       2     3          4
     /  \    /
    N    N  4
Output: 1 
Explanation: S is present in T
```

Example 2:
```
Input:
T:      26         S:   26
       /   \           /  \
     10     N        10    N
   /    \           /  \
   20    30        20  30
  /  \            /  \
 40   60         40  60
Output: 1 
Explanation: 
S and T are both same. Hence, it can be said that S is a subtree of T.
```
> **Task:** <br>

Task is to complete the function `isSubtree()` that takes root node of S and T as parameters and `returns` 1 if S is a subtree of T else 0.


*Expected Time Complexity: O(N).<br>
Expected Auxiliary Space: O(N).*

> **Constraints:**

-	1 <= Number of nodes <= 10<sup>5</sup>
-	1 <= Value of nodes <= 10<sup>4</sup>

> **Java Solution Code:**

<p><details>
<summary>Driver Code <i>(Click to Expand)</i></summary>

```JAVA
  
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

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

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
                
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root){
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException {
	        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t-- > 0){
	            String tt= br.readLine();
	            Node rootT = buildTree(tt);
	            
	            String s= br.readLine();
	            Node rootS = buildTree(s);
	           // printInorder(root);
	            
	            Solution tr=new Solution();
	            boolean st=tr.isSubtree(rootT, rootS);
	            if(st==true){
	                System.out.println("1");
	            }else{
	                System.out.println("0");
	            }
	        }
	}
}// } Driver Code Ends
```
</details></p>
          
```JAVA
//User function Template for Java

/* class Node{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=null;
        right=null;
    }
}*/

class Solution {
    public static boolean isSubtree(Node T, Node S) {
        // add code here...
        if(T==null) return false;
        if(S==null) return true;
        
        if(check(T,S)) return true;
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }
    static boolean check(Node t1, Node t2){
        if(t1==null && t2==null) return true;
        else if(t1==null) return false;
        else if(t2==null) return false;
        
        if(t1.data != t2.data) return false;
        
        return (check(t1.left, t2.left) && check(t1.right, t2.right));
    }
}
```

<p><details>
<summary><em><b>Comments: </b></em></summary>

- Other Solution:<br>
          
  ```JAVA
    class Solution {
      ArrayList<Node> nodes;

      Solution() {
          nodes = new ArrayList<>();
      }

      public void recursive(int n) {
          if(n > 0)
              recursive(n-1);
      }

      public boolean isSubtree(Node s, Node t) {
          recursive(100000);
          if(s == null && t == null)
              return true;
          if(s == null || t == null)
              return false;

          getDepth(s, getDepth(t, -1));
          for(Node n : nodes)
              if(identical(n, t))
                  return true;
          return false;
      }

      int getDepth(Node r, int d) {
          if(r == null)
              return -1;

          int depth = Math.max(getDepth(r.left, d), getDepth(r.right, d)) + 1;

          if(depth == d)
              nodes.add(r);
          return depth;
      }

      boolean identical(Node a, Node b) {
          if(a == null && b == null)
              return true;
          if(a == null || b == null || a.data != b.data)
              return false;
          return identical(a.left, b.left) && identical(a.right, b.right);
      }
  }
  ```
          
- [Goto Page 👈](https://practice.geeksforgeeks.org/problems/check-if-subtree/1#)

</details></p>
