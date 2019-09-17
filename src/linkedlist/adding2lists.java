package linkedlist;

import java.util.Scanner;

public class adding2lists {
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
	    		  return head;
	    	  
	    	  Node<Integer> tail=head.next;
	    	  Node<Integer> smallAns=reverse(head.next);
	    	  tail.next=head;
	    	  head.next=null;
	    	  return smallAns;
	    }

	    public static Node<Integer> add(Node<Integer> head1, Node<Integer> head2)
	    {
	    	head1 = reverse(head1);
	    	head2 = reverse(head2);
	    	
	    	int sum;
	    	int carry = 0;
	    	Node<Integer> head3=null;
	    	while(head1!= null || head2!= null)
	    	{
	    		if(head1!=null && head2!=null)
	    		{
	    			sum = carry + head1.data + head2.data;
	    			carry = (sum>=10)?1:0;
	    			sum = sum%10;
	    			Node<Integer> sumNode = new Node<Integer>(sum);
	    			if(head3 == null)
	    			{
	    				head3 = sumNode;
	    			}
	    			else
	    			{
	    				sumNode.next = head3;
	    				head3 = sumNode;
	    			}
	    			head1 = head1.next;
	    			head2 = head2.next;
	    		}
	    		else if(head2 == null)
	    		{
	    			sum = carry + head1.data;
	    			carry = (sum>=10)?1:0;
	    			sum = sum%10;
	    			Node<Integer> sumNode = new Node<Integer>(sum);
	    			if(head3 == null)
	    			{
	    				head3 = sumNode;
	    			}
	    			else
	    			{
	    				sumNode.next = head3;
	    				head3 = sumNode;
	    			}
	    			head1= head1.next;
	    		}
	    		else if(head1 == null)
	    		{
	    			sum =carry+head2.data;
	    			carry = (sum>=10)?1:0;
	    			sum =sum%10;
	    			Node<Integer> sumNode = new Node<Integer>(sum);
	    			if(head3 == null)
	    			{
	    				head3 = sumNode;
	    			}
	    			else
	    			{
	    				sumNode.next = head3;
	    				head3 = sumNode;
	    			}
	    			head2 = head2.next;
	    		}
	    	}
	    	if(carry >= 1)
	    	{
	    		Node<Integer> carryNode = new Node<Integer>(carry);
	    		carryNode.next = head3;
	    		head3 = carryNode;
	    	}
	    
	    	return head3;
	    }
	    public static void main(String[] args) {
			System.out.println("ENter list 1");
			Node<Integer> head1= takeInput();
			System.out.println("Enter list 2");
			Node<Integer> head2 = takeInput();
			System.out.println("Adding 2 lists, answer is");
			Node<Integer> head = add(head1, head2);
			printList(head);
		}
}
