import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 8..
 * 삼성 연구소 문제
 * 백준 14502
 */
public class Q14502 {
    static int n,m,max_value;
    static int[][] map;
    static int[][] copy_map;
    static boolean[][] visited;
    static ArrayList<Node> virus;
    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] tmp;

    public static void main(String[] args) {
        //init & input
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        copy_map = new int[n][m];
        virus = new ArrayList<>();
        visited = new boolean[n][m];
        tmp = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                copy_map[i][j] = map[i][j];

                if(map[i][j] == 2)
                    virus.add(new Node(i,j));
            }
        }

        //algo
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] != 0) continue;
                DFS(i,j,1);
            }
        }

        System.out.println(max_value);

        for(int[] arr : tmp) {
            for (int i : arr){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
    //벽세우는 DFS
    static void DFS(int x, int y, int d){
        copy_map[x][y] = 1;
        visited[x][y] = true;

        if(d==3){
            //오염시작
            int[][] copy_map2 = new int[n][m];
            for(int i=0; i<n; i++) {
                System.arraycopy(copy_map[i],0,copy_map2[i],0,copy_map[i].length);
            }
            BFS();
            //max_value = Math.max(max_value, getCleanArea(copy_map2));
            int a = getCleanArea(copy_map2);
            if(max_value < a) {
                max_value = a;
                tmp = copy_map2;
            }

        } else {
            for (int i = x; i < n; i++) {
                for (int j = y; j < m; j++) {
                    if (visited[i][j] || copy_map[i][j] != 0) continue;
                    DFS(i, j, d + 1);
                }
            }
        }
        copy_map[x][y] = 0;
        visited[x][y] = false;
    }

    static void BFS(){
        Queue<Node> q = new LinkedList<>();

        for(int i = 0; i < virus.size(); i++) q.offer(virus.get(i));

        while(!q.isEmpty()){

            Node node = q.poll();

            for(int i = 0; i < 4; i++)
            {
                int nx = node.x + move[i][0];
                int ny = node.y + move[i][1];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n || copy_map[nx][ny] != 0) continue;

                copy_map[nx][ny] = 2;
                q.offer(new Node(nx, ny));
            }
        }
    }

    static int getCleanArea(int[][] prevMap){
        int count = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copy_map[i][j] == 0)
                    count++;
                copy_map[i][j] = prevMap[i][j];
            }
        }

        return count;
    }

    static class Node{
        int x;
        int y;

        public Node(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

}
