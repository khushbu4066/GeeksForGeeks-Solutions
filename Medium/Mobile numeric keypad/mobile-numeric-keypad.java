//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        
        if(n==1)
        return 10;
        
        long[][] prev={
            {1,1,1},
            {1,1,1},
            {1,1,1},
            {0,1,0},
        };
        
        long ans=0;
        long[][] cur=new long[4][3];
        for(int i=1;i<n;i++){
            long sum=0;
            for(int row=0;row<4;row++){
                for(int col=0;col<3;col++){
                    if(prev[row][col]==0)
                        continue;
                    cur[row][col]=prev[row][col];
                    if(row-1>=0)
                        cur[row][col]+=prev[row-1][col];
                    if(row+1<4)
                        cur[row][col]+=prev[row+1][col];
                    if(col-1>=0)
                        cur[row][col]+=prev[row][col-1];
                    if(col+1<3)
                        cur[row][col]+=prev[row][col+1];
                    sum+=cur[row][col];
                }
            }
            long temp[][]=prev;
            prev=cur;
            cur=temp;
            ans=sum;
        }
        return ans;
    }
}