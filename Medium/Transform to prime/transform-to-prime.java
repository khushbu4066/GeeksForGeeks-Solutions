//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minNumber(int arr[], int n){
    
        int sum = 0;
        for(int i = 0; i<n; i++) sum+=arr[i];
            if(sum==1) return 1;
            
            int i =0;
    
            while(true){
                if(check(sum)){
                    break;
                }
                i++;
                sum++;
            }
            return i;
        }
        boolean check(int x){
            for(int i = 2; i<=x/2; i++){
                if(x%i==0) return false;
            }
            return true;
        }
    
}
