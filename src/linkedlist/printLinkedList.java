package linkedlist;

public class printLinkedList {
public static void print(Node<Integer> head) {
	Node<Integer> temp=head;
	while(head !=null) {
		
	System.out.println(head.data+" ");
	head=head.next;
	
	}
	//yaha pe head = null ho jayega or agr head ko aage use krenge to null h head to
	//while loop ni chlegi,isliye temp mein store kr diya taki baar baar use kr ske
	System.out.println();
	/*
	 * while(head !=null) {
		
	System.out.println(head.data+" ");
	head=head.next;
	
	} 
	 */
}
	
public static void main(String[] args) {
	Node<Integer> node1=new Node<Integer>(50);
	Node<Integer> node2= new Node<Integer>(60);
	Node<Integer> node3=new Node<Integer>(70);
	node1.next=node2;
	node2.next=node3;
	Node<Integer> head=node1;
	//head is reference to first node/head has add of node1
	print(head);
	print(head);
	
}
}
