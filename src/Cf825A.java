import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 17..
 */
public class Cf825A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();
        int count = 0;
        String str = "";

        for(int i=0; i<n; i++){
            if(arr[i] == '0' && count == 0){
                str += '0';
                continue;
            }
            if(arr[i] == '0'){
                str += count;
                count = 0;
                continue;
            }
            count++;

            if(i==n-1) {
                str += count;
            }

        }

        System.out.println(str);
    }
}
