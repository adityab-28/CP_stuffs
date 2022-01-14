<h3 align="center"> Clone a stack without using extra space </h3>

> _`Stack` , `Recurrsion`_

#### Prob: 

Given elements of a stack, clone the stack without using extra space.

Example 1:
```
Input:
N = 10
st[] = {1, 1, 2, 2, 3, 4, 5, 5, 6, 7}
Output:
1 
```

> **Tasks:**

Task is to complete the function `clonestack()` which takes the input stack `st[]`, an empty stack `cloned[]`, you have to clone the stack st into stack cloned.
The driver code itself `prints 1` in the output if the stack st is cloned properly and `prints 0` otherwise.

_Expected Time Complexity: O(N\*N)<br>
Expected Auxiliary Space: O(1)_

> **Constraints:**
- 1 <= N <= 1000
- 1 <= st[i] <= 10<sup>5</sup>

> **Code:**

<P><details>
<summary> Driver's Code <i>(Click to Expand)</i></summary>

```JAVA
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
    
            String S[] = read.readLine().split(" ");
            
            Stack<Integer> st = new Stack<Integer>();
            ArrayList<Integer> copy = new ArrayList<>();
            
            for(int i=0; i<N; i++)
            {
                st.push(Integer.parseInt(S[i]));
                copy.add(Integer.parseInt(S[i]));
            }
            
            Collections.reverse(copy);
            
            Stack<Integer> cloned = new Stack<Integer>();
            
            Solution ob = new Solution();
            
            ob.clonestack(st,cloned);
            
            ArrayList<Integer> check = new ArrayList<>();
            while(cloned.size() != 0)
                check.add(cloned.pop());
            
            int flag = 0;
            
            if(copy.equals(check))
                flag = 0;
            else
                flag = 1;
            
            System.out.println(1-flag);
        }
    }
}// } Driver Code Ends
```
</details></p>

_**Recursive -**_ 
```JAVA
class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        // code here
        if(st.isEmpty()==true) 
            return;
        int x = st.peek();
        st.pop();
        clonestack(st, cloned);
        cloned.push(x);
        return;
    }
}
```
_**Iterative -**_ 

The whole idea is to get the bottom-most element of the current stack and then tranfer it to the cloned stack one-by-one.
```JAVA
class Solution {
    void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        // code here
        int count=0;
        int initialSize=st.size();
       for(int i=0;i<initialSize;i++)
       {
           while(st.size()>1)
           {
              cloned.push(st.pop());
              
           }
           int k=st.pop();
           while(cloned.size()>count)
           {
              st.push(cloned.pop()); 
           }
           cloned.push(k);
           count++;
       }
       
    }
}
```
<p><details>
<summary><em><b>Comments: </b></em></summary>

- ![image](https://user-images.githubusercontent.com/72013227/149518306-8bb74dd1-59e2-496c-a4b7-75a130131942.png)

- [Goto Page 👈](https://practice.geeksforgeeks.org/problems/clone-a-stack-without-usinig-extra-space/1)

</details></p>
