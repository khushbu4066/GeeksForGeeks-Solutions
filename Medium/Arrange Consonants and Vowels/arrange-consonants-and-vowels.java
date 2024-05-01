//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        
        if(head == null || head.next == null){
            return head;
        } 
        
        
        // Intializing dummy pointers
        Node vowelHead = new Node('0');
        Node vowelTail = vowelHead;
        Node consoHead = new Node('0');
        Node consoTail = consoHead;
        
        
        //Iterate through Linked List
        Node curr = head;
        while(curr != null){
            if(isVowel(curr.data)){
                vowelTail.next = curr;
                vowelTail = curr;
            }
            else{
                consoTail.next = curr;
                consoTail = curr;
            }
            
            curr = curr.next;
        }
        
        vowelTail.next = consoHead.next;
        consoTail.next = null;
        
        return vowelHead.next;
    }
    
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
             ||ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}