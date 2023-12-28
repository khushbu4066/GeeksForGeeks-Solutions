//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


class Solution{
    static boolean match(String wild, String pattern)
    {
       String ans ="";
       for(int i=0;i<wild.length();i++){
           if(wild.charAt(i)=='*'){
               ans=ans+"[a-zA-A]*";
           }else if(wild.charAt(i)=='?'){
               ans=ans+".";
           }else{
               ans=ans+wild.charAt(i);
           }
       }
        return pattern.matches(ans);
    }
}