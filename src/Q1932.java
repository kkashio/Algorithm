import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 18..
 */
public class Q1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] tree = new int[n][n];
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<=i; j++)
                tree[i][j] = sc.nextInt();

    }
}
