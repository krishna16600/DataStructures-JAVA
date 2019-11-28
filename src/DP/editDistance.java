
public class editDistance {
	public static int editM(String s,String t)
	{
		int m = s.length();
		int n = t.length();
		int[][] storage = new int[m+1][n+1];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				storage[i][j] = -1;
		return editDP(s,t,storage);
	}
	public static int editDP(String s,String t,int[][] storage)
	{
		int m = s.length();
		int n = t.length();
		
		for(int i=0;i<=n;i++)
			storage[0][i] = i;
		
		for(int i=0;i<=m;i++)
			storage[i][0] = i;
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(s.charAt(m-i)==t.charAt(n-j))
					storage[i][j] = storage[i-1][j-1];
				else
				{
					storage[i][j] = 1+ Math.min(storage[i-1][j], Math.min(storage[i][j-1], storage[i-1][j-1]));
				}
			}
		}
		return storage[m][n];
	}
	public static void main(String[] args) {
		System.out.println(editM("krishna","shivangi"));
	}
}
