import java.util.*;

/**
 * Created by seongmin Park on 2017. 7. 28..
 */
public class Q2206 {
    static int map[][], n, m, move[][] = {{-1,0},{0,-1},{0,1},{1,0}}, min = 987654321, wallCnt;
    static Queue<Pair> queue;
    static List<Pair> walls;
    static boolean visit[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        String input;
        map = new int[n][m];
        walls = new ArrayList<>();

        //초기화 및 벽 리스트 추가
        for(int i=0; i<n; i++){
            input = sc.next();
            for(int j=0; j<m; j++){
                map[i][j] = Character.getNumericValue(input.charAt(j));
                if(map[i][j] == 1){
                    walls.add(new Pair(i,j));
                }
            }
        }

        int wallsSize = walls.size();
        queue = new LinkedList<>();

        //벽 리스트를 토대로 맵을 바꾸어주어 bfs돌리기
        if(wallsSize != 0){
            for(int i=0; i<wallsSize; i++){
                Pair pair = walls.get(i);
                if(i>0){
                    map[walls.get(i-1).col][walls.get(i-1).row] = 1;
                }
                map[pair.col][pair.row] = 0;
                visit = new boolean[n][m];
                visit[0][0] = true;
                queue.offer(new Pair(0,0, 1));
                bfs();
            }
        } else {
            queue = new LinkedList<>();
            queue.offer(new Pair(0,0, 1));
            bfs();
        }

        if(min == 987654321)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void bfs(){
        int nR, nC;

        while(!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int cnt = queue.peek().cnt;
            queue.poll();

            if(col == n-1 && row == m-1){
                if(cnt < min) {
                    min = cnt;
                    continue;
                }
            }

            for(int i=0; i<4; i++){
                nC = col + move[i][0];
                nR = row + move[i][1];

                if(nC >= n || nC <0 || nR >= m || nR < 0 || visit[nC][nR]) continue;

                if(map[nC][nR] != 1){
                    queue.offer(new Pair(nC,nR,cnt+1));
                    visit[nC][nR] = true;
                }
            }
        }
    }

    static class Pair{
        int col;
        int row;
        int cnt;

        public Pair(int col, int row, int cnt){
            this.col = col;
            this.row = row;
            this.cnt = cnt;
        }

        public Pair(int col, int row){
            this.col = col;
            this.row = row;
        }

    }
}
