package linkedlist;

import java.util.Scanner;


public class reverseLLRecursive {
	static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data=data;
                    next=null;
        }
    }
    public static Node<Integer> takeInput(){
        Node<Integer> head=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("press -1 to end the list input");
        System.out.println("enter elements");
        int data=sc.nextInt();
        while(data!=-1){
            Node<Integer> newNode=new Node<Integer>(data);
            if(head==null)
            {
                head=newNode;
            }
            else {
                Node<Integer> temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
            data=sc.nextInt();
        }
        return head;
    }
   
    public static void printList(Node<Integer> head)
    {
        Node<Integer> temp=head;
        while(head!=null)
        {
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
}
    static Node<Integer> h;
    public static Node<Integer> helper(Node<Integer> curr, Node<Integer> prev)
    {
    	//handling the base case, when it reaches to the last element, make it as head and put previous element in its next, so it starts referring to it,
    	//for ex,, 1 2 3 4 5,
    	//when reaches to 5, 
    	if(curr.next==null)
    	{
    		h=curr; //makes it head
    		curr.next=prev; //put 4 in its next,, 5 4 3 2 1
    		return h;
    	}
    	Node<Integer> next1=curr.next;
    	//puts next element in next1
    	curr.next=prev;
    	//puts previous element in curr
    	/*
    	 * for ex.. 1 2 3 4 5
    	 * next1=2;
    	 * curr.next=prev => 1->null 
    	 * now,, curr=2, prev=1
    	 * next1=3
    	 * curr.next=prev
    	 * 2.next=1
    	 * 2->1
    	 */
    	helper(next1,curr);
    	return h;
    	
    }
public static void main(String[] args) {
	Node<Integer> head=takeInput();
	Node<Integer> head1=helper(head,null);
	//(curr,prev)
	printList(head1);
}
}
