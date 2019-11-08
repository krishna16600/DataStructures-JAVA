import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Comparator;

class  PairComparator implements Comparator<Pair>{
	public int compare(Pair p1, Pair p2)
	{
		if(p1.value <= p2.value)
			return 1;
		else
			return -1;
	}
}
class Pair{
	int value;
	int arrayNumber;
	Pair(int v,int a)
	{
		value = v;
		arrayNumber = a;
	}
	
}

public class mergeKsortedArrays {
	public static ArrayList<Integer> getSorted(ArrayList<ArrayList<Integer>> input)
	{
		PairComparator compare = new PairComparator();
		PriorityQueue<Pair> maxHeap = new PriorityQueue<Pair>(input.size(),compare);
		for(int i = 0; i<input.size(); i++)
		{
			int index = input.get(i).size()-1;
			Pair current = new Pair(input.get(i).get(index), i);
			maxHeap.add(current);
			input.get(i).remove(index);
		}
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		while(!maxHeap.isEmpty())
		{
			Pair max = maxHeap.remove();
			output.add(max.value);
			int i = max.arrayNumber;
			if(input.get(i).size() > 0)
			{
				int index = input.get(i).size()-1;
				int value = input.get(i).get(index);
				input.get(i).remove(index);
				Pair newP = new Pair(value, i);
				maxHeap.add(newP);
			}
			
		}
		Collections.reverse(output);
		return output;
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		
		ArrayList<Integer> output = mergeKsortedArrays.getSorted(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
			
	}
}
