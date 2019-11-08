import java.util.*;
public class JesseAndSweetness {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i =0;i<n;i++)
		{
			pq.add(sc.nextInt());
		}
		
		int count = 0;
		
		while(pq.size() > 1 && pq.peek()<=k)
		{
			int first = pq.poll();
			int second = pq.poll();
			
			pq.add((first+ 2*second));
			count++;
			
		}
		if(pq.peek()<k)
			System.out.println("Wrong");
		else
			System.out.println("it took "+count+" turns to get the sweetness");;
	}
}
