//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Compute obj = new Compute();
            long[] product = obj.minAnd2ndMin(a, n); 
            if(product[0]==-1)
                System.out.println(product[0]);
            else
                System.out.println(product[0]+" "+product[1]);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Compute {

    // Method to find the minimum and second minimum values in an array
    public long[] minAnd2ndMin(long a[], long n) {

        // Array to store the minimum and second minimum values
        long[] ans = new long[2];

        // Handle edge case: If the array has 0 or 1 elements, there's no second minimum
        if (n <= 1) {
            // Return -1 for both elements to indicate no distinct minimums
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }

        // Initialize variables to track the minimum and second minimum
        long min = Long.MAX_VALUE; // Start with the largest possible long value
        long smin = Long.MAX_VALUE;

        // Iterate through the array
        for (int i = 0; i < n; i++) {
            if (min > a[i]) {
                // If the current element is smaller than the current minimum:
                smin = min;  // Update second minimum to the current minimum
                min = a[i];  // Update minimum to the current element
            } else if (smin > a[i] && a[i] != min) {
                // If the current element is smaller than the second minimum but not equal to the minimum:
                smin = a[i];  // Update second minimum to the current element
            }
        }

        // Handle cases where there might not be a distinct second minimum
        ans[0] = (smin == Long.MAX_VALUE) ? -1 : min;  // Return -1 for minimum if no second minimum exists
        ans[1] = (smin == Long.MAX_VALUE) ? -1 : smin;  // Return -1 for second minimum if it doesn't exist

        return ans;
    }
}
