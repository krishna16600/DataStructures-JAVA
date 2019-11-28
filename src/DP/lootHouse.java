
public class lootHouse {
	public static int getSum(int[] arr, int index) {
		if (index == arr.length || index > arr.length)
			return 0;

		int include = arr[index] + getSum(arr, index + 2);
		int exclude = getSum(arr, index + 1);
		return Math.max(include, exclude);
	}

	public static int getSumDP(int arr[],int n) {
		//if only one house
		if (n == 1)
			return arr[0];

		
		int[] storage = new int[n];
		storage[0] = arr[0];
		storage[1] = Math.max(arr[1], storage[0]);
		for (int i = 2; i < n; i++) {
			storage[i] = Math.max(arr[i] + storage[i - 2], storage[i - 1]);
		}
		return storage[n - 1];
	}

	public static void main(String[] args) {
		int[] arr = { 5, 5, 10, 100, 10, 5 };
		System.out.println(getSumDP(arr,arr.length));
	}
}
