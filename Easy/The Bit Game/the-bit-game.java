//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            long N;
            N = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            int res = obj.swapBitGame(N);
            
            System.out.println(res);
            
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int swapBitGame(long N) {
        // code here
        
        int ans = 0;
        while(N>0){
            ans+=(N&1);
            N = N>>1;
        }
        if(ans%2==1){
            return 1;
        }
        return 2;
        
    }
}

//O(logN)