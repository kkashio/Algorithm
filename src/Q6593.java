import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 3..
 */
public class Q6593 {

    static int l=1,r=1,c=1, min=999999999;
    static char[][][] map;
    static int[][][] visit;
    static int[][] move = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}};
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        while(!(l==0 && r==0 && c==0)){
            flag = false;
            map = new char[l][r][c];
            visit = new int[l][r][c];
            int S[] = new int[3];
            for(int i=0; i<l; i++){
                for(int j=0; j<r; j++){
                    String str = sc.next();
                    map[i][j] = str.toCharArray();
                    for(int k=0; k<c; k++){
                        if(map[i][j][k] == 'S') {
                            S[0] = i; S[1] = j; S[2] = k;
                        }
                    }
                }
            }
            escape(S[0], S[1], S[2], 0);
            sc.nextLine();
            l = sc.nextInt();
            r = sc.nextInt();
            c = sc.nextInt();
        }
    }

    static void escape(int z, int y, int x, int count){
        if(map[z][y][x] == 'E') {
            flag = true;
            if(count < min)
                min = count;
            return;
        }

        visit[z][y][x] = 1;

        for(int i=0; i<6; i++){
            int nextZ = z+move[i][0];
            int nextY = y+move[i][1];
            int nextX = x+move[i][2];
            if(nextZ < 0 || nextZ >= l || nextY < 0 || nextY >= r || nextX < 0 || nextX >= c || visit[nextZ][nextY][nextX] == 1)
                continue;
            if(map[nextZ][nextY][nextX] == '#')
                continue;
            escape(nextZ,nextY,nextX,count+1);
        }

        if(map[z][y][x] == 'S'){
            if(flag){
                System.out.println("Escaped in "+min+" minute(s).");
            } else {
                System.out.println("Trapped!");
            }
            return;
        }

        visit[z][y][x] = 0;
    }
}
