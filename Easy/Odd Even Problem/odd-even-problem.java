//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        
        int[] count = new int[26];
        int odd = 0;
        int even = 0;
        
        for(int i = 0; i<s.length(); i++){
            count[(int) s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i<26; i++){
            int ch = i+1;
            int val = count[i];
            
            if(val != 0){
                if(ch % 2 == 0 && val%2 == 0) odd++;
                else if(ch%2 != 0 && val % 2 != 0) even++;
            }
        }
        
        String ans = ((odd + even) % 2) != 0 ? "ODD" : "EVEN";
        return ans;
    }
}
