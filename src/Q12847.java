import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 2..
 */
public class Q12847 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //init
        int n = scan.nextInt();
        int m = scan.nextInt();

        int salary[] = new int[n];

        for(int i=0; i<n; i++){
            salary[i] = scan.nextInt();
        }

        //algorithm
        //m길이의 연속된 값의 합이 최대가 되는 값

        long total_salary = 0;

        for(int i=0; i<m; i++){
            total_salary += salary[i];
        }

        long max_total_salary = total_salary;

        for(int i=m; i<n; i++){
            total_salary -= salary[i-m];
            total_salary += salary[i];

            if(total_salary > max_total_salary){
                max_total_salary = total_salary;
            }
        }
        System.out.println(max_total_salary);
    }
}
