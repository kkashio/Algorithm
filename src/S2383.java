import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 16..
 * n번 사람이 어떤 계단을 선택할 것이냐? 가 문제의 핵심이군
 * 계단은 반드시 2개
 */
public class S2383 {
    static int n, map[][], min, peopleCnt;
    static List<Integer> peoples;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(), tc=0;
        while(tc++<t){
            n = sc.nextInt();
            map = new int[n][n];
            min = Integer.MAX_VALUE;
            peopleCnt = 0;
            int i,j,v;
            for(i=0; i<n; i++){
                for(j=0; j<n; j++){
                    v = sc.nextInt();
                    map[i][j] = v;
                    if(v==1) {
                        peopleCnt++;
                        peoples.add(i*n+j);
                    }
                }
            }

            int bit = (1<<peopleCnt);
            List<Integer> 계단1 = new ArrayList<>();
            List<Integer> 계단2 = new ArrayList<>();
            for(i=0; i<bit; i++){



                for(j=0; j<peopleCnt; j++){
                    int people = peoples.get(j);

                    if((i & (1<<j))>0){ // n번째가 켜져있음
                        계단1.add(people);
                    } else {
                        계단2.add(people);
                    }
                }
                가자점심(계단1, 계단2);
            }

            System.out.printf("#%d %d",tc,min);
        }
    }
    static void 가자점심(List 계단1, List 계단2){

    }


    static int dist(int s, int e){
        return Math.abs((s/n)-(e/n))+Math.abs((s%n)-(e%n));
    }
}
