import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 6..
 * 최대공약수 구하기 - 유클리드호제법
 * 두 수 A, B의 최대 공약수를 GCD(A,B)라할때 A를 B로 나눈나머지를 r이라하면
 * GCD(A,B) == GCD(B,r) 이고 r이 0이면 그때 B가 최대공약수이다
 */
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); int y = sc.nextInt();
        int ans = gcd(x,y);
        System.out.printf("%d와 %d의 최대 공약수는 %d입니다",x,y,ans);
    }

    private static int gcd(int x, int y){
        if(y==0)
            return x;
        else
            return gcd(y,x%y);
    }
}
