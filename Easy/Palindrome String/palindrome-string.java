//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPalindrome(String str) {
        // code here
        str = str.replaceAll("[^\\w]","").toLowerCase();
        
        char[] str1 = str.toCharArray();
        int i = 0, j = str.length()-1;
        while(i<j){
        char temp = str1[i];
            str1[i] = str1[j];
            str1[j] = temp;
            i++;
            j--;
        }
        String str2 = String.valueOf(str1);
        if(str2.equals(str)){
            return 1;
        }
        return 0;
        
    }
};