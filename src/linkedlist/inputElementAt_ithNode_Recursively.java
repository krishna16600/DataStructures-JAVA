package linkedlist;

import java.util.Scanner;

public class inputElementAt_ithNode_Recursively {
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
	public static Node<Integer> insert(Node<Integer> head, int pos,int elem)
	{
		if(pos==0)
		{
			Node<Integer> newNode=new Node<Integer>(elem);
			newNode.next=head;
			return newNode;
		}
		head.next=insert(head.next,pos-1,elem);

		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter element which you want to insert");
		int n=sc.nextInt();
		System.out.println("enter index where you want to insert");
		int in=sc.nextInt();
	Node<Integer> head1=insert(head,in,n);
	print(head1);
	}
}
