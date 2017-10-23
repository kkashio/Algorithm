import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 25..
 */
class S1249 {
    static int n, map[][], dist[][], dx[]={1,0,-1,0}, dy[]={0,1,0,-1};
    static final int INF = Integer.MAX_VALUE-1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(),tc=0,ans=0;

        String input;
        while (tc++<t){
            n=sc.nextInt();
            map=new int[n][n];
            dist = new int[n][n];
            for(int i=0; i<n; i++)
                for (int j=0; j<n; j++)
                    dist[i][j]=INF;
            for(int i=0; i<n; i++){
                input=sc.next();
                for(int j=0; j<n; j++){
                    map[i][j] = input.charAt(j)-48;
                }
            }

            dijkstra();
            System.out.format("#%d %d\n",tc,dist[n-1][n-1]);
        }
    }

    static private void dijkstra(){
        Queue<Pair> queue = new LinkedList<>();
        dist[0][0] = 0;
        queue.offer(new Pair(0,0,0));
        int nx,ny,nsum;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            for(int i=0; i<4; i++){
                ny = curr.y + dy[i];
                nx = curr.x + dx[i];
                if(nx<0||ny<0||nx>n-1||ny>n-1) continue;
                nsum = curr.sum + map[ny][nx];
                if(nsum < dist[ny][nx]){
                    dist[ny][nx] = nsum;
                    queue.offer(new Pair(ny,nx,nsum));
                }
            }
        }
    }

    static class Pair{
        int y,x,sum;
        public Pair(int y, int x, int sum){
            this.y=y;
            this.x=x;
            this.sum=sum;
        }
    }
}
