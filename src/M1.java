import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr=new int[m];
        int min = 987654321;
        for(int i=0; i<m; i++) {
            arr[i] = sc.nextInt();
            if(min>arr[i]){
                min = arr[i];
            }
        }

        min++;
        while(--min!=0){
            int cnt = 0;
            for(int i=0; i<m; i++){
                cnt += arr[i]/min;
            }
            if(cnt>=n)
                break;
        }
        System.out.println(min);
    }
}
