import java.util.*;
public class kLargest {
	public static ArrayList<Integer> kLarge(int[] arr,int k)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		//first add K elements in the queue
		
		for(int i=0;i<k;i++)
			pq.add(arr[i]);
		
		//now remove one by one from the heap if the current element is bigger than the head of the queue
		
		for(int i=k;i<arr.length;i++)
		{
			if(arr[i] > pq.peek())
			{
				pq.remove();
				pq.add(arr[i]);
			}
		}
		ArrayList<Integer> output = new ArrayList<Integer>();
		while(!pq.isEmpty())
		{
			output.add(pq.remove());
		}
		return output;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter size");
		int n= sc.nextInt();
		int arr[] = new int[n];
		System.out.println("enter k ");
		int k = sc.nextInt();
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=sc.nextInt();
		}
		
	ArrayList<Integer> ans=kLarge(arr,k);
	System.out.println(ans );
		
	}
}
