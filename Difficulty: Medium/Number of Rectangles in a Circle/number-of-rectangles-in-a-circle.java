//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    int rectanglesInCircle(int r){
        int ans=0;
        int r1 = 4*r*r;
        for(int i=1;i<2*r;i++){
            ans += Math.abs(Math.sqrt(r1 - i*i));
        }
        return ans;
    }
};