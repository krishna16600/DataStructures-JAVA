package linkedlist;

import java.util.Scanner;



 class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next; 
	
	public LinkedListNode(T data)
	{
		this.data = data;
	}
}

class Pair<T,V>{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
    public Pair()
    {
        this.head = null;
        this.tail = null;
    }
}

public class Kreverse {
	 public static Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> reverse(LinkedListNode<Integer> head1)
	    {
	        if(head1==null || head1.next==null)
	        {
	            Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> pair = new Pair<>();
	            pair.head = head1;
	            pair.tail = head1;
	            return pair;
	        }
	        
	        LinkedListNode<Integer> tail1 = head1.next;
	        Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> smallAns = reverse(head1.next);
	        tail1.next = head1;
	        head1.next = null;
	        smallAns.tail = head1;
	        return smallAns;
	    }
	 public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> h, int k) {
	        if(h==null)
	            return null;
	        
	        int count = 1;
	        LinkedListNode<Integer> t1 = h;
	          LinkedListNode<Integer> t2 = h;
	        
	        while(count<k && t2.next!=null)
	        {
	            t2 = t2.next;
	            count++;
	        }
	       

	       
	        LinkedListNode<Integer> head2 = t2.next;
	        t2.next = null;
	      Pair<LinkedListNode<Integer>,LinkedListNode<Integer>> smallAns = reverse(t1);
	        t1 = smallAns.head;
	        t2 = smallAns.tail;
	        t2.next = kReverse(head2,k);
	        return t1;
	            
	    }
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
	public static void main(String[] args) {
		LinkedListNode<Integer> h = takeInput();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		print(kReverse(h, k));
	}
}
