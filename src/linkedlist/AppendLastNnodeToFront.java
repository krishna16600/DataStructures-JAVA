package linkedlist;

import java.util.Scanner;

public class AppendLastNnodeToFront {
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
    public static Node<Integer> getTail(Node<Integer> head){
        Node<Integer> tail=null;
        while(head!=null)
        {
            tail=head;
            head=head.next;
        }
        return tail;

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
    public static int getLength(Node<Integer> head)
    {
        int count=0;
          while(head.data!=-1)
            {
                count++;
                if(head.next==null)
                    break;
                head=head.next;
            }
    		return count;
        
    }
    public static Node<Integer> append(Node<Integer> root, int n) {
        int index=1;
        int len=getLength(root);
        Node<Integer> tail=getTail(root);
       Node<Integer> head=null;
        tail.next=root;
        while(index!=len-n){
            root=root.next;
            index++;
        }
       
        head=root.next;
        root.next=null;
        return head;
        
    }
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
    	Node<Integer> head=takeInput();
		System.out.println("how many elements from the last, you want to append in front");
		int num=sc.nextInt();
		System.out.println("normal list");
		printList(head);
		System.out.println("after updating list by moving "+num+" elements from back to front");
		Node<Integer> head1=append(head,num);
		printList(head1);
		
	}
}
