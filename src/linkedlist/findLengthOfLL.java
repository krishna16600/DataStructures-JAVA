package linkedlist;

public class findLengthOfLL {
public static int lengthFind(Node<Integer> head) {
	int count=0;
	
	while(head.data!=-1)
	{
	//	System.out.println(head.data+" "+head.next);
		count++;
		if(head.next==null)
			break;
		head=head.next;
	}
	
	return count;
	
}
}
