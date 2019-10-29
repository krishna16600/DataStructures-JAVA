
public class Queue {
	private int data[];
	private int front;
	private int rear;
	private int size;

	Queue() {
		data = new int[10];
		front = rear = -1;
		size = 0;

	}

	Queue(int c) {
		data = new int[c];
		front = rear = -1;
		size = 0;
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}
	void enqueue(int el)
	{
		if(size==data.length)
		{
			System.out.println("Queue is full");
			return;
		}
		if(size==0)
			front=0;
		
		size++;
		rear++;
		data[rear] = el;
	}
	int dequeue() {
		if(size==0)
		{
			System.out.println("Queue is empty ");
		}
		int temp = data[front];
		front++;
		size--;
		return temp;
	}
	int getFront() {
		if(size==0)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		return data[front];
	}
	public static void main(String[] args) {
		Queue q =new Queue();
		for(int i=0;i<10;i++)
		{
			q.enqueue(i+1);
		}
		System.out.println(q.getFront());
		System.out.println("size: "+q.size());
		for(int i=0;i<10
				;i++)
		{
			System.out.println(q.dequeue());
		}
		System.out.println(q.getFront());	
		System.out.println(q.size());
		System.out.println(q.isEmpty());

	}
}
