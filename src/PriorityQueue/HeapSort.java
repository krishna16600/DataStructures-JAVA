
public class HeapSort {
	private static void insertIntoVirtualHeap(int[] arr, int i) {
		int childIndex = i;
		int parentIndex = (childIndex - 1) / 2;
		while (childIndex > 0) {
			if (arr[childIndex] > arr[parentIndex]) {
				int temp = arr[childIndex];
				arr[childIndex] = arr[parentIndex];
				arr[parentIndex] = temp;
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}

	}

	private static int removeFromVirtualHeap(int[] arr, int size) {
		int temp = arr[0];
		arr[0] = arr[size - 1];
		System.out.println("Arr[0] "+arr[0]);
		size--;
		int index = 0;
		int leftChild = 2 * index + 1;
		int rightChild = 2 * index + 2;

		while (leftChild < size) {
			int minIndex = index;
			if (arr[leftChild] > arr[minIndex]) {
				minIndex = leftChild;
				System.out.println("MinIndex in firts if " + minIndex);
			}
			if (rightChild < size && arr[rightChild] > arr[minIndex]) {
				minIndex = rightChild;
				System.out.println("MinIndex in second if" + minIndex);

			}
			if (index != minIndex) {
				System.out.println("index "+index+" arr[index] "+arr[index]+" arr[minIndex] "+arr[minIndex] );
				
				System.out.println();
				int temp1 = arr[index];
				arr[index] = arr[minIndex];
				arr[minIndex] = temp1;
				index = minIndex;
				leftChild = 2 * index + 1;
				rightChild = 2 * index + 2;
				System.out.println("index "+index+"LC "+leftChild  + "RC" + rightChild);

			} else
				break;
		}
		for(int i=0;i<size;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println("Temp " + temp);
		return temp;
	}

	public static void main(String[] args) {
		int[] arr = { 100, 54, 25, 65, 78, 1, 23, 44 };
		for (int i = 0; i < arr.length; i++) {
			insertIntoVirtualHeap(arr, i);
		}

		System.out.println("After inserting into heap");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();

		for (int i = 0; i < arr.length; i++) {
			arr[arr.length - 1 - i] = removeFromVirtualHeap(arr, arr.length - i);
		}
		System.out.println("After sorting");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

}
