import java.util.HashMap;
import java.util.Scanner;

public class IntersectionOf2Arrays {

	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	public static void main(String[] args) {
		int[] arr1= takeInput();
		int[] arr2 = takeInput();
		 intersection(arr1,arr2);
	}
	public static void intersection(int[] arr1, int[] arr2) {
		HashMap<Integer,Integer> hm = new  HashMap<Integer, Integer>();
		
		for(int i=0;i<arr1.length;i++)
		{
			if(hm.containsKey(arr1[i]))
				hm.put(arr1[i],hm.get(arr1[i])+1);
			else
				hm.put(arr1[i] , 1);
		}
		for(int i=0;i<arr2.length;i++)
		{
			if(hm.containsKey(arr2[i]))
			{
				int value = hm.get(arr2[i]);
				if(value>0)
				{
					System.out.println(arr2[i]);
					hm.put(arr2[i] , value-1);
				}
			}
		}
	}
}
