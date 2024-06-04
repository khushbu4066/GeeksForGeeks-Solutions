//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


class Solution {
    String binaryNextNumber(String s) {
        // code here.
        int n = s.length();
        boolean flag = false;
        char arr[] = s.toCharArray();
        for(int i = arr.length-1 ; i >= 0 ; i--){
            if(arr[i] == '0'){
                arr[i] = '1';
                flag = true;
                break;
            }else{
                arr[i] = '0';
            }
        }
        StringBuilder ans = new StringBuilder("");
        if(flag){
            for(char ch : arr)ans.append(ch);
        }else{
            ans.append(1);
            for(int i = 2 ; i <= n+1 ; i++){
                ans.append(0);
            }
        }
        int i = 0;
        while(ans.charAt(i) == '0')i++;
        return ans.substring(i);
    }
}
 