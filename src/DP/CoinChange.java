
public class CoinChange {

		public static int countWaysToMakeChange(int coins[], int amount) {
			int row = coins.length+1;
			int col = amount+1;
				int[][] storage = new int[row][col];
				
				//filling the first column with 1.. because if we have no amount to sum up to.. we need only 1 way that is no change
				for(int i=0;i<row;i++)
					storage[i][0] = 1;
				
				//filling the first row from 1 to col end with 0 because if there is some amount to make and we have no coins.. total ways are 0
				for(int i=1;i<col;i++)
					storage[0][i] = 0;
				
				
				for(int i=1;i<row;i++)
				{
					for(int j=1;j<col;j++)
					{
						if(j >= coins[i-1])
						{
							//storage[i][j] = include+exclude;
							storage[i][j] = storage[i][j-coins[i-1]] + storage[i-1][j];
						}
						else
							storage[i][j] = storage[i-1][j];
					}
				}
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++)
					{
						System.out.print(storage[i][j]+" ");
					}
					System.out.println();
				}
				return storage[row-1][amount];
		}
		public static void main(String[] args) {
			int[] coins = {1,2,3};
			int amount = 4;
			System.out.println(countWaysToMakeChange(coins, amount));
		}

}
