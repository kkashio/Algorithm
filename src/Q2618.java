import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 3..
 */
public class Q2618 {

    static int n,min=99999999,w;
    static int[] car1,car2;
    static int[][] event;

    /**
     * D(i,j) 는 두대의 경찰차가 사건 i , j에 위치한다는 뜻 i > j
     * D(i,j) = min(D(i-1,j) + dist(i,i+1), D(j,k)+dist(k,i)) 단 j > k
     * D(w,i) i는 유효한 정수
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        car1 = new int[]{0,0};
        car2 = new int[]{n,n};
        w = sc.nextInt();
        event = new int[w][2];

        for(int i=0; i<w; i++){
            event[i][0] = sc.nextInt();
            event[i][1] = sc.nextInt();
        }



    }

    static int D(int i, int j){
        //return min(D(i-1,j) + dist(i,i+1), D(j,i));
        return 0;
    }

    static int dist(int a, int b){
        return Math.abs(event[a][0] - event[b][0]) + Math.abs(event[a][1] - event[b][1]);
    }
}
