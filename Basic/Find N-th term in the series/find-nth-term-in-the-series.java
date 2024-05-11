//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            long n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.nthOfSeries(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long nthOfSeries(long n){
        long  a1 = 9;
        long a2 = 33;
        long diff = a2-a1;
        long result = a2;
        for(int i=3; i<=n; i++){
            long newdiff = diff +16;
            result += newdiff;
            diff = newdiff;
        }
        return result;
        
        
    }
}