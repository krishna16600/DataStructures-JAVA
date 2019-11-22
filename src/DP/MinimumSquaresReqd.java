
public class MinimumSquaresReqd {
	public static int getMin(int n) {
		// brute force recursive solution
		if (n <= 3)
			return n;

		int maxCount = n;

		for (int i = 1; i <= n; i++) {
			int temp = i * i;
			if (temp > n)
				break;
			else
				maxCount = Math.min(maxCount, 1 + getMin(n - temp));
		}
		return maxCount;
	}

	public static int getMinM(int n) {
		int storage[] = new int[n + 1];
		return getMinM(n, storage);
	}

	public static int getMinM(int n, int storage[]) {

		// MEMOIZATION method
		if (n <= 3) {
			storage[n] = n;
			return storage[n];
		}
		if (storage[n] != 0)
			return storage[n];

		int maxC = n;
		for (int i = 1; i <= n; i++) {
			int temp = i * i;
			if (temp > n)
				break;
			else {
				maxC = Math.min(maxC, 1 + getMinM(n - temp, storage));

			}
		}
		storage[n] = maxC;
		return storage[n];
	}

	public static int getMinDP(int n) {
		if (n <= 3)
			return n;

		int storage[] = new int[n + 1];
		storage[1] = 1;
		storage[2] = 1;
		storage[3] = 1;
		for (int i = 4; i <= n; i++) {
			int ans = n;
			for (int j = 1; j <= n / 2; j++) {
				int k = i - (j * j);
				if (k >= 0)
					ans = Math.min(ans, storage[k] + 1);
			}
			storage[i] = ans;
		}
		return storage[n];
	}

	public static void main(String[] args) {
		System.out.println(getMinDP(155));
	}
}
