import java.util.Scanner;

/*

Find out the maximum sub-array of non negative numbers from an array.
The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

Example:

A : [1, 2, 5, -7, 2, 3]
The two sub-arrays are [1, 2, 5] [2, 3].
The answer is [1, 2, 5] as its sum is larger than [2, 3]
NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
NOTE 2: If there is still a tie, then return the segment with minimum starting index

*/
public class MaxNonNegativeSubArray {
    public static int getAns(int[] arr)
    {
        int maxSum = 0;
        int finalSum=0;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]<0)
            {
                if(finalSum < maxSum)
                    finalSum = maxSum;
                maxSum = 0;
            }
            else
                maxSum+=arr[i];
        }
        if(finalSum < maxSum)
            finalSum = maxSum;

        return finalSum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();

        System.out.println(getAns(arr));
    }

}
