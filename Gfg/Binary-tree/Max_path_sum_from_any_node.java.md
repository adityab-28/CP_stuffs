<h3 align="center">Maximum path sum from any node</h2>
   
> _`Binary Tree`_

**`Prob :`** Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Example 1:
```
Input:
     10
    /  \
   2   -25
  / \  /  \
 20 1  3  4

Output: 32

Explanation: Path in the given tree goes
 like 10 , 2 , 20 which gives the max
 sum as 32.
```

Example 2:
```
Input:
     10
   /    \
  2      5
	  \
	  -2

Output: 17

Explanation: Path in the given tree goes
 like 2, 10, 5 which gives the max sum
 as 17.
```

**Task:**<br>
 To complete the function `findMaxSum()` that takes root as input and returns max sum between any two nodes in the given Binary Tree.

**Expected Time Complexity: O(N).<br>
Expected Auxiliary Space: O(Height of the Tree).**

***Constraints:***
- _1 ≤ Number of nodes ≤ 10<sup>3</sup>_
- _1 ≤ |Data on node| ≤ 10<sup>4</sup>_
<br>

> **JAVA SOLUTION CODE**

<p><details>
<summary>Driver Code</> (Click to Expand) :point_down: </summary>

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
	  String s= br.readLine();
	  Node root = buildTree(s);
	       
     Solution tr=new Solution();
     int sum=tr.findMaxSum(root);
	   System.out.println(sum);
	  }
  }
 }// } Driver Code Ends


/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/

class Solution
{
    //Function to return maximum path sum from any node in a tree.

   int MAX;
    //Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node)
    {
        //your code goes here
        MAX=Integer.MIN_VALUE;
        int w=trav(node);
        return MAX;
    }
    int trav(Node root) {
        if(root==null) return 0;
        int l=trav(root.left);
        int r=trav(root.right);
        
        MAX=Math.max(MAX, root.data);
        MAX=Math.max(MAX, l+root.data);
        MAX=Math.max(MAX, r+root.data);
        MAX=Math.max(MAX, l+r+root.data);
        
        return Math.max(Math.max(l, r)+root.data, root.data);
    }
    
}

```
  
</details>
</p>

```Java

//Node defined as
//class Node{
//    int data;
//    Node left,right;
//    Node(int d){
//        data=d;
//        left=right=null;
//    }
//}

class Solution
{
	//Function to return maximum path sum from any node in a tree.
	int MAX;
  
	//Function to return maximum path sum from any node in a tree.
  int findMaxSum(Node node) {
		//your code goes here
		MAX=Integer.MIN_VALUE;
		int w=trav(node);
		return MAX;
	}
	int trav(Node root) {
		if(root==null) return 0;
		int l=trav(root.left);
		int r=trav(root.right);

		MAX=Math.max(MAX, root.data);
		MAX=Math.max(MAX, l+root.data);
		MAX=Math.max(MAX, r+root.data);
		MAX=Math.max(MAX, l+r+root.data);

		return Math.max(Math.max(l, r)+root.data, root.data);
	}  
}

```
<br>
<hr>

> ***Comments:***

_For each node there can be four ways that the max path goes through the node:_
1. _Node only_
2. _Max path through Left Child + Node_
3. _Max path through Right Child + Node_
4. _Max path through Left Child + Node + Max path through Right Child_

_The idea is to keep trace of four paths and pick up the max one in the end. An important thing to note is, root of every subtree needs to return maximum path sum such that at most one child of root is involved.
<br>This is needed for parent function call._


