package linkedlist;

import java.util.Scanner;



public class checkPalindrome {
	static Node<Integer> left;
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

    public static boolean check(Node<Integer> right,Node<Integer> head) {
    	left=head;
    	if(right==null)
    		return true;
    	
    	boolean smallAns=check(right.next,head);
    	if(smallAns==false)
    		return false;
    	
    	boolean ans=(left.data==right.data);
    	System.out.println(right.data +"  "+left.data);
  
    	left=left.next;

    	return ans;
    }

    public static void main(String[] args) {
		Node<Integer> head=takeInput();
		printList(head);
		System.out.println(check(head,head));
	}
}
