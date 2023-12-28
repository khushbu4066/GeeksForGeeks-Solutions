//{ Driver Code Starts
import java.util.*;
 
class RLEncoding
{
   public static void main(String[] args) 
   {
 
      Scanner sc = new Scanner(System.in);
    
	  int T = sc.nextInt();
	  sc.nextLine();
	  while(T>0)
	  {
		  
		String str = sc.nextLine();
		
		GfG g = new GfG();
		System.out.println(g.encode(str));
		
      
        T--;
	  }
   }
}


// } Driver Code Ends


class GfG
 {
	String encode(String str)
	{
          //Your code here
          int n = str.length();
        StringBuilder compressed = new StringBuilder();
        int i = 0;

        while (i < n) {
            char cur = str.charAt(i);
            int count = 0;

            while (i < n && cur == str.charAt(i)) {
                i++;
                count++;
            }

            compressed.append(cur);

            // if (count > 1) {
                compressed.append(count);
            
        }

        return compressed.toString();
	}
	
 }