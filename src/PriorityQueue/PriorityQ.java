import java.util.ArrayList;

public class PriorityQ {
	private ArrayList<Integer> heap;

	public PriorityQ() {
		heap = new ArrayList<>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQException {
		if (heap.isEmpty()) {
			throw new PriorityQException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex!= 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				// to compare the parent till the time Order is ok
				parentIndex = (childIndex-1)/2;
			} else {
				return;
			}
		}
	}
	int removeMin() throws PriorityQException {
		if(heap.isEmpty())
		{
			throw new PriorityQException();
		}
		int temp = heap.get(0);
		int lastChild = heap.get(heap.size()-1);
		heap.set(0, lastChild);
		heap.remove(heap.size()-1);
		int index = 0;
		int miniIndex = index;
		int leftChild = 1;
		int rightChild = 2;
		
		
		//check for Order 
		while(leftChild < heap.size() )
		{
			if(heap.get(leftChild) < heap.get(miniIndex))
			{
				miniIndex = leftChild;
			}
			if(rightChild < heap.size() && heap.get(rightChild) < heap.get(miniIndex))
			{
				miniIndex = rightChild;
			}
			if(miniIndex == index)
				break;
			else {
				int temp1 = heap.get(index);
				heap.set(index, heap.get(miniIndex));
				heap.set(miniIndex,temp1);
				index = miniIndex;
				leftChild = 2*index+1;
				rightChild = 2*index+2;
			}
		}
		return temp;
	}
	void print() {
		for(Integer a: heap)
		{
			System.out.print(a +" ");
		}
	}
	public static void main(String[] args) throws PriorityQException {
	PriorityQ q = new PriorityQ();
	q.insert(10);
	q.insert(20);
	q.insert(40);
	q.insert(2);
	q.insert(32);
	q.insert(3);
	q.insert(65);
	System.out.println(q.size());
	q.print();
	System.out.println();
	for(int i=0;i<7;i++)
	{
		System.out.println(q.removeMin());
	}
	}
		/*
		 * 				NOTES
		 * Basically this is HEAP SORT, where we get the sorted order of the array by deleting single element again and again.
		 * Talking about TIME COMPLEXITY => insertion takes O(nlogn) [logn due to height of the tree and we have to put N elements, so nlogn]
		 * Deleteion takes O(nlogn) as well, so 
		 * OverALL Heap sort TC => O(nlogn)
		 * SPACE COMPLEXITY => O(n)
		 */
}

