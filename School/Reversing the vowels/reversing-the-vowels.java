//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
           
            Solution ob = new Solution();
            
            System.out.println(ob.modify(s));    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String modify (String s)
    {
        // your code here
        char[] arr = s.toCharArray();
        
        int low = 0;
        int high = s.length()-1;
        
        while(low <= high){
            if(isVowel(arr[low]) && isVowel(arr[high])){
                char temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
            
            else if(!isVowel(arr[low])){
                low++;
            }
            else{
                high--;
            }
        }
        return String.valueOf(arr);
    }
    
    public boolean isVowel(char c){
        if(c == 'a' || c=='i' || c=='o' || c=='e' || c=='u'){
            return true;
        }
        else{
           return false; 
        }
    }
}