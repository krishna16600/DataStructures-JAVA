 package linkedlist;

import java.util.Scanner;



public class addOneToTheLL {
	static Node<Integer> tail=null;
	public static Node<Integer> takeInput(){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter data or press -1 to end list");
		int data=sc.nextInt();
		Node<Integer> head=null;
		
		while(data!=-1)
		{
			Node<Integer> newNode=new Node<Integer>(data);
			Node<Integer> temp=head;
			if(head==null)
			{
				head=newNode;
				tail=head;
			}
			else {
			
			while(temp.next!=null) {
				temp=temp.next;
			}
				temp.next=newNode;
			tail=temp.next;
		}
			data=sc.nextInt();
		}
		return head;
	}
	public static void print(Node<Integer> head)
	{
		Node<Integer> temp= head;
		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	public static Node<Integer> reverse(Node<Integer> head)
	{
		Node<Integer> Next=null;
		Node<Integer> current=head;
		Node<Integer> prev=null;
		
		while(current!=null)
		{
			Next=current.next;
			current.next=prev;
			prev=current;
			current=Next;
		}
		head=prev;
		return head;
				
	}
	public static Node<Integer> addUntilOne(Node<Integer> head)
	{
		Node<Integer> res=head;
		Node<Integer> temp=null;
		int carry=1;
		int sum;
		
		while(head!=null)
		{
			sum=carry+head.data;
			 carry= (sum>=10)?1:0;
			 sum=sum%10;
			 head.data=sum;
			 temp=head;
			 head=head.next;
		}
		if(carry>0)
			temp.next=new Node<Integer>(carry);
		
		return res;
	}
	public static Node<Integer> addOne(Node<Integer> head)
	{
		head=reverse(head);
		head=addUntilOne(head);
		Node<Integer> h=reverse(head);
		return h;
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		print(head);
	System.out.println();
	System.out.println("after adding one");
	Node<Integer> addedHead=addOne(head);
	print(addedHead);
	}
}
