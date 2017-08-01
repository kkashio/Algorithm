import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 25..
 */
public class Q2146 {
    static int n, map[][], copyMap[][], bridge[][], landCnt, move[][] = {{-1,0},{0,-1},{0,1},{1,0}}, min = 10000;
    static Queue<Pair<Integer,Integer>> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        queue = new LinkedList<>();
        n = sc.nextInt();
        map = new int[n][n];
        copyMap = new int[n][n];
        bridge = new int[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        landCnt = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && copyMap[i][j] == 0)
                    dfs(i,j,landCnt++);
            }
        }

        for(int i=1; i<landCnt; i++){
            bfs(i);
        }



        System.out.println(min);
    }

    static void dfs(int y, int x, int cnt ){
        int nextX, nextY;

        while(!queue.isEmpty()) queue.poll();

        queue.offer(new Pair<>(y,x));
        copyMap[y][x] = cnt;

        while (!queue.isEmpty()){
            y = queue.peek().first;
            x = queue.peek().second;
            queue.poll();

            for(int i=0; i<4; i++){
                nextY = y + move[i][0];
                nextX = x + move[i][1];

                if(nextY >= n || nextY < 0 || nextX >= n || nextX < 0) continue;

                if(map[nextY][nextX] == 1 && copyMap[nextY][nextX] == 0){
                    queue.offer(new Pair<>(nextY, nextX));
                    copyMap[nextY][nextX] = cnt;
                }
            }
        }
    }

    static void bfs(int num){
        int nextX, nextY;

        init();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(copyMap[i][j] == num){
                    for(int k=0; k<4; k++){
                        nextY = i+move[k][0];
                        nextX = j+move[k][1];

                        if(nextY >= n || nextY < 0 || nextX >= n || nextX < 0) continue;
                        if(copyMap[nextY][nextX] == 0){
                            bridge[nextY][nextX] = 1;
                            queue.offer(new Pair<>(nextY,nextX));
                        }
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int y = queue.peek().first;
            int x = queue.peek().second;
            queue.poll();

            for(int i=0; i<4; i++){
                nextY = y + move[i][0];
                nextX = x + move[i][1];

                if(nextY >= n || nextY < 0 || nextX >= n || nextX < 0) continue;
                if(copyMap[nextY][nextX] > 0 && copyMap[nextY][nextX] != num){
                    if(bridge[y][x] < min){
                        min = bridge[y][x];
                        return;
                    }
                }
                if(copyMap[nextY][nextX] == 0 && bridge[nextY][nextX] == 0){
                    bridge[nextY][nextX] = bridge[y][x] + 1;
                    queue.offer(new Pair<>(nextY,nextX));
                }
            }
        }
    }

    static void init(){
        while(!queue.isEmpty()) queue.poll();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bridge[i][j] = 0;
            }
        }
    }

    static class Pair<A, B>{
        A first;
        B second;

        public Pair(A first, B second){
            this.first = first;
            this.second = second;
        }
    }
}


