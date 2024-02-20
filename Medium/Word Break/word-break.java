//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> dictionary = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            dictionary.add(p);
                        }
                    String s = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(n, s, dictionary));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(int n, String s, ArrayList<String> dictionary )
    {
        //code here
        int arr[]=new int[s.length()];
        for(String str:dictionary){
             int idx = s.indexOf(str);
             while (idx != -1) {
                for(int i=idx;i<idx+str.length();i++){
                     arr[i]=1;
                }
                idx = s.indexOf(str, idx + 1);
             }
        }
        for(int i=0;i<s.length();i++){
            if(arr[i]==0){
                return 0;
            }
        }
        return 1;
       
    }
}