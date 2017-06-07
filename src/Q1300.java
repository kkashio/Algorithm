import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 7..
 */
public class Q1300 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        int left = 1, right = k, ans = 0;

        while(left <= right){
            long cnt = 0;
            int mid = (left+right) / 2;
            for(int i=1; i<=n; i++){
                cnt += Math.min(mid/i,n);
            }
            if(cnt<k) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
