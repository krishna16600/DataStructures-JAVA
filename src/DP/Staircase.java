
public class Staircase {
	public static long getSteps(int n)
	{
		long[] storage = new long[n+1];
		return getStepsDP(n,storage);
	}
	public static long getStepsDP(int n,long storage[])
	{
		int steps[] = {1,2,3};
		storage[0] = 1;
		storage[1] = 1;
		storage[2] = 2;

		if(storage[n]!=0)
			return storage[n];
		
		for(int i=3;i<=n;i++)
		{
			long sum = 0;
			for(int j=0;j<steps.length;j++)
			{
				if(i-steps[j]>=0)
				{
					sum+=storage[i-steps[j]];
				}
			}
			storage[i] = sum;
		}
		return storage[n];
	}
	
	public static void main(String[] args) {
		int n = 70;
		System.out.println(getSteps(n));
	}
}
