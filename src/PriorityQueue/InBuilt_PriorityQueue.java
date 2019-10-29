import java.util.*;

public class InBuilt_PriorityQueue {
	
		public static void sortKSorted(int[] arr, int k)
		{
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			int i=0;
			for(;i<k;i++)
				pq.add(arr[i]);
			
			for(;i<arr.length;i++)
			{
				arr[i-k] = pq.remove();
				pq.add(arr[i]);
			}
			for(int j= arr.length-k;j<arr.length;j++)
			{
				arr[j] = pq.remove();
			}
		}
	public static void main(String[] args) {
		int[] arr = {2,3,1,56,7,8,90};
		sortKSorted(arr, 3);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);

	}
	/*
	 * Time complexity => O(nlogK);
	 * Q. how is it better than heap sort?
	 * if we talk about heap sort, it has complexity O(nlogn) which means the addition/deletion takes logn time and for eveery n elements. which makes it nlogn or say dependent upon num of elements in 
	 * the whole array
	 * 
	 * but in kSorted array , we have O(nlogK) (nlogk for insertion + nlogk for deletion) which is far better than heap sort because now the insertion/deletion is dependent upon the size of the heap which is K.
	 * for smaller values both will run same, but if the size of the arrray is 10^6, it will make huge difference and on the other hand if it is sorted using Ksorted method,
	 * say k is 10
	 *  as log(1000000) > log(10) which makes a huge difference here
	 */
}
