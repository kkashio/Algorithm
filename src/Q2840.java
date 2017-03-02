import java.util.Scanner;

/**
 * Created by Je.vinci.Inc. on 2017. 2. 23..
 */
public class Q2840 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] s = new int[k];
        char[] c = new char[k];
        int point = 0;
        char[] arr = new char[n];



        for(int i=0; i<n; i++){
            arr[i] = '!';
        }

        for(int i=0; i<k; i++){
            s[i] = scan.nextInt();
            c[i] = scan.next().charAt(0);
        }

        for(int i=0; i<k; i++){
            if(arr[point] == '!')
                arr[point] = c[k-i-1];
            else
                arr[point] = '?';

            point += s[k-i-1];
            if(point >= n) {
                point = point % n;
            }
        }
        for(char a : arr)
            System.out.print(a);
    }
}

