import java.util.*;
public class stackUskingLL<T> {
	Node<T> head;
	int size;
	public stackUskingLL()
	{
		head=null;
		size=0;
	}
	
	public void push(T data)
	{
		Node<T> newNode= new Node<T>(data);
		if(head==null)
		{
			head=newNode;
			head.next=null;
			size++;
		}
		else {
			newNode.next = head;
			head = newNode;
			size++;
		}
	}
	public T pop() throws StackEmptyException {
		if(head==null) {
		throw new StackEmptyException();
		}
			Node<T> temp = head;
			head= head.next;
			temp.next = null;
			size--;
		
		return temp.data;
	}
	public T top() throws StackEmptyException {
		if(head==null)
			throw new StackEmptyException();
		return head.data;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		stackUskingLL<Integer> st = new stackUskingLL<Integer>();
		
		System.out.println("1. press 1 to push");
		System.out.println("2. press 2 to pop");
		System.out.println("3. press 3 to see the top element");
		System.out.println("4. press 4 to get size");
		System.out.println("5. press 5 to check if stack is empty");
		System.out.println("6. press -1 to exit");
		int choice = s.nextInt();
		int input;
		
		while (choice !=-1) {
			
			if(choice == 1) {
				System.out.println("enter data to push");
				input = s.nextInt();
				st.push(input);
			}
			else if(choice == 2) {
				try {
					System.out.println("element popped "+st.pop());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 3) {
				try {
					System.out.println("Top element is "+st.top());
				} catch (StackEmptyException e) {
					System.out.println(-1);
				}
			}
			else if(choice == 4) {
				System.out.println("size: "+st.size());
			}
			else if(choice == 5) {
				System.out.println("stack empty "+st.isEmpty());
			}
			System.out.println("enter choice");
			choice = s.nextInt();
		}
	}
}
