import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class LongestIncreasingSubSequence {

	public static ArrayList<Integer> findSeq(int[] arr)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> s = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
			s.add(arr[i]);
		
		int startPoint = 0;
		int length = 0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(!s.contains(arr[i]-1))
			{
				startPoint = arr[i];
				int j = arr[i];
				while(s.contains(j)) {
					j++;
					
				}
				if(length < j-arr[i])
					length = j-arr[i];
				
			}
		}
		System.out.println(startPoint+" "+ length);
		for(int j = startPoint; j <startPoint+length; j++)
		{
			list.add(j);
		}
		return list;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		
		for(int i=0;i<size;i++)
		{
			arr[i] = sc.nextInt();
		}
		System.out.println(findSeq(arr));
	}
}
