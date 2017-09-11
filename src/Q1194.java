import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 7..
 */
public class Q1194 {
    static int n,m;
    static int mx[]={1,0,-1,0},my[]={0,1,0,-1};
    static char map[][];
    static boolean visit[][][], isEnd;
    static Queue<Pair> queue;
    static Map<Character, Boolean> key;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map=new char[n][m];
        key = new HashMap<>();
        String str;
        Pair start = null;
        for(int i=0; i<n; i++) {
            str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='0')
                    start=new Pair(i,j,0,0);
            }
        }

        visit = new boolean[51][51][(1<<7)];
        queue = new LinkedList<>();
        queue.offer(start);
        System.out.println(bfs());


    }

    static private int bfs(){
        int cy,cx,cs,cKey,ny,nx,nKey;

        while(!queue.isEmpty()){
            cy=queue.peek().y;
            cKey=queue.peek().key;
            cs=queue.peek().s;
            cx=queue.poll().x;
            if(map[cy][cx] == '1') {
                return cs;
            }

            for(int i=0; i<4; i++){
                ny=cy+my[i];
                nx=cx+mx[i];
                nKey = cKey;
                if(ny < 0 || nx < 0 || ny > n-1 || nx > m-1) continue;
                if(!visit[ny][nx][cKey]){
                    //대문자,소문자,벽
                    if(map[ny][nx] == '#') continue;
                    if(map[ny][nx] >= 'a'){
                        nKey |= 1<<(map[ny][nx]- 96);
                        visit[ny][nx][nKey] = true;
                        queue.offer(new Pair(ny,nx,nKey,cs+1));
                    } else if(map[ny][nx] >= 'A'){
                        visit[ny][nx][nKey] = true;
                        if((cKey & (1<<map[ny][nx]-64)) == 0)
                            continue;
                        else {
                            queue.offer(new Pair(ny,nx,nKey,cs+1));
                        }
                    } else {
                        visit[ny][nx][nKey] = true;
                        queue.offer(new Pair(ny,nx,nKey,cs+1));
                    }
                }

            }
        }
        return -1;
    }

    private static class Pair{
        int x,y,key,s;
        public Pair(int y, int x, int key, int s){
            this.x=x;
            this.y=y;
            this.key=key;
            this.s = s;
        }
    }
}
