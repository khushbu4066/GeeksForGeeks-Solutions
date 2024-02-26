//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void GenerateSub(String s, int i, String curr, List<String>ans){
        
        if(i == s.length()){
            if(curr.length() >= 1){
                ans.add(curr);
            }
            return;
        }
        
        //not take
        GenerateSub(s, i+1, curr, ans);
        //take
        GenerateSub(s, i+1, curr + s.charAt(i), ans);
    }
    
    
    public List<String> AllPossibleStrings(String s)
    {
        
        List<String> ans = new ArrayList<>();
        GenerateSub(s, 0 , "", ans);
        Collections.sort(ans);
        return ans;
    }
}