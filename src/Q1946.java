import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 20..
 */
public class Q1946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while(t-- !=0){
            int n = sc.nextInt();
            int arr[] = new int[n+1];
            int ans = n;
            for(int i=0; i<n; i++) {
                arr[sc.nextInt()] = sc.nextInt();
            }
            int min = 999999999;
            for(int i=1; i<n+1; i++){
                if(min < arr[i])
                    ans--;
                if(arr[i] < min)
                    min = arr[i];
            }
            System.out.println(ans);
        }
    }
}
