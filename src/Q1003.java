import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 7..
 */
public class Q1003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in,t = sc.nextInt();
        int[][] dp = new int[2][41];

        dp[0][0]=dp[1][1]=1;
        dp[0][1]=dp[1][0]=0;

        for(int i=2; i<dp[0].length; i++){
            dp[0][i]=dp[0][i-1]+dp[0][i-2];
            dp[1][i]=dp[1][i-1]+dp[1][i-2];
        }
        while(t-->0){
            in = sc.nextInt();
            System.out.printf("%d %d\n", dp[0][in], dp[1][in]);
        }
    }
}
