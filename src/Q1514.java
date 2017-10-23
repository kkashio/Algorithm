import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 15..
 */
public class Q1514 {
    static int n, curPw[],oriPw[];
    public static void main(String[] args) {
        int i;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        curPw = new int[n];
        oriPw = new int[n];

        String input = sc.next();
        for(i=0; i<n; i++)
            curPw[i] = input.charAt(i)-48;
        input = sc.next();
        for(i=0; i<n; i++)
            oriPw[i] = input.charAt(i)-48;

        

    }
}
