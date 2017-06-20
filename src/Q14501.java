import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 5..
 * DP 문제
 * N일까지 최대 가치를 구하는 문제
 */
public class Q14501 {

    static int N;
    static int[] T;
    static int[] P;
    static int max_cost;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        N = scan.nextInt();
        T = new int[N+1];
        P = new int[N+1];
        for(int i=1; i<=N; i++){
            T[i] =scan.nextInt();
            P[i] =scan.nextInt();
        }
        max_cost = 0;

        DFS(1,0);

        System.out.println(max_cost);

    }

    private static void DFS(int d, int sum){
        if(d == N + 1){
            max_cost = Math.max(max_cost, sum);
            return;
        }

        if(d + T[d] <= N + 1)
            DFS(d+T[d], sum + P[d]);
        if(d + 1 <= N + 1)
            DFS(d+1, sum);
    }
}
