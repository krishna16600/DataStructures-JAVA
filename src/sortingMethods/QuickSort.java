import java.util.Scanner;

public class QuickSort {
	
	/*public static int partition(int[] arr , int low , int high)
	{
						TAKING LAST ELEMENT AS PIVOT
		  int pivot = arr[high];  
	        int i = low-1; // index of smaller element 
	        for (int j=low; j<high; j++) 
	        { 
	            // If current element is smaller than the pivot 
	            if (arr[j] < pivot) 
	            { 
	                i++; 
	  
	                // swap arr[i] and arr[j] 
	                int temp = arr[i]; 
	                arr[i] = arr[j]; 
	                arr[j] = temp; 
	            } 
	        } 
	  
	        // swap arr[i+1] and arr[high] (or pivot) 
	        int temp = arr[i+1]; 
	        arr[i+1] = arr[high]; 
	        arr[high] = temp; 
	  
	        return i+1;
	}
	*/
	public static int partition (int[] arr,int low,int high)
	{
		int pivot = arr[low];
		int i = low+1;
		System.out.println("low "+ low+" high "+ high);
		for(int j= low+1 ; j<=high; j++)
		{
			if(arr[j] < pivot)
			{
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			System.out.println("after swapping arr[i] and arr[j] ");
			printArray(arr);
			System.out.println();
		} 
			int temp = arr[low];
			arr[low]  = arr[i-1];
			arr[i-1] = temp;

			System.out.println("after swapping arr[i-1] and arr[low] ");
			printArray(arr);
			System.out.println();
			return i-1;
		
	}
	public static void quickSort(int[] arr,int low, int high)
	{
		if(low < high)
		{
			int p = partition(arr, low, high);
			quickSort(arr, low, p-1);
			quickSort(arr , p+1 , high);
		}
	}
	
	public static void printArray(int[] arr) {
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		
	}
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("enter size");
	int size = sc.nextInt();
	System.out.println("enter elements");
	int[] arr = new int[size];
	for(int i=0;i<size;i++)
	{
		arr[i] = sc.nextInt();
	}
	System.out.println("Array: ");
	System.out.println();
	printArray(arr);
	System.out.println();
	quickSort(arr,0,size-1);
	System.out.println();
	printArray(arr);
}


}
