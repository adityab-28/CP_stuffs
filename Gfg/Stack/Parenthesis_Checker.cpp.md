<h3 align="center"> Balanced Parenthesis Checker</h3>

> _`Arrays` , `Stack`_

Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.<br>
For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.

Example 1:
```
Input:
{([])}
Output: 
true
Explanation: 
{ ( [ ] ) }. Same brackets can form 
balaced pairs, with 0 number of 
unbalanced bracket.
```
Example 2:
```
Input: 
()
Output: 
true
Explanation: 
(). Same bracket can form balanced pairs, 
and here only 1 type of bracket is 
present and in balanced way.
```
Example 3:
```
Input: 
([]
Output: 
false
Explanation: 
([]. Here square bracket is balanced but 
the small bracket is not balanced and 
Hence , the output will be unbalanced.
```
> **Task:**<br>

To complete the function `ispar()` that takes a string as a parameter and returns a boolean value `true` if brackets are balanced else returns `false`.

- Expected Time Complexity: O(|x|)
- Expected Auixilliary Space: O(|x|)

> **Constraints:**
- 1 ≤ len|x| ≤ 32000

> **C++ Solution Code:**
```CPP
#include<bits/stdc++.h>
using namespace std;

class Solution
{
    public:
    //Function to check if brackets are balanced or not.
    bool ispar(string s)
    {
        // Your code here...
        stack<char> pt;
        for(int i=0;i<s.length(); i++){
            if(s[i]=='('||s[i]=='{'||s[i]=='['){
                pt.push(s.at(i));
            }
            else{
                if(pt.empty()==true) return false;
                else if(matching(pt.top(), s[i])==false) return false;
                else pt.pop();
            }
        }
        
        return ((pt.empty()==true)?true:false);
    }
    bool matching(char a, char b){
        return ((a=='(' && b==')') || (a=='{' && b=='}')||(a=='[' && b==']'));
    }
};
```
<p><details>
<summary> Driver's Code <i>(Click to Expand)</i></summary>

```CPP
// { Driver Code Starts.
int main()
{
   int t;
   string a;
   cin>>t;
   while(t--)
   {
       cin>>a;
       Solution obj;
       if(obj.ispar(a))
        cout<<"balanced"<<endl;
       else
        cout<<"not balanced"<<endl;
   }
}  // } Driver Code Ends
```
</details></p>

Comments: -
- [GFG Problem Link](https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1)
- [LeetCodes Problem Link](https://leetcode.com/problems/valid-parentheses/)
