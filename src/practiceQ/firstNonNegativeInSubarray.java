import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class firstNonNegativeInSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println("enter k");
        int k = sc.nextInt();
        Deque<Integer> dq = new LinkedList<>();

        //add indices of all non negative numbers in first window
        for(int i=0;i<k;i++)
            if(arr[i]<0)
                dq.add(i);

            for(int i=k;i<n;i++)
            {
                //if dq is not empty then the element at the first will be the first negative integer in that window
                if(!dq.isEmpty())
                    System.out.print(arr[dq.peek()]+" ");
                else
                    System.out.print(0+" ");

                //now removing all elements which are out of this window
                while(!dq.isEmpty() &&  dq.peek() < i-k+1) {
                    System.out.print("dq "+dq.peek()+" i "+i );
                    dq.remove();
                }

                //if current element if smaller than 0, add its index
                if(arr[i] < 0)
                    dq.add(i);
            }
            //for last window of size k
            if(!dq.isEmpty())
                System.out.print(arr[dq.peek()]+" ");
            else
                System.out.print(0+" ");

    }
}
