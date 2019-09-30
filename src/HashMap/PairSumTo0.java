import java.util.HashMap;

public class PairSumTo0 {
	
	public static void pairSum(int[] arr)
	{
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(hm.containsKey(arr[i]))
				hm.put(arr[i] , hm.get(arr[i]) + 1);
				else
					hm.put(arr[i] , 1);
		}
		
		for(int i=0;i<arr.length;i++)
		{
			int key = arr[i];
			
			if(hm.containsKey(-key) && hm.get(key)!=0)
			{
				int times = hm.get(key) * hm.get(-key);
				while(times!=0)
				{
					 System.out.printf(Math.min(key, (-key))+" ");
					System.out.println(Math.max(key, (-key)));
					times--;
				}
				hm.put(key , 0);
				hm.put(-key , 0);
			}
		}
	}
	public static void main(String[] args) {
		int[] arr = {2,-1,-2,2,3};
		pairSum(arr);
	}
}
