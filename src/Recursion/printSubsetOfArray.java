import java.util.*;
public class printSubsetOfArray {
	private static void printSubsetsHelper(int[] input,int[] ans)
	{
		if(input.length==0)
		{
			for(int i=0;i<ans.length;i++)
			{

				System.out.print(ans[i]+" ");
			}
				System.out.println();
				return;
		}
		
		int[] sub = new int[ans.length+1];
		for(int i=0;i<ans.length;i++)
			sub[i] = ans[i];
		
		sub[sub.length-1] = input[0];
		
		//creating smaller array
		
		int[] temp = new int[input.length-1];
		for(int i=1;i<input.length;i++)
			temp[i-1] = input[i];
		
		//calling recursion once with temp and subsets
		printSubsetsHelper(temp, sub);
		//calling recursion again with temp and ans.. that is without including subsets
		printSubsetsHelper(temp, ans);
	}
	
	
	
	public static void printSubsets(int[] arr)
	{
		printSubsetsHelper(arr,new int[0]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size" );
		int n = sc.nextInt();
		System.out.println("enter elements");
		int[] arr = new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		printSubsets(arr);
		
	}
}
