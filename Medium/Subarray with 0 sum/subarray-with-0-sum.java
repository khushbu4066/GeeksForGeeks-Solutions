//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
			//code
			
		//taking input using class Scanner
		Scanner scan = new Scanner(System.in);
		
		//taking total number of testcases
		int t = scan.nextInt();
		while(t>0)
		{
		    //taking total count of elements
		    int n = scan.nextInt() ;
		    
		    //Declaring and Initializing an array of size n
		    int arr[] = new int[n];
		    
		    //adding elements to the array
		    for(int i = 0; i<n;i++)
		    {
		        arr[i] = scan.nextInt();
		    }
		    
		    t--;
		    
		     //calling the method findSum
		     //and print "YES" or "NO" based on the result
		     System.out.println(new Solution().findsum(arr,n)==true?"Yes":"No");
		}
	}
	
	
}
// } Driver Code Ends


class Solution{

//Function to check wheather there is a subarray with 0 sum or not.
static boolean findsum(int arr[],int n){

HashSet <Integer> set = new HashSet<>();
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += arr[i];
            if(arr[i] == 0) return true;
            if(sum == 0 || set.contains(sum)) return true;
            else set.add(sum);
        }
        return false;
    
}
}