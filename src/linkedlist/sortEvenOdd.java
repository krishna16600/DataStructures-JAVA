package linkedlist;

import java.util.Scanner;

public class sortEvenOdd {
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
	public static Node<Integer> sortEvenOdd1(Node<Integer> head) {
        Node<Integer> oddH=null;
        Node<Integer> oddT=null;
       Node<Integer> evenH=null;
        Node<Integer> evenT=null;
      
        while(head!=null)
        {
            
            if(head.data%2!=0)
            {
                if(oddH==null)
                {
                    oddH=head;
                    oddT=head;
                }
                else
                {
                    oddT.next=head;
                    oddT=head;
                }
            }
            else if(head.data%2==0)
            {
                if(evenH==null)
                {
                    evenH=head;
                    evenT=head;
                }
                else
                {
                    evenT.next=head;
                    evenT=head;
                }
            }
            head=head.next;
        }
        //in case of odd LL, evenH will remain null, so adding null to the odd tail and returning oddH
        if(evenH==null)
        {
            oddT.next=null;
            return oddH;
        }
        //in case of even Ll, oddH will remain null, so adding null to the even tail and returning evenH
        if(oddH==null)
        {
            evenT.next=null;
            return evenH;
        }
        
         oddT.next=evenH;
        evenT.next=null;
        return oddH;

	
	}
	public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Node<Integer> head1=sortEvenOdd1(head);
		print(head1);
	}
}
