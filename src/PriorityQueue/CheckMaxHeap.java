import java.util.*;

public class CheckMaxHeap {
	public static boolean check(int[] arr)
	{
		int len = arr.length;
		for(int i = 0;i<len;i++)
		{
			if((2*i+1) < len && arr[i] < arr[2*i+1])
				return false;
			if((2*i+2) < len && arr[i] < arr[2*i+2])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("enter elements");
		for(int i = 0;i<n;i++)
			arr[i] = sc.nextInt();
		
		
		System.out.println("The given heap is max heap? "+ check(arr));
	}
}
