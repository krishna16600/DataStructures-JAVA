
public class countNumberOfBTs {
	
	public static int countBT(int h)
	{
		int mod = (int)Math.pow(10, 9)+7;
		return countBT(h,mod);
	}
	public static int countBT(int h,int mod)
	{
		if(h==1 || h==0)
			return 1;
	
		
		int x = countBT(h-1);
		int y = countBT(h-2);
		long value1 = (long)x*x;
		long value2 = (long)2*x*y;
		int res1 = (int)(value1%mod);
		int res2 = (int)(value2%mod);
		
		return (res1+res2)%mod;
	}
	
	public static int countBT_DP(int h)
	{
		if(h==1 || h==0)
			return 1;
		
		int[] storage = new int[h+1];
		  int mod=(int)Math.pow(10,9)+7;
		storage[0] = 1;
		storage[1] = 1;
		for(int i=2;i<storage.length;i++)
		{
			long val1 = (long)storage[i-1]*storage[i-1];
			long val2 = (long)storage[i-1]*storage[i-2]*2;
			int res1 = (int)(val1%mod);
			int res2 = (int)(val2%mod);
			storage[i] = ((res1+res2)%mod);
		}
		return storage[h];
		
	}
	public static void main(String[] args) {
		System.out.println(countBT_DP(7));
	}
}
