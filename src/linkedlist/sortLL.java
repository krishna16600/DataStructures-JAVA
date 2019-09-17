package linkedlist;

import java.util.Scanner;


public class sortLL {
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
	        while(head!=null)
	        {
	            System.out.print(head.data+" ");
	            head=head.next;
	        }
	        System.out.println();
	}
	    public static Node<Integer> sort(Node<Integer> head)
	    {
	    	Node<Integer> temp1 = head;
	    	while(temp1!= null)
	    	{
	    		Node<Integer> temp2 = temp1.next;
	    		while(temp2!= null)
	    		{
	    			if(temp1.data > temp2.data)
	    			{
	    				int t = temp1.data;
	    				temp1.data = temp2.data;
	    				temp2.data = t;
	    			}
	    			temp2 = temp2.next;
	    		}
	    		temp1 = temp1.next;
	    	}
	    	return head;
	    }
	    public static void main(String[] args) {
			Node<Integer> head = takeInput();
			printList(head);
			System.out.println("after sorting");
			printList(sort(head));
		}
}
