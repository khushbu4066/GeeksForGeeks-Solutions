//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String S = sc.next();
            int K = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.removeKdigits(S, K));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String removeKdigits(String s, int k) {
        
        if(k== 0) return s;
        
        if(k == s.length()) return "0";
        
        Stack<Character> st = new Stack<>();
        
        int n = s.length();
        for(int i = 0; i<n; i++){
            char ch = s.charAt(i);
            
            while(!st.isEmpty() && k >0 && st.peek() > ch ){
                st.pop();
                k--;
            }
            
            st.push(ch);
        }
        
        for(int i = 0; i<k; i++){
            st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
        
    }
}