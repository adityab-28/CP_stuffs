<h2 align="center">Sort a stack</h2>
> Easy Accuracy: 50.51% Submissions: 51803 Points: 2     
---
Given a stack, the task is to sort it such that the top of the stack has the greatest element.

Example 1:
```
Input:
Stack: 3 2 1
Output: 3 2 1
```    
Example 2:
```
Input:
Stack: 11 2 32 3 41
Output: 41 32 11 3 2
```   

> **Task: **
 <p> You don't have to read input or print anything.
  The task is to complete the function sort() which sorts the elements present in the given stack.
  _(The sorted stack is printed by the driver's code by popping the elements of the stack.)_
</p>

Expected Time Complexity: O(N*N)
Expected Auxilliary Space: O(N) recursive.

Constraints:
  1<=N<=100
 
 ---
 
> **JAVA Solution Code**  
```
  import java.util.Scanner;
  import java.util.Stack;
  class SortedStack{
    public static void main(String[] args){
      Scanner sc=new Scanner(System.in);
      int t=sc.nextInt();
      while(t-->0){
        Stack<Integer> s=new Stack<>();
        int n=sc.nextInt();
        while(n-->0)
        s.push(sc.nextInt());
        GfG g=new GfG();
        Stack<Integer> a=g.sort(s);
        while(!a.empty()){
          System.out.print(a.peek()+" ");
          a.pop();
        }
        System.out.println();
      }
    }
  }

  class GfG{
    public Stack<Integer> sort(Stack<Integer> s)
    {
      sortStack(s);
      Stack<Integer> stk = s;
        return stk;
    }
    void sortStack(Stack<Integer> st){
        if(!st.isEmpty()){
          int temp = st.pop();
          sortStack(st);
          sortedInsert(st, temp);
      }
    }
    void sortedInsert(Stack<Integer> s, int ele){
        if(s.isEmpty() || (ele>s.peek()))
            s.push(ele);
        else {
            int temp = s.pop();
            sortedInsert(s, ele);
            s.push(temp);
        }
    }
  }
```

---

> **Logic** 
  ![image](https://user-images.githubusercontent.com/72013227/134968679-552daa40-5520-43be-b7f9-481c6b0181a6.png)


Here is a the link of the above problem[^1].

[^1]: [_Link_](https://practice.geeksforgeeks.org/problems/sort-a-stack/1#).
