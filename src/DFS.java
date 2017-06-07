import java.util.Stack;

/**
 * Created by Je.vinci.Inc. on 2017. 3. 28..
 */
public class DFS {
    static int nE;
    static int nV;
    static boolean[] visit;
    static int INF = 999999999;
    static int[][] map = {{0,1500,700,600},
            {1500,0,600,2000},
            {700,600,0,1000},
            {600,2000,1000,0}};
    static int[] last = {0,1700,600,500,0};


    public static void main(String[] args) {
        nV = 4;  //정점 수
        nE = 6;  //간선 수

        Stack<Integer> stack = new Stack<>();

        int sum;

        for(int i=1; i<4; i++){
            sum = map[0][i];
            visit = new boolean[nV];
            dfs(i,sum);
            System.out.println("-------------------------");
        }

//        for(int i=0; i<4; i++){
//            sum = 0;
//            visit = new boolean[nV];
//            dfs2(i,sum,stack);
//            System.out.println();
//        }

    }

    public static void dfs2(int v, int sum, Stack<Integer> stack){
        stack.push(v);
        visit[v] =true;
        for(int i=1; i<=nV; i++){

        }

    }


    public static void dfs(int v, int sum){
        visit[v-1] = true;
        for(int i=1; i<nV; i++){
            if(map[v-1][i-1] > 0 && !visit[i-1]){
                sum += map[v-1][i-1];
                System.out.println(v + "->" + i);
                System.out.println(sum + map[v-1][i-1]);
                dfs(i,sum);
                sum -= map[v-1][i-1];
            }
        }
        System.out.println();
        visit[v-1] = false;
    }
}
