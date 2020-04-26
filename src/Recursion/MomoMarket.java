import java.util.*;
public class MomoMarket {
	public static int getIndex(long[] arr,int low,int high,long x)
	{
		if(low > high)
			return -1;
		
		if(x>=arr[high])
			return high;
		
		int mid = (low+high)/2;
		
		if(arr[mid]==x)
			return mid;
		
		if(mid > 0 && x>= arr[mid-1] && x < arr[mid])
			return mid-1;
		
		if(x<arr[mid])
			return getIndex(arr,low,mid-1,x);
		
		return getIndex(arr,mid+1,high,x);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numOfShop = sc.nextInt();
		long[] arr = new long[numOfShop];
		for(int i=0;i<arr.length;i++)
		{
			arr[i] = sc.nextLong();
		}
		long[] prefix = new long[numOfShop];
		prefix[0] = arr[0];
		for(int i=1;i<arr.length;i++)
		{
			prefix[i] = prefix[i-1]+arr[i];
		}
		int q = sc.nextInt();
		while(q-->0)
		{
			long x = sc.nextLong();
			int s = getIndex(prefix,0,numOfShop-1,x);
			long val = x;
			if(s!=-1)
				val-=prefix[s];
			System.out.println((s+1)+" "+val);
		}
		
	}
}
