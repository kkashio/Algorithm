import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 8. 14..
 */
public class Q10219 {
    static int h, w;
    static char grill[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t, i, j;
        char tmp;
        String input;
        t = sc.nextInt();
        while (t-- > 0) {
            /////input
            h = sc.nextInt();
            w = sc.nextInt();
            grill = new char[h][w];
            for (i = 0; i < h; i++) {
                input = sc.next();
                for (j = 0; j < w; j++) {
                    grill[i][j] = input.charAt(j);
                }
            }
            ////input

            for(i=0; i<h/2; i++){
                for(j=0; j<w; j++){
                    tmp = grill[i][j];
                    grill[i][j] = grill[h-i-1][j];
                    grill[h-i-1][j] = tmp;
                }
            }
            for(i=0;i<h;i++) {
                for (j = 0; j < w; j++) {
                    System.out.print(grill[i][j]);
                }
                System.out.println();
            }
        }
    }
}
