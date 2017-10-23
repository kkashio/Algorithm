import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M5 {
    static int n,m,arr[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr=new int[n];
        int p;
        int e;
        for(int i=0; i<m; i++){
            p=sc.nextInt();
            for(int j=0; j<p; j++){
                e=sc.next().charAt(0)-65;
                arr[i]+=(1<<e);
            }
        }

        for(int i=1; i<m; i++){
            for(int j=0; j<i; j++) {
//                while () {
//
//                }
            }
        }


    }
}
