import java.util.*;
public class evalPostFix {
	public static int evalPost(String str)
	{
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<str.length();i++)
		{
			Character c = str.charAt(i);
			 
			if(c== ' ')
				continue;
			
			else if(Character.isDigit(c))
			{
				int num = 0;;
				
				while(Character.isDigit(c))
				{
					num = num*10 + (int)c - '0';
					i++;
					c= str.charAt(i);
				}
					i--;
					stack.push(num);
			}
			else
			{
				int num1 = stack.pop();
				int num2 = stack.pop();
				
				switch(c)
				{
				case '+' :
					stack.push(num2+ num1);
					break;
				case '-':
					stack.push(num2 - num1);
					break;
				case '*':
					stack.push(num2 * num1);
					break;
				case '/':
					stack.push(num2 / num1);
					break;
				}
			}
			
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		System.out.println("enter postfix string");
		Scanner sc= new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(evalPost(str));
	}
}
