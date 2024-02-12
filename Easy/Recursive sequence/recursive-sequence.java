//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.sequence(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long sequence(int n){
        
        //Constants
        long mod = 1000000007;
        long sum = 0;
        long count = 1;
        
        // For every term go in sequence
        
        for(int i = 1; i<=n; i++){
            
            // Product of consecutive numbers
            
            long mul = 1;
            for(int j = 1; j<=i; j++){
                mul = (mul * count) % mod;
                count++;
            }
            
            //Update cumulative sum
            sum = (sum + mul) % mod;
        }
        
        // At last return the result, by taking modulo mod
        return sum;
        
    }
}