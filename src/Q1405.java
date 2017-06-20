import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 16..
 */
public class Q1405 {
    static int n;
    static int[][] map = new int[35][35];
    static double sum = 0.0;
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    static double[] pros = new double[4];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i=0; i<4; i++)
            pros[i] = sc.nextDouble()*0.01;

        map[16][16] = 0;

        dfs(n,16,16, 1.0);

        System.out.println(1-sum);
    }

    static void dfs(int count, int x, int y, double pro){
        if(map[x][y] == 1){ //단순하지 않을 경우
            sum += pro;
            return;
        }

        if(count == 0){ //카운터가 끝났을 경우
            return;
        }

        map[x][y] = 1;

        for(int i=0; i<4; i++){
            dfs(count-1,x+move[i][0],y+move[i][1], pro*pros[i]);
        }

        map[x][y] = 0;

    }
}
