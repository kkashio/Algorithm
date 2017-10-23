import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class S1952 {
    static int dCost, mCost, m3Cost, yCost, use[]=new int[13],dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), tc=0;
        while(tc++<t){
            dCost=sc.nextInt(); mCost=sc.nextInt(); m3Cost=sc.nextInt(); yCost=sc.nextInt();
            for(int i=1; i<13; i++)
                use[i] = sc.nextInt();

            dp=new int[2][13];
            dp[0][1]=sol(use[1]);
            dp[0][2]=sol(use[2])+dp[0][1];
            dp[0][3]=sol(use[3])+dp[0][2];
            dp[1][1]=dp[1][2]=dp[1][3]=m3Cost;

            for(int i=4; i<13; i++){
                dp[0][i] = Math.min(dp[0][i-1], dp[1][i-1]) + sol(use[i]);
                dp[1][i] = Math.min(dp[0][i-3], dp[1][i-3]) + m3Cost;
            }
            int ans = Math.min(Math.min(dp[0][12], dp[1][12]), yCost);

            System.out.printf("#%d %d",tc, ans);
            System.out.println();
        }
    }

    static int sol(int x){
        return Math.min(mCost, dCost*x);
    }
}
