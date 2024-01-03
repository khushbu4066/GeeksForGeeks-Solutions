//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        // Code here
        int k = 2;   // This variable represents len of substring that we are trying to find.
        
        while(k++ < S.length()) {
            
            for(int i=0; i<=S.length() - k; i++) {
                if((S.substring(i,i+k).contains("0")) && (S.substring(i,i+k).contains("1")) 
                    && (S.substring(i,i+k).contains("2")))
                    
                    return k;
            }
        }
        return -1;
    }
};