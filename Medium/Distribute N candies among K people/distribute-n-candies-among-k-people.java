//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int K = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            Long[] res = ob.distributeCandies(N,K);
            
            for(int i=0; i<K; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {

    static Long[] distributeCandies(int n, int k) {

        // code here

        Long arr[] =new Long[k];

         Arrays.fill(arr,0l);

        int peop = k;

         k=0;

        

        for(int i=1;i<=peop;){

            if(i+k <= n){

                arr[i-1] += i+k;

                n = n - (i+k);

            }

            else{

                arr[i-1] += n;

                break;

            }

            if(i == peop)

            {

                k = k+peop;

                i=1;

                continue;

            }

            i++;

        }

        return arr;

        

    }

};