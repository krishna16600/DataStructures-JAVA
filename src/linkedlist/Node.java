package linkedlist;

public class Node<T> {
	//structure of a node
				T data;
				Node<T> next;
				Node(T data)
				{
					this.data=data;
					next=null;
				}
}
/*class LinkedListUse{
	public static void main(String[] args) {
		Node<Integer> node1=new Node<Integer>(10);
		System.out.println(node1.data);
		System.out.println(node1.next);
		Node<Integer> node2=new Node<Integer>(20);
		//now we want to link these two nodes
		node1.next= node2;
		//node1 has memory space available for next node, we are
		//placing reference/address of node2 in the memory add of node1
		System.out.println(node2);
		System.out.println(node1.next);
		/*
		 * output
		 * linkedlist.Node@15db9742
linkedlist.Node@15db9742
same address of node 1 next as of node2 address
		 
	}
}*/