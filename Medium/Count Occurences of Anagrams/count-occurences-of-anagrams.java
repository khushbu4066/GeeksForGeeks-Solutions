//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    boolean allZero(int[] count){
            return Arrays.equals(count,new int[26]);
        }
        
    int search(String pat, String txt) {
        
        int k = pat.length();
        int[] count = new int[26];
        
        for(char ch: pat.toCharArray()){
            count[ ch - 'a']++;
        }
        
        int i = 0, j = 0;
        int n = txt.length();
        int result = 0;
        while(j < n){
            int idx = txt.charAt(j) - 'a';
            count[idx]--;
            
            if(j - i + 1 == k){
                if(allZero(count)){
                    result++;
                }
                
                count[txt.charAt(i) - 'a']++;
                i++;
            }
            j++;
        }
        
        return result;
        
    }
}