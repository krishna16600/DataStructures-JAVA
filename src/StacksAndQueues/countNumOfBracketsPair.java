import java.util.*;
public class countNumOfBracketsPair {

	public static int count(String brackets)
	{
		if(brackets.length() == 1 || brackets.length()==0)
			return 0;
		
		else
		{
			int open = 0;
		      int count =0;

		     for(int i=0;i<brackets.length();i++){
		        if(brackets.charAt(i)=='('){
		        open++;
		        System.out.println("open in if" + open);
		        }else if(brackets.charAt(i)==')'){
		         open--;
		         System.out.println("open in else" + open);
		        }
		        if(open<0){
		        count++;
		        open++;
		        System.out.println("open in c "+ open);
		        System.out.println("count " + count);
		     }
		  }
		  return count+open;
		}	
	}
	public static void main(String[] args) {
		System.out.println("enter string of brackets");
		Scanner sc =  new Scanner(System.in);
		String str = sc.nextLine();
		
		System.out.println(count(str));
	}
}
