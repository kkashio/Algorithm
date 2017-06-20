import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 16..
 */
public class Q1002 {

    static int x1,y1,r1,x2,y2,r2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] result = new int[t];

        for(int i=0; i<t; i++){
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            r1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            r2 = sc.nextInt();

            double l = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
            if(x1==x2 && y1==y2 && r1 == r2)
                result[i] = -1;
            else if(Math.abs(r1-r2) < l && (r1+r2) > l)
                result[i] = 2;
            else if((r1+r2) == l || Math.abs(r1-r2) == l)
                result[i] = 1;
            else if((r1+r2) < l || Math.abs(r1-r2) > l)
                result[i] = 0;
            else
                result[i] = 0;
        }

        for(int a : result)
            System.out.println(a);
    }
}
