//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int solve(int n){
        
        int sum = (n/2) + (n/3) + (n/4);
        if(sum > n){
            int a = solve(n/2);
            int b = solve(n/3);
            int c = solve(n/4);
            
            int sum2 = a + b + c;
            
            return Math.max(sum, sum2);
        }
        
        else{
            return n;
        }
        
    }
    
    public int maxSum(int n) 
    { 
        //code here.
        return solve(n);
    } 
}
