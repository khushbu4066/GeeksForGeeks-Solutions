//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG()
{
        s = new Stack<>();
}
 
    /*returns min element from stack*/
    int getMin()
    {
    return s.isEmpty() ? -1 : minEle;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        int val;
    if(s.isEmpty()) {
        val = -1;
    } else {
        if(s.peek() < minEle) {
           val = minEle;
           minEle = minEle - s.peek();
           s.pop();
        } else {
            val = s.pop();
        }
    }
    return val;
    }
 
    /*push element x into the stack*/
    void push(int x)
    {
    if(s.isEmpty()) {
        minEle = x;
        s.push(x);
    } else {
        if(minEle > x) {
           int val = x - minEle;
           s.push(val);
           minEle = x;
        } else {
            s.push(x);
        }
    }
    }
}