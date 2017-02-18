import java.util.Scanner;

/**
 * Created by PARK on 2017-02-16.
 */

/*
*  TEST CASE
*  <<BP<A>>Cd-
*  sol ) BAPC
* ThIsIsS3Cr3t
* sol ) ThIsIsS3Cr3t
*/

public class Q5397 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        String[] result = new String[testCase];
        
        for(int i=0; i<testCase; i++){
            StringBuffer sb = new StringBuffer();
            String input = scan.next();

            int point = 0;

            for(int j=0; j<input.length(); j++) {
                switch (input.charAt(j)) {
                    case '<':
                        if (point > 0) point--;
                        break;
                    case '>':
                        if (point < sb.length()) point++;
                        break;
                    case '-':
                        if (point > 0) {
                            sb.deleteCharAt(point - 1);
                            point--;
                        }
                        break;
                    default:
                        sb.insert(point, input.charAt(j));
                        point++;
                        break;
                }
            }
            result[i] = sb.toString();
        }
        
        for(String tmp: result){
            System.out.println(tmp);
        }
    }

}
