//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main{
    
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		
		//input number of testcases
		int t=sc.nextInt();
		int m,n;
		while(t-->0) {
		    
		    
            Solution obj = new Solution();
            //input m and n
		    m = sc.nextInt();
		    n = sc.nextInt();
		    System.out.println(obj.posOfRightMostDiffBit(m, n));
		}
	}
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first position with different bits.
    public static int posOfRightMostDiffBit(int m, int n)
    {
        // if(m==n){
        //     return -1;
            
        // }
        // String x = Integer.toBinaryString(m);
        // String y = Integer.toBinaryString(n);
        // int r  = 1;
        // int q = Math.min(x.length(),y.length());
        
        // for(int i = 0; i<q; i++){
        //     if(x.charAt(x.length()-1-i)!=y.charAt(y.length()-1-i)){
        //         return r;
        //     }
        //     else{
        //         r++;
        //     }
        // }
            
        // // Your code here
        // return r;
    
        if(n==m)return -1;
        int c=1;
            while((m&1) == (n&1)){
                m>>=1;
                n>>=1;
                 
                c++;
            }
            return c;
            
    }
}


