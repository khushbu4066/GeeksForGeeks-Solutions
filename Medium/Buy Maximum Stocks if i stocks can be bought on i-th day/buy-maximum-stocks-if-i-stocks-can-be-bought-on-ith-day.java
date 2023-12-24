//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        List<Pairs> p=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            p.add(new Pairs(price[i],i+1));
        }
        
        // p.sort(Comparator.comparingInt(m -> m.prices));
        
        p.sort(Comparator.comparingInt(m->m.prices));
        
        
        
        int cnt=0;
        
        for(int i=0;i<n;i++){
            int stockprice=p.get(i).prices;
            int stocks=p.get(i).ind;
            
            if(stockprice*stocks<=k){
                k-=stockprice*stocks;
                cnt+=stocks;
            }
            else{
                cnt+=k/stockprice;
                k-=stockprice*(k/stockprice);
            }
        }
        return cnt;
    }
    
    static class Pairs{
        int prices;
        int ind;
        Pairs(int p,int i){
            prices=p;
            ind=i;
        }
    }
}
        
