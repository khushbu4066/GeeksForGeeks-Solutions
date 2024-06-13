//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int countNumberswith4(int n) {
        int count = 0; 
        // Step 1: Initialize a counter to zero
        
        for (int i = 1; i <= n; i++) { 
            // Step 2: Loop through each number from 1 to n
            String numStr = Integer.toString(i);  
            // Step 3: Convert the current number to a string
            
            if (numStr.contains("4")) {  
                // Step 4: Check if the string contains the character '4'
                count++;  
                // Step 5: If it does, increment the counter
            }
        }
        
        return count; 
        // Step 6: Return the counter after the loop ends
    }
}