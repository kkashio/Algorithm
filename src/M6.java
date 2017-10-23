import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M6 {
    static char[] collect= {'a','e','i','o','u'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[] arr = new char[m];
        int coll=0,con=0;
        char curr;
        for(int i=0; i<m; i++){
            curr=sc.next().charAt(0);
            curr = Character.toLowerCase(curr);
            if(isColl(curr))
                coll++;
            else
                con++;
        }
        int sum =0;
        for(int i=1; i<=coll && n-i > 1; i++){
            sum+=nCk(coll,i)+nCk(con,n-i);
        }
        //(2C1 + 4C4) + (2C2 + 4C3) 줄세우는 경우의수
        System.out.println(sum);


    }

    static int nCk(int a, int b){
        int num = 1;
        int den = 1;
        int k = Math.min(a-b, b);
        for(int i=1; i<k+1; i++){
            den *= i;
            num *= a+1-i;
        }
        return num/den;
    }

    static boolean isColl(char c){
        for(int i=0; i<5; i++)
            if(collect[i]==c)
                return true;
        return false;
    }
}
