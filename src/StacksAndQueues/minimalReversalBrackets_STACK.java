import java.util.*;
public class minimalReversalBrackets_STACK {
	static int findMinReversal(String input)
	{
		if(input.length()==0)
			return -1;
		
		if(input.length()%2!=0)
			return -1;
		
		Stack<Character> s=new Stack<>();	
		
		for(int i=0;i<input.length();i++)
		{
			char currentChar=input.charAt(i);
			
			if(currentChar!='}')
				s.push(currentChar);
			else
			{
				if(!s.isEmpty() && s.peek()=='{')
					s.pop();
				else
					s.push(currentChar);
			}
			
		}
			int count=0;
			while(!s.isEmpty())
			{
				char c1=s.pop();
				char c2=s.pop();
				if(c1==c2)
					count+=1;
				else
					count+=2;
			}
		return count;
	}
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String str=sc.next();
	int ans=findMinReversal(str);
	System.out.println(ans);
}
}
