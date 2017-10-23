import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M4 {
    static int n,m,map[][],dp[][],min=987654321, dx[]={1,0}, dy[]={1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map=new int[100][100];
        dp=new int[100][100];
        for(int i=0; i<n; i++){
            map[sc.nextInt()][sc.nextInt()] = m;
        }
        dp[0][0] = map[0][0];
        for(int i=1; i<100; i++) {
            dp[0][i] = dp[0][i-1] + (map[0][i] > 0 ? map[0][i] - i > 0 ? map[0][i]-i : 0 : 0);
            dp[i][0] = dp[i-1][0] + (map[i][0] > 0 ? map[i][0] - i > 0 ? map[i][0]-i : 0 : 0);
        }
        int max = 0;
        for(int i=1; i<100; i++) {
            for (int j=1; j<100; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + (map[i][j]-(i+j) > 0 ? map[i][j]-(i+j) : 0);
                if(dp[i][j] > max)
                    max = dp[i][j];
            }
        }

        System.out.println(max);
    }

}
