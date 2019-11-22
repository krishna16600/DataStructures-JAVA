
public class MinStepsTo1 {

	public static int countSteps(int n)
	{
		//brute-force recursive solution
		if(n==1)
			return 0;
		
		int a = countSteps(n-1);
		int b= 100000;
		int c = 10000;
		if(n%2==0)
			b = countSteps(n/2);
		
		if(n%3==0)
			c = countSteps(n/3);
		
		return 1+Math.min(a, Math.min(b, c));
	}
	public static int countStepsM(int n)
	{
		int[] storage = new int[n+1];
		return countStepsM(n,storage);
	}
	public static int countStepsM(int n,int[] storage)
	{
		//Memoization approach
		if(n==1)
		{
			storage[n] = 0;
			return storage[n];
		}
		
		if(storage[n]!=0)
		{
			//if the solution has been found earlier of any step then simply return the ans
			return storage[n];
		}
		int a = countStepsM(n-1,storage);
		int b= 100000;
		int c = 10000;
		if(n%2==0)
			b= countStepsM(n/2,storage);
		
		if(n%3==0)
			c= countStepsM(n/3,storage);
		
		storage[n] = 1+Math.min(a, Math.min(b, c));
		//why adding 1? because every step will atleast take 1 step to go till 1
		return storage[n];
	}
	
	public static int countStepsDP(int n)
	{
		int[] storage = new int[n+1];
		storage[1] = 0;
		for(int i=2;i<=n;i++)
		{
			int min = storage[i-1];
			if(i%3==0)
			{
				if(min > storage[i/3]) {
					min = storage[i/3];
				}
			}
			if(i%2==0)
			{
				if(min > storage[i/2]) {
					min = storage[i/2];
				}
			}
			storage[i] = 1+min;
		}
		return storage[n];
	}
	public static void main(String[] args) {
		System.out.println(countStepsDP(1000));
		System.out.println(countStepsM(1000));
		System.out.println(countSteps(1000));
		
	}
}
