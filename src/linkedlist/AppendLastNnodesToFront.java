package linkedlist;
import java.util.*;
public class AppendLastNnodesToFront {
static class Node<T>{
	T data;
	Node<T> next;
	Node(T data){
		this.data=data;
		this.next=null;
	}
}
	public static Node<Integer> takeInput(){
		Node<Integer> head=null;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter -1 to end linked list");
		int data=sc.nextInt();
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			if(head==null)
			{
				head=newNode;
			}
			else {
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
		System.out.println();
	}
	public static int getLength(Node<Integer> head)
	{
		int count=0;
		while(head!=null)
		{
			count++;
			head=head.next;
		}
		return count;
	}
	public static Node<Integer> getTail(Node<Integer> head)
	{
		Node<Integer> tail=null;
		while(head!=null)
		{
			tail=head;
			head=head.next;
		}
		return tail;
	}
	public static Node<Integer> appendLast(Node<Integer> head,int n)
	{
		int index=1;
		int len=getLength(head);
		Node<Integer> tail=getTail(head);
		Node<Integer> newHead=null;
		System.out.println(tail.data);
		tail.next=head;
		while(index!=len-n)
		{
			head=head.next;
			index++;
		}
		newHead=head.next;
		head.next=null;
		
		return newHead;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	Node<Integer> head=takeInput();
	print(head);
	System.out.println("how manyy last elemenst you want to append in front");
	int n=sc.nextInt();
	Node<Integer> head1=appendLast(head,n);
	print(head1);
	}
}
