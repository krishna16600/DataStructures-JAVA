import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BuyTheTicket {
	public static int findTime(int[] arr, int k) {
		Queue<Integer> q = new LinkedList<>();

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

		for (int i : arr) {
			q.add(i);
			pq.add(i);
		}
		int count = 0;

		while (!pq.isEmpty()) {
			if ((q.peek()).equals(pq.peek())) {
				if (k == 0)
					return count + 1;
				else {
					pq.poll();
					q.poll();
					count++;
					k--;
				}
			} else {
				q.add(q.poll());
				if (k == 0) {
					k = q.size() - 1;
				} else {
					k--;
				}
			}
		}
		return count;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();

		System.out.println("enter K");
		int k = sc.nextInt();
		System.out.println(findTime(arr, k));
	}
}
