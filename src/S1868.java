import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 16..
 */
public class S1868 {
    static int n, numBoard[][], dx[]={1,1,1,0,-1,-1,-1,0}, dy[]={-1,0,1,1,1,0,-1,-1}, ans;
    static char[][] board;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(), tc=0;
        while(tc++<t){
            ans = 0;
            int i,j;
            n=sc.nextInt();
            board = new char[n][n];
            numBoard = new int[n][n];
            visited = new boolean[n][n];
            String in;
            for(i=0; i<n; i++){
                in = sc.next();
                board[i] = in.toCharArray();
            }


            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(board[i][j]=='*')
                        numBoard[i][j]=-1;
                    else {
                        numBoard[i][j]=findMine(i,j);
                    }
                }
            }

            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(numBoard[i][j]==0 && !visited[i][j]){
                        visited[i][j] = true;
                        ans++;
                        dfs(i,j);
                    }
                }
            }

            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    if(!visited[i][j] && numBoard[i][j] > -1){
                        ans++;
                    }
                }
            }
            System.out.printf("#%d %d\n", tc, ans);
        }

    }

    static int findMine(int y, int x){
        int cnt = 0, nx, ny;
        for(int i=0; i<8; i++){
            ny = dy[i]+y;
            nx = dx[i]+x;
            if(ny > n-1 || nx > n-1 || ny < 0 || nx < 0) continue;
            if(board[ny][nx]=='*')
                cnt++;
        }
        return cnt;
    }

    static void dfs(int y, int x){
        int ny, nx;
        for(int i=0; i<8; i++){
            ny = dy[i]+y;
            nx = dx[i]+x;
            if(ny > n-1 || nx > n-1 || ny < 0 || nx < 0) continue;
            if(visited[ny][nx]) continue;
            if(numBoard[ny][nx] > 0) {
                visited[ny][nx] = true;
                continue;
            }
            if(numBoard[ny][nx] == 0) {
                visited[ny][nx] = true;
                dfs(ny,nx);
            }
        }
    }
}
