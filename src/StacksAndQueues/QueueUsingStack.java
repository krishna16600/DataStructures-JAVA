import java.util.Stack;

public class QueueUsingStack {
	static class Queue{
		Stack<Integer> stack = new Stack<Integer>();
	}
	
	public static void push(Stack<Integer> stack, int data)
	{
		stack.push(data);
	}
	public static int pop(Stack<Integer> stack)
	{
		if(stack==null)
			return -1;
		
		return stack.pop();
	}
	public static void enqueue(Queue q , int data)
	{
		push(q.stack,data);
	}
	public static int dequeue(Queue q)
	{
		int x , temp = 0;
		if(q.stack.isEmpty())
		{
			System.out.println("Cant dequeue");
			System.exit(0);
		}
		else if(q.stack.size()==1)
			return pop(q.stack);
		else
		{
			x = pop(q.stack);
			
			temp = dequeue(q);
			
			push(q.stack,x);
			return temp;
		}
		return 0;
	}
	public static void main(String[] args) {
		Queue q = new Queue();
		q.stack = new Stack<Integer>();
		
		enqueue(q,1);
		enqueue(q,2);
		enqueue(q,3);
		
		System.out.println(dequeue(q));
		System.out.println(dequeue(q));
		System.out.println(dequeue(q));
		
		
	}
}
