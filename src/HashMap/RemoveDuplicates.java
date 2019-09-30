import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {
	public static ArrayList<Integer> removeDuplicat(int[] arr)
	{
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, Boolean> seen = new HashMap<>();
		for(int i=0;i<arr.length;i++)
		{
			if(seen.containsKey(arr[i]))
				continue;
			
			output.add(arr[i]);
			seen.put(arr[i], true);
		}
		return output;
	}
	public static void main(String[] args) {
		int[] arr= {1,2,2,3,4,4,4,5,1,2,3,5,6,7,6,6,6,20000};
		ArrayList<Integer> list = removeDuplicat(arr);
		System.out.println(list);
	}
}
