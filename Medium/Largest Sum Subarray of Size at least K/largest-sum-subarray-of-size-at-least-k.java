//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumWithK(a, n, k));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public long maxSumWithK(long a[], long n, long k) {
        
        // long ans = Long.MIN_VALUE;
        // long sum = 0;
        // long[] last = new long[];
        // long j = 0;
        
        // for(int i = 0; i<n; i++){
        //     sum += arr[i];
            
        //     if(i-j+1==k)
        //         ans = Math.max(ans, sum);
            
        //     else if(i-j+k > k){
        //         last += arr[j];
        //         j++;
                
        //         if(last < 0){
        //             sum -= last;
        //             last = 0;
        //         }
            
        //         ans = Math.max(ans, sum);
        //     }
        // }
        // return ans;
         long sum=0;
        for (int i=0;i<k;i++){
            sum+=a[i];
        }
        if (n==k){
            return sum;
        }
        long max=sum;
        long initial=0;
        for (int i=(int)k;i<n;i++){
            sum+=a[i];
            sum-=a[i-(int)k];
            initial+=a[i-(int)k];
            if (initial>=0){
                max=Math.max(sum+initial,max);
            }
            else{
                max=Math.max(max,sum);
                initial=0;
            }
        }
        return max;
    }
}

