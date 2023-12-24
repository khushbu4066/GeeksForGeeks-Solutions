//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution ob = new Solution();
            
            System.out.println(ob.minFlips(S));
                        
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minFlips(String s) {
        // Code here
        int n = s.length();
        int start_with_0 = 0;
        
        for(int i = 0; i<n; i++){
            if(i%2==0){
                if(s.charAt(i)=='0'){
                    start_with_0++;
                }
            }
            else{
                if(s.charAt(i)=='1'){
                    start_with_0++;
                }
            }
        }
        int start_with_1 = n-start_with_0;
        return Math.min(start_with_0, start_with_1);
    }
}