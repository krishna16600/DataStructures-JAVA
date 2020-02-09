import java.util.Scanner;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();
        
        int max = A[A.length-1];
        int omax = A[A.length-1];
        for(int i=A.length-2;i>=0;i--)
        {
            max = Math.max(max+A[i],A[i]);
            if(omax < max)
                omax = max;
        }
        System.out.println(omax);

    }
}
