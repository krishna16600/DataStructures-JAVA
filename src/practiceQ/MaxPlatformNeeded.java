import java.util.Arrays;
import java.util.Scanner;

public class MaxPlatformNeeded {
    public static int getAns(int[] arrival,int[] depart)
    {
        //sortinng both the arrays
        Arrays.sort(arrival);
        Arrays.sort(depart);
        //both should be 1 because atleast one station is needed always
        int maxPlatforms = 1;
        int neededPlatforms = 1;

        //start from second element in arrival timings and first element from depart timings
        int i=1;
        int j=0;

        while(i<arrival.length && j<depart.length)
        {
            //compare arrival time with depart time
            //if arrival is greater than depart, it means a train has departed, leaving one station empty
            //so max platforms needed will be decremented by 1 and move to next depart timings to see when another train will be leaving
            if(arrival[i] > depart[j])
            {
                maxPlatforms--;
                j++;
            }
            else{
            //if the arrival timings are less than depart timings, it means we need one more platform or a train has arrived in the same time
                maxPlatforms++;
                i++;
            }
            if(maxPlatforms > neededPlatforms)
                neededPlatforms = maxPlatforms;
        }
        return neededPlatforms;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Arrival Timings");
        int[] arrival = new int[n];
        for(int i=0;i<n;i++)
            arrival[i] = sc.nextInt();
        System.out.println("Depart timings");
        int[] depart = new int[n];
        for(int i=0;i<n;i++)
            depart[i] = sc.nextInt();

        System.out.println("Max platforms needed are "+ getAns(arrival,depart));
    }
}

