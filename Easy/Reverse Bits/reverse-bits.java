//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            Long X = Long.parseLong(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.reversedBits(X));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static Long reversedBits(Long x) {
        
        String s = Long.toBinaryString(x);
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        for(int i= sb.length(); i<32; i++){
            sb.append('0');
        }
        long result = Long.parseUnsignedLong(sb.toString(), 2);
        return result;
        
    }
};