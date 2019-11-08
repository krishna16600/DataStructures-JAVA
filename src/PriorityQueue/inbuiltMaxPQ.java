import java.util.*;

class MinPQComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if (o1 < o2)
			return -1;
		else if (o1 > o2)
			return 1;
		return 0;
	}

}

class MaxPQComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		if (o1 > o2)
			return -1;
		else if (o1 < o2)
			return 1;
		// TODO Auto-generated method stub
		return 0;
	}

}
class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		if(o1.length() < o2.length())
			return -1;
		else if(o1.length() > o2.length())
			return 1;
		return 0;
	}
	
}
public class inbuiltMaxPQ {
	public static void main(String[] args) {
		/*
		 * MaxPQComparator maxC = new MaxPQComparator(); PriorityQueue<Integer> pq = new
		 * PriorityQueue<>(maxC);
		 */
		//inbuilt max comparator 
	//	PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		
		
		
		/*
		 * int[] arr = {9,1,0,4,7,3}; for(int i = 0;i<arr.length;i++) pq.add(arr[i]);
		 * 
		 * while(!pq.isEmpty()) { System.out.print(pq.remove()+" "); }
		 */
		
		//MAKE A PQ OF STRING WHICH WILL BE SORTED ON THE BASIS OF STRING LENGTH
		PriorityQueue<String> pq = new PriorityQueue<String>(new StringLengthComparator());
		String arr[]= {"this","at","a","their","queues"};
		for(int i = 0;i<arr.length;i++)
			pq.add(arr[i]);
		
		while(!pq.isEmpty()) {
			System.out.print(pq.remove()+" ");
		}
		
		 
		 /*
		  *  the collections.reverseOrder() has a function COMPARE which works on the basis of
		  *  the function which we create in our own implemented min/max PQ, 
		  *  we had one condition there
		  *  if(arr[childIndex]<arr[parentIndex] 
		  *  swap;
		  *  
		  *  same works here as well,
		  *  now the swapping part will be done only when the compare function returns -1
		  *  if both are same then 0 is returned;
		  *  
		  *  now for min , -1 will be returned when a1 < a2;
		  *  for max, -1 will be returned when a1 > a2;
		  *  
		  *  
		  */
	}
}
