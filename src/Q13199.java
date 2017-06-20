import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 14..
 */

public class Q13199 {

    static int p, m, f, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            p = sc.nextInt();
            m = sc.nextInt();
            f = sc.nextInt();
            c = sc.nextInt();

            int coupon_num = (m / p) * c;
            int doYoung = coupon_num / f;
            int sangEon = 0;
            int chicken = 0;
            while (coupon_num >= f) {
                chicken = coupon_num/f;
                sangEon += chicken;
                coupon_num = coupon_num % f;
                coupon_num += chicken * c;
            }
            System.out.println(sangEon - doYoung);
        }
    }
}


