package linkedlist;

import java.util.Scanner;
public class findMidPointOfLL {
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
    public static int findMidPoint(Node<Integer> head)
    {
    	Node<Integer> slow=head;
    	Node<Integer> fast=head;
    	while(fast.next!=null && fast.next.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	int d=slow.data;
    	return d;
    	
    	
    }
    public static void main(String[] args) {
		Node<Integer> head=takeInput();
		int ans=findMidPoint(head);		
	System.out.println(ans);
    }
}
