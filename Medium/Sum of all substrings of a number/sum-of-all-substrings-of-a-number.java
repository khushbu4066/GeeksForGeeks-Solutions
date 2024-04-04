//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends

      
//User function Template for Java

class Solution
{
 //Function to find sum of all possible substrings of the given string.
 public static long sumSubstrings(String s)
 {
 long totalSum=0;
 long sumAtIndex[] = new long[s.length()];
 sumAtIndex[0]=totalSum=(long)(s.charAt(0))-48;
 
 for(int i=1;i<s.length();i++)
 {
 sumAtIndex[i]=((i+1)*((long)(s.charAt(i))-48) + (10*sumAtIndex[i-1]))%1000000007;
 totalSum=(totalSum+sumAtIndex[i])%1000000007;
 
 }
 return (long)(totalSum);
 }
}
