import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 9..
 */
public class Q10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test_case = sc.nextInt();
        String[] result = new String[test_case];

        for(int i=0; i<test_case; i++){
            double h = sc.nextInt();
            int w = sc.nextInt();
            double n = sc.nextInt();

            double f = n%h;
            if(f==0){
                f = h;
            }
            int ho = (int) Math.ceil(n/h);

            if(ho < 10)
                result[i] = (int)f + "0" + ho;
            else
                result[i] = (int)f + "" + ho;

        }

        for(String str : result)
            System.out.println(str);
    }
}
