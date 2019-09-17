import java.util.*;
public class infixToPrefix {
	public static String findPostfix(String str)
	{
		Stack<Character> stack = new Stack<Character>();
		String postfix="";
		for(int i=0;i<str.length();i++)
		{
			char c = str.charAt(i);
			
			if(Character.isLetterOrDigit(c))
				postfix+=c;
			
			else if(c=='(')		
				stack.push(c);
			
			else if(c==')')
			{
				while(!stack.isEmpty() && stack.peek()!='(')
					postfix+=stack.pop();
				
				if(stack.isEmpty())
				return "not valid";
				else
				stack.pop();
			}
			else {
				while(!stack.isEmpty() && getPriority(c)<= getPriority(stack.peek()))
					postfix+=stack.pop();
				
				stack.push(c);
			}
		
		}
		while(!stack.isEmpty())
		{
			if(stack.peek() == '(') 
                return "Invalid Expression"; 
            postfix += stack.pop(); 
         } 	
		return postfix; 
		}
	 
	private static int getPriority(char c) {
		// TODO Auto-generated method stub
		if(c == '-' || c== '+')
			return 1;
		else if(c=='*' || c=='/')
			return 2;
		else if(c=='^')
			return 3;
		return 0;
	}

	public static void main(String[] args) {
		System.out.println("enter string in infix");
		Scanner sc=new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("PreFix : "+ findPostfix(str));
	}
}
