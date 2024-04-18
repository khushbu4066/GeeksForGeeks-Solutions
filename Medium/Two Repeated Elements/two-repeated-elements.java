//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int t = Integer.parseInt(br.readLine());
	    for(int i=0;i<t;i++){
	        int n = Integer.parseInt(br.readLine());
	        String l = br.readLine();
    		String[] sarr = l.split(" ");
    		int[] arr = new int[sarr.length];
    		for(int i1=0;i1<arr.length;i1++){
    			arr[i1] = Integer.parseInt(sarr[i1]);
    		}
    		
            Solution obj = new Solution();
            
            int[] res = obj.twoRepeated(arr, n);
            System.out.println(res[0] + " " + res[1]);
	    }
	}
}
// } Driver Code Ends


class Solution
{
    public int[] twoRepeated(int arr[], int n)
    {
        // Your code here
        int[] res=new int[2];
        int resi=0;
        
        for(int i=0;i<n+2;i++){
            int index=Math.abs(arr[i]);         // taking absolute of number 
            
            if(arr[index]<0)                //if number at index is -ve means it was visited
                res[resi++]=index;
            else                            // if numbe at +ve means visting first time then make it neg 
                arr[index]*=-1;
        }
        
        return res;
    }
    
}