//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int N){
        // code here
        String ans=arr[0];
        for(int i=0;i<N-1;i++){
            String x = compare(ans,arr[i+1]);
            if(x==""){
                return "-1";
            }
            ans=x;
        }
        return ans;
    }
    String compare(String a, String b){
        int i=0,j=0;
        String res="";
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(i)){
                res+=a.charAt(i);
            }else{
                return res;
            }
            i++;
            j++;
        }
        return res;
    }
}