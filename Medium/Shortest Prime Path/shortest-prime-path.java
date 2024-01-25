//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    public static boolean isPrime(int n){
        if(n==1) return false;
        if(n==2||n==3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6){
            if((n%i==0)||(n%(i+2)==0)) return false;
        }
        return true;
        
    }
    int solve(int num1,int num2){
        //code here
       int prime[]=new int[10000];
        for(int i=1;i<10000;i++){
            if(isPrime(i)){
                prime[i]=1;
            }
        }
        int res[]=new int[10000];
        Arrays.fill(res,-1);
        res[num1]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(num1);
        while(!q.isEmpty()){
            int num=q.poll();
            for(int i=0;i<4;i++){
                for(int j=0;j<10;j++){
                    if(i==0 && j==0) continue;
                    String str=String.valueOf(num);
                    String nstr=str.substring(0,i)+String.valueOf(j)+str.substring(i+1);
                    int ns=Integer.valueOf(nstr);
                    
                    if(prime[ns]==1 && res[ns]==-1){
                        //System.out.print(ns+" ");
                        res[ns]=1+res[num];
                        q.add(ns);
                    }
                }
            }
        }
        return res[num2];
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends