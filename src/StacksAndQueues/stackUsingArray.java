import java.util.*;
public class stackUsingArray<T> {
	private T[] data;
	private int top; //index of topmost element in stack
	
	public stackUsingArray() {
		data=(T[])new Object[10];
		top=-1;
	}
	public stackUsingArray(int capacity)
	{
		data=(T[])new Object[capacity];
		top=-1;
	}
	public boolean isEmpty() {
		return (top==-1);
	}
	public int size() {
		return top+1;
	}
	public T top() throws StackEmptyException{
	
		if(size()==0) {
			StackEmptyException e=new StackEmptyException();
		throw e;
	}
	return  data[top];
	}
	public void push(T elem) 
	{
		if(size()==data.length)
		{
			dynamicStack();
		}
		top++;
		data[top]=elem;
	}
	public T pop() throws StackEmptyException
	{
		if(size()==0)
			throw new StackEmptyException();
		T temp=data[top];
		top--;
		return temp;
	}
	private void dynamicStack()
	{
		T[] temp=data;
		data=(T[]) new Object[2*temp.length];
		for(int i=0;i<=top;i++) {
			data[i]=temp[i];
	}
	}
}
