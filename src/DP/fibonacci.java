import java.util.Arrays;
import java.util.Scanner;
 
public class fibonacci {
	public static int fib(int n)
	{
		int storage[] = new int[n+1];
		Arrays.fill(storage, -1);
		return fib(n,storage);
	}
	public static int fib(int n, int[] storage)
	{
		/*
		 * This method is called MEMOIZATION.. which means getting the answer from the past history.
		 * This is Top Down approach..
		 * suppose n = 5... the array will start filling from fib(5) then fib(4) and so on
		 * 
		 */
		if(n==0||n==1)
		{
			storage[n] = n;
			return n;
		}
		if(storage[n]!=-1)
			return storage[n];
		
		storage[n] = fib(n-1,storage)+fib(n-2,storage);
		return storage[n];
	}
	
	public static int fib2(int n)
	{
		/*
		 * This is DP version of finding nth fibonacci number
		 * basically what we try to do in DP is ,, we use past value results to find the next answer..
		 * whenever and wherever we can avoid using recursion we should by DP..
		 * this function results in same TC of the above function but slightly differs in space complexity
		 * wise.
		 * This is Bottom Top approach where first 2 spaces are filled of the array and then further proceeded.
		 * 
		 */
		int storage[] = new int[n+1];
		storage[0] =0;
		storage[1] = 1;
		for(int i=2;i<=n;i++)
		{
			storage[i] = storage[i-1]+storage[i-2];
		}
		return storage[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		int n = sc.nextInt();
		System.out.println(fib2(n));
	}
}
