package linkedlist;

import java.util.Scanner;

public class takingInputLinkedList {
	public static Node<Integer> takeInput(){
		Node<Integer> head= null;
		Scanner sc=new Scanner(System.in);
		int data=sc.nextInt();
		
		while(data!=-1)
		{
			Node<Integer> newNode = new Node<Integer>(data);
			if(head == null) {
				head=newNode;
			}
			else
			{
				Node<Integer> temp= head;
				while(temp.next!=null) {
					temp=temp.next;
				}
				temp.next= newNode;
			}
			data=sc.nextInt();
		}
		return head;
	}

	public static void print(Node<Integer> head) {
		Node<Integer> temp=head;
		while(head !=null) {
			
		System.out.println(head.data+" ");
		head=head.next;
		
}
	}
	public static void main(String[] args) {
	Node<Integer>head= takeInput();
	System.out.println("count is " +findLengthOfLL.lengthFind(head));
	print(head);
	print_ith_node.printNode(head, 0);
	}	
	}
		
