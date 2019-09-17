import java.util.*;
public class StackUse {
public static void main(String[] args) throws StackFullException, StackEmptyException {
	stackUsingArray<String> stack=new stackUsingArray<String>();
	System.out.println("enter  number of elements ");
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	System.out.println("enter stack elements");
	for(int i=0;i<n;i++)
	{
		String str=sc.next();
		stack.push(str);
	}
	
	while(!stack.isEmpty())
	{
		try {
			System.out.print(stack.pop()+" ");
		}
		catch(StackEmptyException e)
		{
			
		}
	}
}
}
