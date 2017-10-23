import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 23..
 */
public class Nhn4 {
    static int n, map[][], cnt, my[]={0,1,0,-1}, mx[]={1,0,-1,0};
    static boolean visited[][];
    static List<Integer> ans;
    static Queue<Pair> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        ans = new ArrayList<>();
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                map[i][j] = sc.nextInt();

        for(int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    ans.add(bfs(i, j));
                    cnt++;
                }
            }
        }

        Collections.sort(ans);
        System.out.println(cnt);
        if(ans.size()!=0){
            String ret = "";
            for(int num : ans)
                ret += num+" ";
            System.out.println(ret.trim());
        }

    }

    static int bfs(int y, int x){
        int nx, ny, ret=1;
        queue = new LinkedList<>();
        queue.offer(new Pair(y,x,1));
        while(!queue.isEmpty()){
            int curx = queue.peek().x;
            int cury = queue.peek().y;
            int size = queue.poll().s;

            for(int i=0; i<4; i++){
                nx=curx+mx[i];
                ny=cury+my[i];
                if(nx < 0 || ny < 0 || nx > n-1 || ny > n-1) continue;

                if(map[ny][nx]==1 && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new Pair(ny,nx,size+1));
                    ret++;
                }
            }
        }
        return ret;
    }

    static class Pair{
        int y,x,s;
        public Pair(int y, int x, int s){
            this.y=y;
            this.x=x;
            this.s=s;
        }
    }
}
