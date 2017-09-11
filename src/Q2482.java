import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 9..
 */
public class Q2482 {
    static int n,k,memo[][][] = new int[1001][1001][2],MOD=1000000003;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        k=sc.nextInt();

        for(int i=0; i<n; i++)
            for(int j=0; j<k; j++)
                memo[i][j][0] = memo[i][j][1] = -1;


        int sum=0;
        if(n < 2*k){
            System.out.println(0);
        } else if(n==2*k) {
            System.out.println(2);
        } else {
            sum = sol(0,0,0);
            System.out.println(sum%MOD);
        }
        //dp 문제 선택하냐 안하냐 그것이 문제로다
        //sol(i,cnt,first) = (sol(i+1,cnt,first) + sol(i+2,cnt+1,first))%MOD
    }

    static private int sol(int i, int cnt, int first){
        if(cnt == k) return 1;
        if(i>=n) return 0;

        int ret = memo[i][cnt][first];
        if(ret!=-1) return ret;
        ret = 0;

        if(i==n-1){
            if(first==1) return 0;

            ret = (sol(i+2,cnt+1,first)+sol(i+1,cnt,first))%MOD;
            memo[i][cnt][first] = ret;
            return ret;
        }

        if(i==0) ret = (ret + sol(i+2,cnt+1,1))%MOD;
        else ret = (ret + sol(i+2, cnt+1, first))%MOD;

        if(i==0) ret = (ret + sol(i+1, cnt, 0))%MOD;
        else ret = (ret + sol(i+1,cnt,first))%MOD;

        memo[i][cnt][first] = ret;
        return ret;
    }
}
