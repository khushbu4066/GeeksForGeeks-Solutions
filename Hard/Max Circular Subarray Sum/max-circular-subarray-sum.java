//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
      // Corner case
      if(n == 1) return a[0];
      
      /// sum store the total sum of the array
      int sum = 0;
        for(int i = 0; i<n; i++){
          sum += a[i];
          
        }
        
        //Intialize every variable with the first value of the array
        int curr_max = a[0], maxSoFar = a[0], 
        curr_min = a[0], minSoFar = a[0];
        
        // Kadane's Algorithm
        for(int i = 1; i<n; i++){
            curr_max = Math.max(curr_max + a[i], a[i]);
            maxSoFar = Math.max(curr_max, maxSoFar);
            
            curr_min = Math.min(curr_min + a[i], a[i]);
            minSoFar = Math.min(curr_min , minSoFar);
        }
        
        if(minSoFar == sum){
            return maxSoFar;
        }
        
        return Math.max(maxSoFar, sum - minSoFar);
        
    }
    
}

