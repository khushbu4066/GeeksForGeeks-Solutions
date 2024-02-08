//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;




class Array
 {
	public static void main (String[] args)
	 {
	 Scanner sc=new Scanner(System.in);
	 int t=sc.nextInt();
	 while(t-->0)
	    {
	    int n = sc.nextInt();
		    int arr[] = new int[n];
		    for(int i=0;i<n;i++)
		    {
		        arr[i] = sc.nextInt();
		    }
		    int key = sc.nextInt();
		    Solution ob=new Solution();
		    int ar[]=ob.findIndex(arr,n,key);
		    System.out.println(ar[0]+" "+ar[1]);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{ 
    // Function to find starting and end index 
    static int[] findIndex(int arr[], int n, int k) 
    { 
        //code here.
        int start = -1;
        int end = -1;
        
        
        for(int i = 0; i<n; i++){
                if(arr[i] == k){
                    start = i;
                    break;
                }
        }
        
        for(int j = n-1; j>=0; j--){
            if(arr[j]==k){
                end =  j;
                break;
            }
        }
        
        return new int[]{start, end};
        
    }
}