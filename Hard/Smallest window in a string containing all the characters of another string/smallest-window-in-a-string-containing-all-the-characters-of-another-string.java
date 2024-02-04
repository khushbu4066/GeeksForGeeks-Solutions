//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
          HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int count = p.length(); // Initialize count to the length of the pattern
        int size = s.length();
        String ans = "";
        int min = Integer.MAX_VALUE;

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        while (j < size) {
            char ch1 = s.charAt(j);

            if (map.containsKey(ch1)) {
                if (map.get(ch1) > 0) {
                    count--;
                }
                map.put(ch1, map.get(ch1) - 1);
            }

            while (count == 0) {
                if (min > j - i + 1) {
                    ans = s.substring(i, j + 1);
                    min = j - i + 1;
                }

                char ch2 = s.charAt(i);
                if (map.containsKey(ch2)) {
                    map.put(ch2, map.get(ch2) + 1);
                    if (map.get(ch2) > 0) {
                        count++;
                    }
                }
                i++;
            }

            j++;
        }

        if(min == Integer.MAX_VALUE){
            return "-1";
        }else{
            return ans;
        }
    }
}