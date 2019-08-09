package linkedlist;

import java.util.Scanner;

public class MergeSort_LL {
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
    public static Node<Integer> getMiddle(Node<Integer> head){
    	Node<Integer> slow=head;
    	Node<Integer> fast=head;
    	while(fast.next!=null && fast.next.next!=null)
    	{
    		slow=slow.next;
    		fast=fast.next.next;
    	}
    	return slow;
    } 
    public static Node<Integer> sortedList(Node<Integer> left, Node<Integer> right)
    {
    	Node<Integer> result=null;
    	
    	if(left==null)
    	{
    		result=right;
    		return result;
    	}
    	if(right==null)
    	{
    		result=left;
    		return result;
    	}
    	if(left.data<=right.data)
    	{
    		result=left;
    		result.next=sortedList(left.next,right);
    	}
    	else
    	{
    		result=right;
    		result.next=sortedList(left, right.next);
    	}
    return result;
    }
    public static Node<Integer> mergeSort(Node<Integer> head)
    {
    	if(head==null || head.next==null)
    		return head;
    	
    	Node<Integer> middle=getMiddle(head);
    	Node<Integer> nextOfMiddle=middle.next;
    	middle.next=null;
    	
    	Node<Integer> left=mergeSort(head);
    	Node<Integer> right= mergeSort(nextOfMiddle);
    	
    	Node<Integer> sortList=sortedList(left,right);
    	return sortList;
    }
    public static void main(String[] args) {
		Node<Integer> head=takeInput();
		Node<Integer> head1=mergeSort(head);
		printList(head1);
	}
}
