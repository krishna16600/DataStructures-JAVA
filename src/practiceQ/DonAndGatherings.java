import java.util.*;
class Pair implements Comparator<Pair>{
    int first;
    int second;

    public int getFirst()
    {
        return first;
    }
    public int getSecond()
    {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    @Override
    public int compare(Pair p1,Pair p2){
        if(p1.getFirst() < p2.getFirst())
            return -1;
        else if(p1.getFirst() > p2.getFirst())
            return 1;
        else
            return 0;
    }



}
public class DonAndGatherings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Pair> arr = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Pair p = new Pair();
            p.setFirst(a);
            p.setSecond(b);

            arr.add(p);
        }

        int same=1;
        int notSame=0;

        System.out.println("Before sorting");
        for(int i=0;i<m;i++)
        {
            System.out.println("first "+arr.get(i).getFirst()+" second "+arr.get(i).getSecond());
        }

       Collections.sort(arr,new Pair());
        System.out.println("After sorting");
       for(int i=0;i<m;i++)
       {
           System.out.println("first "+arr.get(i).getFirst()+" second "+arr.get(i).getSecond());
       }

       for(int i=0;i<m-1;i++)
       {
           if(arr.get(i).getSecond() == arr.get(i+1).getFirst())
               same=1;
           else
               notSame++;
       }
        System.out.println("Total diff families "+(same+notSame));
    }
}
