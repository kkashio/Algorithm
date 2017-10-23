import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 23..
 */
public class Nhn2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        String priKey = sc.next();
        int rotation = sc.nextInt();
        String value = sc.next();
        String ans = "";
        String ret = "";
        int size = value.length();
        if(command.equals("encrypt")){
            for(int i=0; i<size; i++){
                int ch = (char)(value.charAt(i) + priKey.charAt(i) - 97);
                if(ch > 122){
                    ch = (ch%123) + 97;
                }
                ans += (char) ch;
            }
            int next = rotation-1;
            for(int i=0; i<size; i++){
                if(next < 0)
                    next = size-1;
                ret = ans.charAt(next) + ret;
                next--;
            }
            System.out.println(ret);
        } else {
            int next = rotation -1;
            for(int i=0; i<size; i++){
                next %=size;
                ret += value.charAt(next);
                next++;
            }

            for(int i=0; i<size; i++){
                int ch = ret.charAt(i) - (priKey.charAt(i) - 97);
                if(ch < 97){
                    ch = ch + 26;
                }
                ans += (char) ch;
            }
            System.out.println(ans);
        }
    }
}
