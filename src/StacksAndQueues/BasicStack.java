import java.util.*;
public class BasicStack {
public static void main(String[] args) {
	Stack<Integer> stack=new Stack<Integer>();
	stack.add(1);
	stack.add(2);
	stack.add(3);
	stack.add(4);
	stack.add(5);
	
	while(!stack.isEmpty())
		System.out.println(stack.pop());
}
}
