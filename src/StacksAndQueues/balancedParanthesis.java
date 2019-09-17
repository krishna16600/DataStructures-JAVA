import java.util.Scanner;

public class balancedParanthesis {
	 static boolean checkPair(char character1, char character2) 
	    { 
	       if (character1 == '(' && character2 == ')') 
	         return true; 
	       else if (character1 == '{' && character2 == '}') 
	         return true; 
	       else if (character1 == '[' && character2 == ']') 
	         return true; 
	       else
	         return false; 
	    } 
	public static boolean checkBalanced(String string) throws StackEmptyException
	{
		 stackUsingArray<Character> stack=new stackUsingArray<>();
		 char[] str=string.toCharArray();
		for(int i=0;i<str.length;i++)
		{
			if(str[i]=='{' || str[i]=='[' || str[i]=='(' )
			stack.push(str[i]);
		if(str[i]=='}' || str[i]==']' || str[i]==')' )
		{
			if(stack.isEmpty())
				return false;
			
			else if(!checkPair(stack.pop(),str[i]))
				return false;
		}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
		
	}
public static void main(String[] args) throws StackEmptyException {
	
	System.out.println("enter paranthesis");
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	boolean ans=checkBalanced(str);
	System.out.println("given paranthesis is balanced? "+ ans);
	
}
}
