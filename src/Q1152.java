import java.util.Scanner;

/**
 * Created by Je.vinci.Inc. on 2017. 2. 28..
 */
public class Q1152 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = 1;
        String str = scan.nextLine();

        str = str.trim();
        if(str.length() == 0) {
            count = 0;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' '){
                    count ++;
                }
            }
        }

        System.out.println(count);
    }
}
