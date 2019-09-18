import java.util.Scanner;

public class MaxHeap {

	public static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;

		if (left < n && arr[left] > arr[largest])
			largest = left;

		if (right < n && arr[right] > arr[largest])
			largest = right;

		if (largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr, n, largest);
		}

	}

	public static void printHeap(int[] arr, int n) {
		System.out.println("MAX HEAP");
		for (int i : arr)
			System.out.print(i + " ");
	}

	public static void buildHeap(int[] arr, int n) {
		int start = (n / 2) - 1;

		for (int i = start; i >= 0; i--)
			heapify(arr, n, i);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter size");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("enter elemenets");
		for (int i = 0; i < size; i++)
			arr[i] = sc.nextInt();

		int n = arr.length;

		System.out.println("Array:");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();

		buildHeap(arr, n);
		printHeap(arr, n);
	}
}
