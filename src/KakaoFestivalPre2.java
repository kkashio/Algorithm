/**
 * Created by seongmin Park on 2017. 9. 12..
 */
public class KakaoFestivalPre2 {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] dp = new int[m+1][n+1];

        dp[1][1] = 1;
        for(int i=1; i<m; i++) {
            if(cityMap[i][0]==1)
                dp[i+1][1] = 0;
            else dp[i+1][1] = dp[i][1];
        }
        for(int i=1; i<n; i++) {
            if(cityMap[0][i]==1)
                dp[1][i+1] = 0;
            else dp[1][i+1] = dp[1][i];
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //0,1,2 경우의수
                if(cityMap[i][j] == 1) {
                    dp[i+1][j+1] = 0;
                    continue;
                }
                int a,b;
                int ny = cityMap[i-1][j];
                int nx = cityMap[i][j-1];
                int c = 1;
                while(ny == 2){
                    c++;
                    if(i<c)
                        break;
                    ny=cityMap[i-c][j];
                }
                a=dp[i-c+1][j+1]%MOD;
                c=1;
                while(nx == 2){
                    c++;
                    if(j<c)
                        break;
                    nx=cityMap[i][j-c];
                }
                b=dp[i+1][j-c+1]%MOD;

                dp[i+1][j+1] = (a+b)%MOD;
            }
        }
        answer = dp[m][n]%MOD;

        //print(dp);
        return answer;
    }

    public static void main(String[] args) {
        KakaoFestivalPre2 k = new KakaoFestivalPre2();
        int[][] map = {{0,0,0,0},{0,2,2,0},{0,2,2,0},{0,0,0,0}};
        int[][] map2 = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] map3 = {{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}};

        System.out.println(k.solution(4,4, map));
        System.out.println(k.solution(3,3,map2));
        System.out.println(k.solution(3,6,map3));
    }

    void print(int[][] p){
        for (int[] arr : p){
            for(int z : arr){
                System.out.print(z+" ");
            }
            System.out.println();
        }
    }
}
