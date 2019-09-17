import java.util.*;
public class checkReduntantBrackets {

	static boolean check(String str)
	{
		char[] ch=str.toCharArray();
		int count=0;
		Stack<Character> s=new Stack<Character>();
		for(int i=0;i<ch.length;i++)
		{
			if(ch[i]!=')')
				s.push(ch[i]);
		
		else if(ch[i]!=')')
		{
			count=0;
			while(s.peek()!='(')
			{
				count++;
				s.pop();
			}
			s.pop();
			if(count==0)
				return true;
		}
	}
			if(count==0)
				return true;
			else
				return false;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		
		System.out.println(check(str));
}
}
