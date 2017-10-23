/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoFestivalPre6 {
    public static void main(String[] args) {
        KakaoFestivalPre6 k = new KakaoFestivalPre6();
        String[] board = {"TTTT","TTTT","TTTT","TTTT"};

        System.out.println(k.solution(4,4, board));
    }
    char[][] map;
    boolean[][] visited;
    public int solution(int m, int n, String[] board) {
        int i,j,answer = 0;
        map = new char[m][n];

        for(i=0; i<m; i++)
            map[i] = board[i].toCharArray();

        boolean flag = true;
        while(flag){
            print();
            visited = new boolean[m][n];
            for(i=0; i<m-1; i++){
                for(j=0; j<n-1; j++){
                    //좌상,좌하,우상,우하
                    char std = map[i][j];
                    if(map[i][j]=='*') continue;
                    if(map[i][j]==map[i-1][j-1] && map[i][j]==map[i][j-1] && map[i][j]==map[i-1][j]){
                        visited[i][j] = true;
                        visited[i-1][j] = true;
                        visited[i][j-1] = true;
                        visited[i-1][j-1] = true;
                    }
                    else if (map[i][j]==map[i+1][j-1] && map[i][j]==map[i][j-1] && map[i][j]==map[i+1][j]){
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j-1] = true;
                        visited[i+1][j-1] = true;
                    }
                    else if (map[i][j]==map[i-1][j+1] && map[i][j]==map[i][j+1] && map[i][j]==map[i-1][j]){
                        visited[i][j] = true;
                        visited[i][j+1] = true;
                        visited[i-1][j] = true;
                        visited[i-1][j+1] = true;
                    }
                    else if (map[i][j]==map[i+1][j+1] && map[i][j]==map[i][j+1] && map[i][j]==map[i+1][j]){
                        visited[i][j] = true;
                        visited[i+1][j] = true;
                        visited[i][j+1] = true;
                        visited[i+1][j+1] = true;
                    }
                }
            }
            //터트리고 맵 새로 만들기
            flag = false;
            for(i=0; i<m; i++){
                for(j=0; j<n; j++){
                    if(visited[i][j]){
                        map[i][j] = '*';
                        flag=true;
                    }
                }
            }
            print();
            for(j=0; j<n; j++) {
                int tmp = 0;
                for (i = m - 1; i >= 0; i--) {
                    if(map[i][j]=='*')
                        tmp++;
                    else if(tmp!=0) {
                        map[i + tmp][j] = map[i][j];
                        map[i][j] = '*';
                    }
                }
            }

        }
        for(char[] carr : map)
            for (char ch : carr)
                if(ch=='*') answer++;
        return answer;
    }

    void print(){
        for(char[] arr : map){
            for(char ch : arr){
                System.out.print(ch+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
