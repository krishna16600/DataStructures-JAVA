import java.util.ArrayList;

public class MaxPriorityQ {
	private ArrayList<Integer> heap;

	public MaxPriorityQ() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;
		while (childIndex > 0) {
			if (heap.get(childIndex) > heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				;
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int delete() throws PriorityQException {
		if (heap.isEmpty()) {
			throw new PriorityQException();
		}
		int temp = heap.get(0);
		int lastChild = heap.get(heap.size() - 1);
		heap.set(0, lastChild);
		heap.remove(heap.size() - 1);
		int index = 0;
		int miniIndex = index;
		int leftChild = 1;
		int rightChild = 2;
		while (leftChild < heap.size()) {
			if (heap.get(leftChild) > heap.get(miniIndex)) {
				miniIndex = leftChild;
			}
			if (rightChild < heap.size() && heap.get(rightChild) > heap.get(miniIndex)) {
				miniIndex = rightChild;
			}
			if (miniIndex == index)
				break;
			else {
				int temp1 = heap.get(index);
				heap.set(index, heap.get(miniIndex));
				heap.set(miniIndex, temp1);
				index = miniIndex;
				leftChild = 2 * index + 1;
				rightChild = 2 * index + 2;

			}
		}
		return temp;
	}

	void print() {
		for (Integer a : heap) {
			System.out.print(a + " ");
		}
	}

	public static void main(String[] args) throws PriorityQException {
		MaxPriorityQ q = new MaxPriorityQ();
		int[] arr = {1,20,30,10,2,3};
		for(int i=0;i<arr.length;i++)
		{
			q.insert(arr[i]);
		}
		q.print();
		System.out.println();
		for(int i=0;i<arr.length;i++)
			System.out.println(q.delete());
		
	}
}
