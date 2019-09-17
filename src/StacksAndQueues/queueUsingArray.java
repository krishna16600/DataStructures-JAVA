import java.util.*;
public class queueUsingArray {
//circular Queue
private	int data[];
private	int front;// index at which front element is stored
private	int rear;//index at which rear element is stored
private int size;
	public queueUsingArray() {
		// TODO Auto-generated constructor stub
	data=new int[10];
	front=-1;
	rear=-1;
	size=0;
	}
	
	
public	queueUsingArray(int capacity)
	{
		data=new int[capacity];
		front=rear=-1;
		size=0;
	}
	
	
	int size() {
		return size;
	}
	
	boolean isEmpty() {
		return size==0;
	}
	
	int front() throws QueueEmptyException
	{
		if(size()==0)
			throw new QueueEmptyException();
		
		return data[front];
	}
	
	void enqueue(int element) throws QueueFullException {
		if(size==data.length)
			doubleCapacity();
		
		if(size()==0)
			front=0;
		
		
		size++;
		rear=(rear+1)%data.length; //if data length=3,and rear is at index 2 , rear=(2+1)%3,rear=0;
	/*	rear++;
		if(size==data.length)
			rear=0; //if there is empty space after deleting an element and we need to put the element,we will store it in the front		
		*/
		data[rear]=element;
		
		
	}
	
	int dequeue() throws QueueEmptyException {
		if(size==0)
			throw new QueueEmptyException();
		
		int temp=data[front];
		front++;
		if(front==data.length)
			front=0;
		//or front=(front+1)%data.length
		size--;
		
		if(size==0)
			front=rear=-1;
		
		return temp;
	}
	
	private void doubleCapacity() {
		int[] temp=data;
		data=new int[2*temp.length];
		int index=0;
		for(int i=front;i<=temp.length;i++) {
			data[i]=temp[i];
		index++;
		}
		for(int i=0;i<=front-1;i++)
		{
			data[index]=temp[i];
		}
	front=0;
	rear=temp.length-1;
	}
	

	
	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		Scanner sc=new Scanner(System.in);
		queueUsingArray q=new queueUsingArray();
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(3);
		while(!q.isEmpty())
			System.out.println(q.dequeue());
	}
}
