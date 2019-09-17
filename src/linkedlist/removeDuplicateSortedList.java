package linkedlist;

import java.util.HashSet;
import java.util.Scanner;

public class removeDuplicateSortedList {
	public static Node<Integer> takeInput(){
        Node<Integer> head=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("press -1 to end the list input");
        System.out.println("enter elements");
        int data=sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode=new Node<Integer>(data);
            if(head==null)
            {
                head=newNode;
            }
            else {
                Node<Integer> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            data=sc.nextInt();
        }
        return head;
    }
   
    public static void printList(Node<Integer> head)
    {
        Node<Integer> temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
}
    public static void remove(Node<Integer> head)
    {
    	Node<Integer> temp = head.next;
    	while(head!=null)
    	{
    		while(temp!=null && head.data == temp.data )
    		{
    			temp = temp.next;
    		}
    		head.next= temp;
    		head = head.next;
    			
    	}
    }
    public static void 
    removeUnsroted(Node<Integer> head)
    {
    	HashSet<Integer> hs = new HashSet<Integer>();
    	
    	Node<Integer> current = head;
    	Node<Integer> prev = null;
    	while(current!=null)
    	{
    		int currval = current.data;
    		if(hs.contains(currval))
    			prev.next=current.next;
    		else
    		{
    			hs.add(currvabgvl);
    			prev = current;
    		}
    		current = current.next;
    	}
    }
    public static void main(String[] args) {
		Node<Integer> head = takeInput();
		removeUnsroted(head);
		printList(head);
	}
    
}
