package linkedlist;

import java.util.Scanner;

public class insertNodeat_ithPos {

	public static Node<Integer> takeInput(){
		Node<Integer> head= null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter node value");
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
			System.out.println("enter node value");
			data=sc.nextInt();
		}
		return head;
	}
public static Node<Integer> insert(Node<Integer> head,int data,int pos ) {
	Node<Integer> newNode = new Node<Integer>(data);
	if(pos==0)
	{
		newNode.next=head;
		return newNode;
	}
	
	int i=0;
	Node<Integer> temp=head;
	while(i<pos-1) {
		temp=temp.next;
		i++;
	}
	Node<Integer> t;
	t=temp.next;
	temp.next=newNode;
	newNode.next=t;
	System.out.println("inserted");
	
	return head;
}
public static void print(Node<Integer> head) {
	Node<Integer> temp=head;
	while(head !=null) {
		
	System.out.println(head.data+" ");
	head=head.next;
	
	}
}
	public static void main(String args[]) {
		Node<Integer> head=takeInput();
		print(head);
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value and index at which you want to insert");
		int d=sc.nextInt();
		int pos=sc.nextInt();
		head=insert(head,d,pos);
		print(head);
	}
}