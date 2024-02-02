//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int atoi(String s) {
	
	if(s==null) return 0;
	
	s = s.trim();
	
	if(s.length()==0) return 0;
	
	int sign = +1;
	long res = 0;
	if(s.charAt(0)=='-') sign = -1;
	
	int MAX = Integer.MAX_VALUE, MIN = Integer.MIN_VALUE;
	
	//Initializing the starting point
	int i = (s.charAt(0)=='+' || s.charAt(0)=='-') ? 1 : 0;
	//If '+' present in the starting then start indexing from 0, BUT if '-' then start indexing from 1
	
	while(i<s.length()){
	    if(s.charAt(i)==' ' || !Character.isDigit(s.charAt(i))) return -1;
	    res = res * 10 + s.charAt(i) - '0';
	    
	    //Check the conditions
	    if(sign==-1 && -1*res < MIN) return MIN;
	    if(sign== 1 && res > MAX) return MAX;
	    
	    i++;
	}
	
	return (int)(sign*res);
	
    }
}
