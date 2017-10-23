/**
 * Created by seongmin Park on 2017. 10. 7..
 * 카카오 페스티벌 예선전 5
 * 캠핑
 */
public class KakaoFestivalPre5 {
    public int solution(int n, int[][] data) {
        int answer = 0;
        //On^3는 시간초과이당
        int t,b,l,r;
        int[][] s = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                t = Math.min(data[i][0], data[j][0]);
                b = Math.max(data[i][0], data[j][0]);
                l = Math.min(data[i][1], data[j][1]);
                r = Math.max(data[i][1], data[j][1]);

            }

        }
        return answer;
    }



    public static void main(String[] args) {
        KakaoFestivalPre5 k = new KakaoFestivalPre5();
        int n = 4; int data[][] = {{0,0},{1,1},{0,2},{2,0}};
        System.out.println(k.solution(4,data));
    }
}
