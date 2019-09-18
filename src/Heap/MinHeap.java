import java.util.Scanner;

public class MinHeap {
	public static void Heapify(int arr[],int size,int i)
	{
		int smallest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		
		if(left < size && arr[left] < arr[smallest])
			smallest = left;
		
		if(right < size && arr[right] < arr[smallest])
			smallest = right;
		
		if(smallest!=i)
		{
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			//perform same on the further subtree
			Heapify(arr,size,smallest);
		}
	}
	
	public static void printHeap(int[] arr,int size)
	{
		System.out.println("Min Heap:");
		for(int i:arr)
			System.out.print(i+" ");
	}
	
	public static void buildHeap(int[] arr,int n)
	{
		int start = (n/2)-1;
		
		for(int i= start ;i>=0; i--)
			Heapify(arr,n,i);
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

		buildHeap(arr,n);
		printHeap(arr,n);
		}
}
