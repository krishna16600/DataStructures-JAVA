import java.util.Scanner;

public class spiralMatrix {
    public static int[] spiralOrder(final int[][] A) {
        if (A.length == 1 && A[0].length == 1) {
            int[] ans = new int[1];
            ans[0] = A[0][0];
            return ans;
        }
        int t = 0;
        int b = A.length - 1;
        int l = 0;
        int r = A[0].length - 1;
        int dir = 0;
        //dir = 0 for left to right... 1 for top to bottom
        //2 for right to left and 3 for bottom to top
        int[] ans = new int[A.length * (A[0].length)];
        int index = 0;
        while (t <= b && l <= r) {
            //prints the top row from L to R
            if (dir == 0) {
                for (int i = l; i <= r; i++) {
                    ans[index] = A[t][i];
                    index++;
                }
                t++;
                dir = 1;
            } else if (dir == 1) {
                //prints from top to bottom
                for (int i = t; i <= b; i++) {
                    ans[index] = A[i][r];
                    index++;
                }
                r--;
                dir = 2;
            } else if (dir == 2) {
                //right to left
                for (int i = r; i >= l; i--) {
                    ans[index] = A[b][i];
                    index++;
                }
                b--;
                dir = 3;
            } else if (dir == 3) {
                for (int i = b; i >= t; i--) {
                    ans[index] = A[i][l];
                    index++;
                }
                l++;
                dir = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] arr = new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                arr[i][j] = sc.nextInt();

            int[] ans = spiralOrder(arr);
            for(int a: ans)
                System.out.print(a+" ");

    }
}
