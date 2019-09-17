package linkedlist;

import java.util.Scanner;

public class doublyLinkedList {
	public static DoublyNode<Integer> takeInput(){
		System.out.println("enter head data or enter -1 to end the list");
		Scanner sc=new Scanner(System.in);
		int data= sc.nextInt();
		DoublyNode<Integer> head= null;
		while(data!= -1)
		{
			DoublyNode<Integer> newNode= new DoublyNode<Integer>(data);
			if(head == null)
			{
				head = newNode;
				head.next = null;
				head.prev = null;
			}
			else {
				DoublyNode<Integer> temp = head;
				while(temp.next!= null)
				{
					temp=temp.next;
				}
				temp.next = newNode;
				newNode.prev = temp;
			}
			data= sc.nextInt();
		}
		return head;
	}
	
	public static void printProper(DoublyNode<Integer> head)
	{
		DoublyNode<Integer> temp = head;
		while(temp!=null)
		{
			if(temp.next == null)
				System.out.println("null occured in next, The current node is "+ temp.data);
			else if(temp.prev == null)
				System.out.println("null occured in prev, The current node is "+ temp.data + " The next node is "+  temp.next.data);
			else	
			System.out.println("The prev node is " + temp.prev.data+" The current node is "+temp.data + " The next node is "+ temp.next.data);
			temp=temp.next;
		}
		
	}
	public static void printNormal(DoublyNode<Integer> head)
	{
		DoublyNode<Integer> temp = head;
		while(temp!=null)
		{
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	public static DoublyNode<Integer> getLastNode(DoublyNode<Integer> head)
	{
		DoublyNode<Integer> last = head;
		while(last.next!=null)
			last=last.next;
		
		return last;
	}
	public static void printReverse(DoublyNode<Integer> lastNode)
	{
		while(lastNode!=null) {
			System.out.println("The current node is "+ lastNode.data);
			lastNode= lastNode.prev;
		}
	}
	public static DoublyNode<Integer> deleteByValue(DoublyNode<Integer> head, int val)
	{
		DoublyNode<Integer> temp2= head;
		DoublyNode<Integer> pre = null;
		DoublyNode<Integer> nex = null;
		if(head.data == val)
		{
			head= head.next;
		}
		
		else 
		{
			
		while(temp2.data != val)
		{
			temp2= temp2.next;
			
			if(temp2 == null)
				return null;
			
			pre= temp2.prev;
			nex = temp2.next;
		}
	
		pre.next = nex;
		 
		
		}
		return head;
	}
	public static DoublyNode<Integer> deleteAtPos(DoublyNode<Integer> head, int i)
	{
		int index = 0;
		if(index == i)
		{
			head = head.next;
		}
		else {
			DoublyNode<Integer> temp= head;
			while(index < i-1)
			{
				temp = temp.next;
				index++;
			}
			temp.next =  temp.next.next;
			
		}
		return head;
	}
	public static DoublyNode<Integer> insertAtLastO1(DoublyNode<Integer> last, int k)
	{
			DoublyNode<Integer> newNode = new DoublyNode<Integer>(k);
			last.next = newNode;
			newNode.prev = last;
			last = last.next;
			return last;
	}
	public static DoublyNode<Integer> insertAtFirstO1(DoublyNode<Integer> head, int k)
	{
		DoublyNode<Integer> newHead = new DoublyNode<Integer>(k);
		newHead.next = head;
		head.prev = newHead;
		head = newHead;
		return head;
	}
	public static DoublyNode<Integer> deleteAtFirstO1(DoublyNode<Integer> head)
	{
		head = head.next;
		head.next.prev = null;
		return head;
	}
	public static DoublyNode<Integer> deleteAtLastO1(DoublyNode<Integer> last)
	{
		last = last.prev;
		last.next = null;
		return last;
	}
	public static void main(String[] args) {
		DoublyNode<Integer> head= takeInput();
		/*
		 * printNormal(head); DoublyNode<Integer> last = getLastNode(head);
		 * DoublyNode<Integer> delByValHead = deleteByValue(head, 1); if(delByValHead ==
		 * null) System.out.println("couldn't found the element"); else
		 * printNormal(delByValHead); printReverse(last);
		 
		DoublyNode<Integer> delByPosHead = deleteAtPos(head, 0);
		printNormal(delByPosHead);
		*/
		DoublyNode<Integer> last = getLastNode(head);
		System.out.println("inserted at last o1");
		DoublyNode<Integer> lastUpdated =  insertAtLastO1(last , 10);
		 printNormal(head);
		 System.out.println();
		// printReverse(lastUpdated);
		 System.out.println("inserted at first o1");
		DoublyNode<Integer> head1 = insertAtFirstO1(head, 15);
		 printNormal(head1);
		 System.out.println();
		 System.out.println("deleted at first o1");
		 DoublyNode<Integer> updatedHead = deleteAtFirstO1(head1);
		 printNormal(updatedHead);
		 System.out.println();
		 System.out.println("deleted at last o1");
		 DoublyNode<Integer> updatedTail = deleteAtLastO1(lastUpdated);
		 printNormal(updatedHead);
	}

}
