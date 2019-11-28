
public class knapsack {
	public static int getMax(int[] weight,int[] value,int maxWeight,int n)
	{
		return getMaxR(weight,value,maxWeight,0);
	}
	public static int getMaxR(int[] weight,int[] value,int maxWeight,int index)
	{
		if(index == weight.length || maxWeight == 0)
			return 0;
		
		if(weight[index] > maxWeight)
			return getMaxR(weight,value,maxWeight,index+1);
		else
		{
			int op1 = value[index]+getMaxR(weight,value,maxWeight-weight[index],index+1);
			int op2 = getMaxR(weight, value, maxWeight, index+1);
			return Math.max(op1,op2);
		}
	}
	
	public static int getMaxDP(int[] weight,int[] value,int bagCapacity,int n)
	{
		int m = bagCapacity;
		int[][] storage = new int[n+1][m+1];
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				if(i==0 || j==0)
					storage[i][j] = 0;
				else if(weight[i-1] <= j)
				{
					storage[i][j] = Math.max(value[i-1]+storage[i-1][j-weight[i-1]], storage[i-1][j]);
				}
				else {
					storage[i][j] = storage[i-1][j];
				}
			}
		}
		return storage[n][m];
	}
	public static void main(String[] args) {
		int[] weight = {10,20,30};
		int[] value = {60,100,120};
		System.out.println(getMaxDP(weight,value,50,3));
	}
}
