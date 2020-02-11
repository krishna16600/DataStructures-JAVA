import java.util.Arrays;
import java.util.Scanner;

public class HotelBooking {
    public static boolean getAns(int[] arrival,int[] depart,int rooms)
    {
        Arrays.sort(arrival);
        Arrays.sort(depart);
        int i=0,j=0;
        while(i<arrival.length && j<depart.length)
        {
            //if arrival date is lesser than depat date, means rooms has been allotted to person and room will be dec by 1
            //check next booking as well
            if(arrival[i] < depart[j])
            {
                rooms--;
                //check next arrival date
                i++;
            }
            else
            {
                //if arrival date is greater than deoart date, means hotel requires one more room, inc room by 1
                //check next depart
                rooms++;
                j++;
            }
            //if at any point of time rooms are less than 0 , means there are not enough rooms to occupy people
            System.out.println("Rooms available "+rooms);
            if(rooms<0)
                return false;

        }
        return true;
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

        System.out.println("enter rooms ");
        int k = sc.nextInt();
        System.out.println("is booking possible? "+ getAns(arrival,depart,k));
    }
}
