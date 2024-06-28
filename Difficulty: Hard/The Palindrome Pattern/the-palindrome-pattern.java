//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public String pattern(int[][] arr) {
        // Code here
          int len = arr.length;

        // Check for palindrome rows
        for (int i = 0; i < len; i++) {
            if (isPalindrome(arr[i], len)) {
                return i + " R";
            }
        }

        // Check for palindrome columns
        for (int i = 0; i < len; i++) {
            int[] palindrome = new int[len];
            for (int j = 0; j < len; j++) {
                palindrome[j] = arr[j][i];
            }
            if (isPalindrome(palindrome, len)) {
                return i + " C";
            }
        }

        return "-1";
    }

    private boolean isPalindrome(int[] palindrome, int len) {
        for (int i = 0; i < len / 2; i++) {
            if (palindrome[i] != palindrome[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
