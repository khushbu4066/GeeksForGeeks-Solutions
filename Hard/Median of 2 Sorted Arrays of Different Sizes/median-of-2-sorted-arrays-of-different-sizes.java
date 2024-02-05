//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver
{
    public static void main(String args[]) 
	{ 
	    Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int []a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            
            int  m= sc.nextInt();
            int []b = new int[m];
            for (int i = 0; i < m; i++) b[i] = sc.nextInt();
            
            double res = new GFG().medianOfArrays(n, m, a, b);
            
            if (res == (int)res) System.out.println ((int)res);
            else System.out.println (res);
        }
    		
	} 
}
// } Driver Code Ends


//User function Template for Java

class GFG 
{ 
    static double medianOfArrays(int n, int m, int a[], int b[]) 
    {
        // Your Code Here
         int arr[]=new int[n+m];
        for(int i=0;i<a.length;i++)
        {
            arr[i]=a[i];
        }
        for(int i=0;i<b.length;i++)
        {
            arr[i+a.length]=b[i];
        }
        Arrays.sort(arr);
        if(arr.length%2!=0)
        {
           int temp1=arr.length/2;
            return arr[temp1];
        }
       
            double temp2=arr[arr.length/2];
            double temp3=arr[(arr.length/2)-1];
            double result=(temp2+temp3)/2;
            return result;
    }
}