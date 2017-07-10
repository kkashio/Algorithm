import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 10..
 */
public class Q11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, max=0, dp[], arr[];

        n = sc.nextInt();
        arr = new int[n];
        dp = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int i=0; i<n; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
        }

        int ans = 0;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
