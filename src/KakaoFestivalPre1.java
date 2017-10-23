import java.util.LinkedList;
import java.util.Queue;

//카카오 페스티벌 예선 문제 1
public class KakaoFestivalPre1 {
    public int[] solution(int m, int n, int[][] picture) {
        int[] my={0,1,0,-1}, mx={1,0,-1,0};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] == 0) continue;
                int color = picture[i][j];
                if(!visited[i][j]) {
                    q.offer(new Pair(i,j));
                    int size = -1;

                    while(!q.isEmpty()){
                        int cury = q.peek().y;
                        int curx = q.poll().x;
                        size++;
                        if(size > maxSizeOfOneArea)
                            maxSizeOfOneArea = size;

                        for(int k=0; k<4; k++) {
                            int ny = cury+my[k];
                            int nx = curx+mx[k];

                            if(ny < 0 || nx < 0 || ny > m-1 || nx > n-1) continue;
                            if(picture[ny][nx] != color) continue;
                            if(visited[ny][nx]) continue;

                            q.offer(new Pair(ny,nx));
                            visited[ny][nx] = true;
                        }
                    }
                    numberOfArea++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    class Pair {
        int x, y;
        public Pair(int y, int x){
            this.y=y;
            this.x=x;
        }
    }

    public static void main(String[] args) {
        KakaoFestivalPre1 kakaoFestivalPre1 = new KakaoFestivalPre1();
        int p[][] = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        kakaoFestivalPre1.print(p);
        int sol[] = kakaoFestivalPre1.solution(6,4, p);
        System.out.println(sol[0]+ " "+ sol[1]);
    }

    void print(int[][] g){
        for(int[] arr : g){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
