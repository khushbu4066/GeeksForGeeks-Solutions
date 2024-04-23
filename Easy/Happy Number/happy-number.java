//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isHappy(N));
        }
    }
}
// } Driver Code Ends


class Solution { 
     static int gethelp(int n){
        if(n==1 || n == 7)   return 1;
        if(n== 2 || n==3 || n==4 || n==5 ||n==6 || n ==8 || n==9)   return 0;
        int sum = 0;
        while(n>0){
            int x = n%10;
            sum = sum + x*x;
            n = n/10;
        }
        return gethelp(sum);
    }
  
     static int isHappy(int N) { 
         //code here
        return gethelp(N);
     }
}
