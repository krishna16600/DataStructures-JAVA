package linkedlist;

import java.util.Scanner;

public class deleteAnodeRecursively {
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
	public static  int getL(Node<Integer> head)
    {
       int count=0;
	
	while(head.data!=-1)
	{
	//	System.out.println(head.data+" "+head.next);
		count++;
		if(head.next==null)
			break;
		head=head.next;
	}
	
	return count;
    }
	public static Node<Integer> delete(Node<Integer> head, int index,int len)
	{
		if(index>=len)
			return head;
		
		if(index==0)
		{
		Node<Integer> newHead=head;
			newHead=newHead.next;
			return newHead;
		}
		head.next=delete(head.next,index-1,len);
		return head;
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the index value at which you want to remove data");
		int ele=sc.nextInt();
		int len=getL(head);
		Node<Integer> head1=delete(head,ele,len);
		print(head1);
	}
}
