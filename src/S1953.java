import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 탈주범 검거
 */
public class S1953 {
    static int n,m,r,c,l,map[][], dy1[]={0,1,0,-1}, dx1[]={1,0,-1,0}, dy[][]={{1,-1},{0,0},{0,-1},{0,1},{1,0},{0,-1}}, dx[][]={{0,0},{1,-1},{1,0},{1,0},{0,-1},{-1,0}};
    static boolean visited[][];
    static Queue<Pair> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), tc = 0;
        while(tc++<t){
            n=sc.nextInt(); m=sc.nextInt(); r=sc.nextInt(); c=sc.nextInt(); l=sc.nextInt();
            map=new int[n][m];
            visited=new boolean[n][m];
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    map[i][j]=sc.nextInt();

            System.out.printf("#%d %d\n",tc,bfs());
        }
    }

    static int bfs() {
        queue = new LinkedList<>();
        queue.offer(new Pair(r, c, 1));
        visited[r][c] = true;
        int ny, nx, type;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (curr.len == l) continue;
            type = map[curr.y][curr.x];
            if (type == 1) {
                for (int i = 0; i < 4; i++) {
                    ny = curr.y + dy1[i];
                    nx = curr.x + dx1[i];
                    ckPipe(ny, nx, curr);
                }
            } else {
                for (int i = 0; i < 2; i++) {
                    ny = curr.y + dy[type - 2][i];
                    nx = curr.x + dx[type - 2][i];
                    ckPipe(ny, nx, curr);
                }
            }
        }
        int cnt=0;
        for (boolean[] brr : visited){
            for (boolean b : brr) {
                if(b) cnt++;
            }
        }
        return cnt;
    }

    static void ckPipe(int y, int x, Pair pre){
        if(y < 0 || x < 0 || y > n-1 || x > m-1) return;
        int ny,nx;
        boolean flag=false;
        int type = map[y][x];
        if(type==0) return;
        if(type!=1){
            for (int i = 0; i < 2; i++) {
                ny = y + dy[type - 2][i];
                nx = x + dx[type - 2][i];
                if(ny < 0 || nx <0 || ny > n-1 || nx > m-1) continue;
                if(pre.y==ny && pre.x==nx) {
                    flag=true;
                    break;
                }
            }
        } else flag=true;
        int len = pre.len;
        if(!visited[y][x] && flag){
            visited[y][x] = true;
            queue.offer(new Pair(y,x,len+1));
        }
    }


    static class Pair{
        int y,x,len;
        public Pair(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }

}
