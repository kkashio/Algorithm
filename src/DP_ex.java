import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Je.vinci.Inc. on 2017. 3. 28..
 */
public class DP_ex {
    static int INF = 9999999;
    static int[][] graph = {{0,1500,700,600,INF},
                            {1500,0,600,2000,1700},
                            {700,600,0,1000,600},
                            {600,2000,1000,0,500},
                            {INF,1700,600,500,0}};
    static int[] last = {0,1700,600,500,0};

    public static void main(String[] args) {
        int sum = 0;
        boolean[] check = new boolean[5];
        Stack<Integer> stack = new Stack<>();




        for(int i=0; i<3; i++){
            sum += graph[i][1];
        }
    }
}
