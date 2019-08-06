package linkedlist;

import java.util.Scanner;

import linkedlist.reverseLLRecursive.Node;

public class reverseLLRecursiveWay2 {
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
    public static Node<Integer> reverse(Node<Integer> head)
    {
    	if(head==null || head.next==null)
    	{
    		return head;
    	}
    	Node<Integer> finalHead=reverse(head.next);
    	Node<Integer> temp=finalHead;
    	while(temp.next!=null)
    	{
    		temp=temp.next;
    	}
    	temp.next=head;
    	head.next=null;
    	return finalHead;
    }
public static void main(String[] args) {
	Node<Integer> head=takeInput();
	Node<Integer> updatedHead=reverse(head);	
	printList(updatedHead);
}
}