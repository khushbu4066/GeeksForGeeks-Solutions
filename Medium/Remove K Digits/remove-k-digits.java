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


class Solution {
    public String removeKdigits(String S, int k) {
        // code here
        Stack<Character> ms=new Stack<>();
        for(int i=0;i<S.length();i++){
            while(!ms.isEmpty() && ms.peek()>S.charAt(i) && k>0){
                ms.pop();
                k--;
            }
            ms.add(S.charAt(i));
            // System.out.println(ms);
        }
        while(k-->0){
            ms.pop();
        }
        if(ms.isEmpty())
        return "0";
        StringBuilder ans=new StringBuilder();
        while(!ms.isEmpty()){
            ans.append(ms.pop()+"");
        }
        ans=ans.reverse();
        int index=0;
        while(index<ans.length()-1 && ans.charAt(index)=='0'){
            index++;
        }
        return ans.substring(index);
    }
}