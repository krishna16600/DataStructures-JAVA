
public class AllPossibleWays {
	public static int getCount(int a, int b) {
		return getCount(a, b, 1);
	}

	public static int getCount(int a, int b, int num) {
		int rest = a - (int) Math.pow(num, b);
		if (rest == 0)
			return 1;
		if (rest < 0)
			return 0;

		return getCount(a, b, num + 1) + getCount(rest, b, num + 1);

	}

	public static int allwaysM(int x, int n, int arr[], int num) {
		int val = x - (int) Math.pow(num, n);
		if (val == 0) {
			arr[0] = 1;
			return arr[0];
		}
		if (val < 0) {
			arr[x] = 0;
			return arr[x];
		}
		if (arr[x] != -1) {
			return arr[x];
		} else {
			int op1 = allwaysM(val, n, arr, num + 1);
			int op2 = allwaysM(x, n, arr, num + 1);
			arr[x] = op1 + op2;
			return arr[x];
		}
	}

	public static int allwaysM(int a, int b) {
		int[] storage = new int[a + 1];
		for(int i=0;i<storage.length;i++)
			storage[i] = -1;
		return allwaysM(a, b, storage, 1);
	}

	public static void main(String[] args) {
		System.out.println(allwaysM(100, 2));
	}
}
