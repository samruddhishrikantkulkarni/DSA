

/*

Reverse a string using Stack

You are given a string S, the task is to reverse the string using stack.

 

Example 1:


Input: S="GeeksforGeeks"
Output: skeeGrofskeeG

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function reverse() which takes the string S as an input parameter and returns the reversed string.

 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

 

Constraints:
1 ≤ length of the string ≤ 100

 */


import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            Solution obj = new Solution();
            System.out.println(obj.reverse(sc.next()));
        }
	}
}

// } Driver Code Ends


class Solution {
    
    public String reverse(String S){
        
        Stack<Character>str=new Stack<>();
        
        for(int i=0;i<S.length();i++){
            
            str.push(S.charAt(i));
        }
        
        char arr[]=new char[S.length()];
        
        int i=0;
        
        while(!str.empty()){
            arr[i]=str.pop();
            i++;
        }
        
        return new String(arr);
    }

}