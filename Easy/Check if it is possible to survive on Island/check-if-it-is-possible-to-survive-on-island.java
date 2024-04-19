//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        
        //if food required each day > maximum unit of food you can buy each day
        if(N<M) return -1;
        
        //weekly units requirement > weekly units you can buy
        if(S>6 && (6*N)-(7*M)<0) return -1;
        
        // return the no. of days you can survive
        else return (int) Math.ceil((double)(S*M)/(double)N);
        
       
    }
}

