//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
        int n = arr.length;
        
        if(n == 1) return 0; //if there is only one ele
        if(arr[0] == 0) return -1; // if first ele is 0, we can;t move further
        
        int maxReach = arr[0];  //farthest point we can reach
        int stepEnd = arr[0]; //end of the range for the correct jump
        int jumps = 1;
        
        for(int i = 1; i<n; i++){
            
            //if we reached the last ele
            if( i == n-1) return jumps;
            
            maxReach = Math.max(maxReach, i + arr[i]);
            
            
            if(i == stepEnd){
                jumps++;
                stepEnd = maxReach;
                
                if(stepEnd >= n-1) return jumps;
            }
            
            if(i >= maxReach) return -1;
            
        }
        return -1;
    }
    
}