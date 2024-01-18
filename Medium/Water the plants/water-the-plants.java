//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int arr[], int n)
    {
        // code here
         int[]arr2=new int[n];

        for(int j=0;j<n;j++)

        {

            if(arr[j]==-1)continue;

            int st=Math.max(0,j-arr[j]),end=Math.min(n-1,j+arr[j]);

            arr2[st]=Math.max(arr2[st],end);

        }

        for(int j=1;j<n;j++)arr2[j]=Math.max(arr2[j],arr2[j-1]);

        int cnt=0,in=0;

        while(in<n)

        {

            cnt++;

            if(in>arr2[in])return -1;

            in=arr2[in]+1;

        }

        return cnt;
        
    }
}
