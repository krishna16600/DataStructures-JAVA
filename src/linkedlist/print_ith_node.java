package linkedlist;

public class print_ith_node {
public static void printNode(Node<Integer> head,int i)
{
	int count=-1;
	int turn=0;
    while(head.data!=-1){
        count++;
        turn++;
        if(count==i) {
            System.out.println("node value at index " +i +" is "+ head.data);
         break;
        }
        if(head.next==null)
        	break;
        System.out.println("reached");
        head=head.next;
}
    System.out.println("turn : " +turn);
}
}
