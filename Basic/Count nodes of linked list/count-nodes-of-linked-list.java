//{ Driver Code Starts
import java.util.*;
class Node{
    int data;
    Node next;
    
    Node(int a){
        data = a;
        next = null;
    }
    
}

// } Driver Code Ends
/*Complete the function below*/
/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/
// class Node{
//         int data;
//         int next;
        
//         Node(int data1, int next1){
//             this.data = data1;
//             this.next = next1;
            
//         }
//     }

class Solution
{
    //Function to count nodes of a linked list
    public static int getCount(Node head)
    {
        
        //Code here
        int cnt=0;
        Node temp=head;
        // Traverse the linked list and count nodes
        while(temp!=null){
            temp = temp.next;
            cnt++;// increment cnt for every node traversed
        }
        return cnt;
        
    }
}
    

//{ Driver Code Starts.
class LinkedList{
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            Solution ob = new Solution();
            System.out.println(ob.getCount(head));
        }
    }
   
    
    
    
}


// } Driver Code Ends