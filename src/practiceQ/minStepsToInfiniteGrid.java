import java.util.Scanner;

//Q. You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
/*
Given two integer arrays A and B, where A[i] is x coordinate and B[i] is y coordinate of ith point respectively.
Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
 */
public class minStepsToInfiniteGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] xCoords = new int[n];
        int [] yCoords = new int[n];

        System.out.println("enter x coords");
        for(int i=0;i<n;i++)
        {
            xCoords[i] = sc.nextInt();
        }
        System.out.println("enter y coords");
        for(int i=0;i<n;i++)
            yCoords[i] = sc.nextInt();

        int dist =0;
        for(int i=1;i<n;i++)
        {
            dist+=Math.max(Math.abs(xCoords[i]-xCoords[i-1]),Math.abs(yCoords[i]-yCoords[i-1]));
        }

        System.out.println("To reach "+xCoords[n-1]+","+yCoords[n-1]+" you need "+dist+" steps");
    }
}
