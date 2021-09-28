<h2 align="center" >Print Anagrams Together </h2>

> _Medium Accuracy: 56.1% Submissions: 16765 Points: 4_
    
#### `Prob:` Given an array of strings, return all groups of strings that are anagrams. The groups must be created in order of their appearance in the original array. Look at the sample case for clarification.
	
Example 1:
```	
Input:
	N = 5
	words[] = {act,god,cat,dog,tac}
Output: 
	god dog
	act cat tac
Explanation:	There are 2 groups of anagrams "god", "dog" make group 1. "act", "cat", "tac" make group 2.
```

Example 2:
```
Input:
	N = 3
	words[] = {no,on,is}
Output: 
	no on
	is

Explanation:	There are 2 groups of	anagrams "no", "on" make group 1. "is" makes group 2.
```

> ***Task:***

The task is to complete the function Anagrams() that takes a list of strings as input and returns a list of groups such that each group consists of all the strings that are anagrams.


**Expected Time Complexity:**  O(N\*|S|\*log|S|),  where |S| is the length of the strings.<br>
**Expected Auxiliary Space:**  O(N\*|S|),  where |S| is the length of the strings.

***Constraints:*** 1<=N<=100


**Topic Tags: `Hash`, `Strings`**


> **JAVA CODE:**
```
import java.io.*;
import java.util.*;

class GFG {
		public static void main (String[] args) throws IOException{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				int t=Integer.parseInt(br.readLine().trim());
				while(t > 0)
				{
					int n= Integer.parseInt(br.readLine().trim());
					String x = br.readLine().trim();
					String string_list[] = x.split(" ",n);

					Solution ob = new  Solution();

					List <List<String>> ans = ob.Anagrams(string_list);

					Collections.sort(ans, new Comparator<List<String>>(){
						public int compare(List<String> l1, List<String> l2) {
										String s1 =  l1.get(0);
										String s2 = l2.get(0);

										return s1.compareTo(s2);
								}
						});

					for(int i=0;i<ans.size();i++)
					{
							for(int j=0;j<ans.get(i).size();j++)
							{
									System.out.print(ans.get(i).get(j) + " ");
							}
							System.out.println();
					}
					t--;
			}
	 }
}
class Solution {
		public List<List<String>> Anagrams(String[] string_list) {
				// Code here...
				List<List<String>> list = new ArrayList<>();
				HashMap<String, List<String>> map = new HashMap<>();   // pair<char, count>
				int len = string_list.length;

				for(int i=0; i<len; i++) {
						char c[] = string_list[i].toCharArray();
						Arrays.sort(c);
						String str = new String(c);
						if(!map.containsKey(str)) {
								map.put(str, new ArrayList<>());
						}
						map.get(str).add(string_list[i]);
				}

				list.addAll(map.values());
				return list;
		}
}
```

> _Comments:_

1.  Sort each word separately and then compare it to others to find anagrams.
2.  Use hash map to compare words and store their relative order.


	_Link:_ [goto Problem Page](https://practice.geeksforgeeks.org/problems/print-anagrams-together/1)

---
