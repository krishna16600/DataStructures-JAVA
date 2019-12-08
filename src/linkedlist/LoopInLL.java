package practice;

import java.util.Scanner;



public class LoopInLL {
	public static LinkedListNode<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);

		int data = sc.nextInt();
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;

		while (data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = sc.nextInt();
		}
		return head;
	}

	public static void print(LinkedListNode<Integer> head) {
		LinkedListNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static boolean findLoop(LinkedListNode<Integer> head)
	{
		if(head==null||head.next==null)
			return true;
		
		LinkedListNode<Integer> slow = head;
		LinkedListNode<Integer> fast = head;
		while(slow!=null && fast!=null && fast.next!=null)
		{
			
			slow=slow.next;
			fast = fast.next.next;
			if(slow==fast) {
				System.out.println("Loop detected");
				getHead(slow,fast,head);
						return true;
			}
		
		}
		return false;
		
	}
	public static void getHead(LinkedListNode<Integer> slow,LinkedListNode<Integer> fast, LinkedListNode<Integer> head)
	{
		//count number of nodes in a loop 
		int count = 1;
		slow = slow.next;
		//move slow by 1 and dont move fast ... when they will meet again we will get the count of nodes
		while(slow!=fast)
		{
			count+=1;
			slow = slow.next;
			
		}
		System.out.println("Count of nodes in loop " + count);
		//to find the head of the loop where actually loop starts
		
		//initialize a pointer to head... and one pointer head + count
		// move both by 1 and when they meet .. it will be  the head node of the loop
		LinkedListNode<Integer> p1 = head;
		LinkedListNode<Integer> p2 = head;
		
		for(int i=0;i<count;i++)
			p2 = p2.next;
		
		//now p1 = head.. p2 = head+count.. move by 1 till they meet again
		
		while(p1!=p2)
		{
			p1=p1.next;
			p2= p2.next;
		}
		System.out.println("Loop starts from "+ p1.data +" node");
		removeLoop(p1);
	}
	public static void removeLoop(LinkedListNode<Integer> p1)
	{
		System.out.println("Removing Loop");
		LinkedListNode<Integer> p2 = p1.next;
		while(p2.next!=p1)
			p2 = p2.next;
		
		p2.next = null;
		System.out.println("Loop removed");
	}
	public static void main(String[] args) {
		LinkedListNode<Integer> a = new LinkedListNode<Integer>(10);
		LinkedListNode<Integer> b = new LinkedListNode<Integer>(20);
		LinkedListNode<Integer> c = new LinkedListNode<Integer>(30);
		LinkedListNode<Integer> d = new LinkedListNode<Integer>(40);
		LinkedListNode<Integer> e = new LinkedListNode<Integer>(50);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = c;
		System.out.println(findLoop(a));
	print(a);
		
 	}

}
