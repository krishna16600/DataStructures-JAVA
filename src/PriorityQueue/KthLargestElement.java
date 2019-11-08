import java.util.*;

public class KthLargestElement {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("enter elements");
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println("Enter Kth largest no. to find ");
		int k = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);

		int ans = 0;
		int start = 0;
		while (start!=k) {
			ans = pq.remove();
			System.out.println("ANS: "+ans);
			start++;
		}
		System.out.println(k + "th largest element is: " + ans);
	}
}
