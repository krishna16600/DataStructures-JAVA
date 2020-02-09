import java.util.Scanner;

public class StringMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int index=0;
        int len=s2.length();

        for(int i=0;i<s1.length();i++) {
            if (s1.substring(i, i + len).equalsIgnoreCase(s2)) {
                index = i;
                break;
            }
        }
        System.out.println(index);
        String ans="";
        for(int i=0;i<index;i++)
            ans+=s1.charAt(i);

        for(int i=index+len;i<s1.length();i++)
            ans+=s1.charAt(i);

        System.out.println(ans);
    }
}
