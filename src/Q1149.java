import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 7..
 */
public class Q1149 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,ans=987654321,n = sc.nextInt();
        int cost[][] = new int[n][3];
        for(i=0; i<n; i++)
            for (j=0; j<3; j++)
                cost[i][j] = sc.nextInt();

        int dp[][] = new int[3][1001];
        dp[0][0] = cost[0][0];
        dp[1][0] = cost[0][1];
        dp[2][0] = cost[0][2];

        for(j=1; j<n; j++){
            for(i=0; i<3; i++){
                dp[i][j] = Math.min(dp[(i+1)%3][j-1],dp[(i+2)%3][j-1]) + cost[j][i];
            }
        }
        for(i=0; i<3; i++) {
            if (dp[i][n - 1] < ans) {
                ans = dp[i][n-1];
            }
        }
        System.out.println(ans);
        print(dp,n);

    }

    static void print(int dp[][],int n){
        for(int i=0; i<3; i++){
            for(int j=0; j<n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}