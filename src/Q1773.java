import java.util.Scanner;

/**
 * Created by PARK on 2017-02-18.
 */
public class Q1773 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int c = s.nextInt();
        int[] arr = new int[n];
        boolean[] check = new boolean[c+1];
        int result = 0;

        for(int i=0; i<arr.length; i++) {
            arr[i] = s.nextInt();
        }

        for(int i=0; i<arr.length; i++){
            for(int j=1; j<=c; j++){
                if(j%arr[i] == 0){
                    check[j] = true;
                }
            }
        }

        for(boolean count : check){
            if(count) result++;
        }
        System.out.println(result);

    }
}
