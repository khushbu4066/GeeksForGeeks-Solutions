//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine().trim();
            String[] S1 = s1.split(" ");
            int n = Integer.parseInt(S1[0]);
            int k = Integer.parseInt(S1[1]);
            String s2 = br.readLine().trim();
            String[] S2 = s2.split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(S2[i]);
            }
            Solution ob = new Solution();
            boolean ans = ob.canPair(nums, k);
            if (ans)
                System.out.println("True");
            else
                System.out.println("False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if ((nums[i] + nums[j]) % k == 0) {
        //             return true;
        //         }
        //     }
        // }
        // return false;
        //O(n^2)
        
        
        if (nums.length % 2 != 0) {
            return false; // If the array length is odd, it's not possible to form pairs
        }

        HashSet<Integer> remainders = new HashSet<>();

        for (int num : nums) {
            int remainder = num % k;

            // Check if there exists a pair whose sum is divisible by k
            if (remainders.contains((k - remainder) % k)) {
                remainders.remove((k - remainder) % k); // Remove the pair to avoid duplicates
            } else {
                remainders.add(remainder);
            }
        }

        return remainders.isEmpty();
    }
}

