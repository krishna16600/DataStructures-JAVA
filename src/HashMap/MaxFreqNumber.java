import java.util.HashMap;

public class MaxFreqNumber {
	public static int maximumFreqNum(int[] arr) {
		HashMap<Integer, Integer> output = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (output.containsKey(arr[i]))
				output.put(arr[i], output.get(arr[i]) + 1);
			else
				output.put(arr[i], 1);
		}
		int max = 0 , ans = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			if(output.get(arr[i]) > max)
			{
				max = output.get(arr[i]);
				ans = arr[i];
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {2,12,2,11,12,2,1,2,11,12,2,6};
		System.out.println(maximumFreqNum(arr));
	}
}
