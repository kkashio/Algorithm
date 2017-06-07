import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 7..
 */
public class Q2573 {

    static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] arr;
    static int n,m,count;
    static int[][] visited;


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //빙산녹이기 두대륙인지아닌지
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for (int j = 0; j<m; j++) {
                arr[i][j] = scan.nextInt();
            }
        }
        int year = 0;
        while(!check()){
            if(zero_check()){
                year = 0;
                break;
            }
            //해빙
            year++;
            arr = thawing();
        }

        System.out.println(year);

    }

    static int[][] thawing(){
        int[][] copy = new int[n][m];
        for(int i=0; i<n; i++) {
            System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] > 0){
                    int near_seq = 0;
                    for(int a = 0; a<4; a++) {
                        int nextX = i+move[a][0];
                        int nextY = j+move[a][1];
                        if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                            if(arr[nextX][nextY] == 0)
                                near_seq++;
                        }
                    }
                    if(copy[i][j] - near_seq < 0){
                        copy[i][j] = 0;
                    } else {
                        copy[i][j] -= near_seq;
                    }
                }
            }
        }
        return copy;
    }
    static boolean zero_check(){
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                if(arr[i][j] != 0)
                    return false;
        return true;
    }

    static boolean check(){
        visited = new int[n][m];
        count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] > 0 && visited[i][j] == 0){
                    DFS(i,j);
                    count++;
                }
            }
        }
        if(count >= 2)
            return true;

        return false;
    }

    static void DFS(int i, int j){
        int nextX, nextY;
        visited[i][j] = 1;
        for(int a=0; a<4; a++){
            nextX = i+move[a][0];
            nextY = j+move[a][1];

            if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                if(arr[nextX][nextY] > 0 && visited[nextX][nextY] == 0){
                    DFS(nextX,nextY);
                }
            }
        }

    }
}
