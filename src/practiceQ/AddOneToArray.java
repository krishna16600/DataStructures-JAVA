import java.util.ArrayList;
import java.util.Scanner;

public class AddOneToArray {
    public static int[] plusOne(int[] A) {
        if(A.length==1)
        {
            int c=0;
            A[A.length-1]= (A[A.length-1]+1);
            if(A[A.length-1]>9)
            {
                A[A.length-1]%=10;
                c=1;
            }
            if(c!=0)
            {
                int[] newArr= new int[A.length+1];
                newArr[0] = c;
                for(int i=1;i<newArr.length;i++)
                    newArr[i] = A[i-1];
                return newArr;
            }
            return A;
        }

        if(A[0]==0)
        {
            int index=0;
            for(int i=0;i<A.length;i++)
            {
                if(A[i]!=0){
                    index=i;
                    break;
                }
            }

            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i=index;i<A.length;i++)
                arr.add(A[i]);

            A = new int[A.length-index];
            for(int i=0;i<A.length;i++)
                A[i] = arr.get(i);
        }
        int carry = 0;
        int sum = 0;
        A[A.length-1]= (A[A.length-1]+1);
        if(A[A.length-1]>9)
        {
            A[A.length-1]%=10;
            carry=1;
        }
        for(int i=A.length-2;i>=0;i--)
        {
            A[i] = A[i]+carry;
            carry=A[i]/10;
            A[i] = A[i]%10;
        }
        if(carry!=0)
        {
            int[] newArr= new int[A.length+1];
            newArr[0] = carry;
            for(int i=1;i<newArr.length;i++)
                newArr[i] = A[i-1];
            return newArr;
        }
        return A;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++)
            A[i] = sc.nextInt();

        int ans[] = plusOne(A);
        for(int a:ans)
            System.out.print(a+" ");
    }
}
