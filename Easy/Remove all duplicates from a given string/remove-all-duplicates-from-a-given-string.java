//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        
        String ans="";
        HashSet<Character> hs = new HashSet<>();
        
        for(int i = 0; i<str.length(); i++){
            if(!hs.contains(str.charAt(i))){
                hs.add(str.charAt(i));
                ans += str.charAt(i);
            }
        }
        
        return ans;
        
    }
}

