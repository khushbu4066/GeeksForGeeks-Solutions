//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }
    
    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<String> a)
    {
        for(int i = 0; i < a.size()-1; i++)
            System.out.print(a.get(i)+" ");
        System.out.println(a.get(a.size()-1));
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s; 
            s = br.readLine();
            
            Solution obj = new Solution();
            ArrayList<String> res = obj.removeInvalidParentheses(s);
            
            StringArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<String> removeInvalidParentheses(String s) {
        HashSet<String> set = new HashSet<>() ;     // To Avoid duplicate
        Queue<String> queue = new LinkedList<>();
        boolean isValidFound = false ;
        queue.add(s);
        
        ArrayList<String> result = new ArrayList<>();
        
        while(!queue.isEmpty() && !isValidFound){
            
            int size = queue.size() ;
            
            for(int i=0 ; i<size ; i++){
                
                String cur = queue.poll() ;
                
                if(isValid(cur)){
                    isValidFound = true ;
                    result.add(cur);
                }else if(!isValidFound){
                    
                    for(int j=0 ; j<cur.length() ; j++){
                        
                        if(Character.isLetter(cur.charAt(j))) continue ;
                        
                        String new_str = cur.substring(0,j) + cur.substring(j+1);
                        
                        if(!set.contains(new_str)){
                            queue.add(new_str);
                            set.add(new_str);
                        }
                                              
                    }
                }
            }                        
        }
        Collections.sort(result);
        return result ;
    }
    
    static boolean isValid(String s)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch!='(' && ch!=')')
                continue;
            if(ch=='(')
                st.push(ch);
            else
            {
                if(!st.isEmpty() && st.peek()=='(')  
                    st.pop();
                else
                    return false;
            }
        }
        return st.isEmpty()?true:false;
    }
}
