import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i]=sc.nextInt();

        boolean isAns = false;
        for(int i=n-1; i>0; i--){
            if(arr[i] > arr[i-1]){
                int min=987654321;
                int idx=0;
                for(int j=i; j<n; j++){
                    if(arr[j] < min && arr[j] > arr[i-1]) {
                        min = arr[j];
                        idx=j;
                    }
                }
                int tmp = arr[i-1];
                arr[i-1] = arr[idx];
                arr[idx] = tmp;

                Arrays.sort(arr,i,n);
                isAns = true;
                break;
            }
        }
        if(isAns)
            for (int a : arr)
                System.out.print(a+" ");
        else
            System.out.println(-1);
    }
}
