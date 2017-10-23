import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 28..
 * 등산로조정
 */
public class S1949 {
    static int n,k,map[][],ans, dx[] = {1,0,-1,0}, dy[]={0,1,0,-1};
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(), tc=0;
        while(tc++<t){
            int max = 0;
            ans = 0;
            n=sc.nextInt(); k=sc.nextInt();
            map = new int[n][n];
            visited = new boolean[n][n];
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    map[i][j] = sc.nextInt();
                    if(map[i][j] > max)
                        max = map[i][j];
                }
            }
            for(int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if(max == map[i][j]) {
                        visited[i][j] = true;
                        dfs(i, j, 1, false);
                        visited[i][j] = false;
                    }
                }
            }
            System.out.printf("#%d %d\n",tc,ans);
        }
    }

    static void dfs(int y, int x, int len, boolean dig){
        int nx, ny, tmp;
        for(int i=0; i<4; i++){
            ny = dy[i] + y;
            nx = dx[i] + x;
            if(ny > n-1 || nx > n-1 || ny < 0 || nx < 0) continue;
            if(visited[ny][nx]) continue;
            if(map[y][x] > map[ny][nx]){
                visited[ny][nx] = true;
                dfs(ny,nx,len+1,dig);
                visited[ny][nx] = false;
            } else if(map[ny][nx]-map[y][x] < k && !dig){
                dig = true;
                tmp = map[ny][nx];
                visited[ny][nx] = true;
                map[ny][nx] = map[y][x] - 1;
                dfs(ny,nx,len+1,dig);
                map[ny][nx] = tmp;
                visited[ny][nx] = false;
                dig = false;
            }
        }
        if(len > ans)
            ans = len;
    }
}
