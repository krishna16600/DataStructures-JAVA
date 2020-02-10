import java.util.HashMap;
import java.util.Scanner;

public class repeatingAndMissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        HashMap<Integer,Boolean> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            if(map.get(arr[i])==null)
                map.put(arr[i],true);
            else
                System.out.println("repeating element is "+arr[i]);
        }
        for(int i=1;i<=n;i++)
            if(map.get(i)==null)
                System.out.println("missing element is "+i);
    }
}
