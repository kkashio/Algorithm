import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 14..
 */
public class Q6118 {
    static int n, m, dist[][], map[][], INF = 987654321;
    static boolean visit[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n+1][n+1];
        dist = new int[n+1][n+1];
        visit= new boolean[n+1];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                dist[i][j] = INF;
            }
        }
        for(int i=0; i<m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            dist[x][y] = 1;
            dist[y][x] = 1;
        }


    }
}
