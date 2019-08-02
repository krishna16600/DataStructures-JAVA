package linkedlist;

import java.util.Scanner;

public class deleteA_node {
	public static Node<Integer> takeInput() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter a node value");
		Node<Integer> head=null;
		int data= sc.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null)
			{
				head=newNode;
			}
			else
			{
				Node<Integer> temp=head;
				while(temp.next!=null)
				{
					temp=temp.next;
				}
				temp.next=newNode;
			}
			data=sc.nextInt();
			
		}
		return head;
	}
	public static void print(Node<Integer> head)
	{
		
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
	public static Node<Integer> delete(Node<Integer> head,int index)
	{
			int i=0;
			if(index==0)
			{
				head=head.next;
				return head;
			}
			Node<Integer> temp=head;
			while(i<index-1)
			{
				temp=temp.next;
				i++;
			}
			if(temp.next==null)
				return head;
			
			temp.next=temp.next.next;
			return head;
	}
public static void main(String[] args) {
	Node<Integer> head=takeInput();
	Scanner sc=new Scanner(System.in);
	System.out.println("enter the index of the element you want to delete");
	int i=sc.nextInt();
	Node<Integer> head1=delete(head,i);
	print(head1);
}
}
