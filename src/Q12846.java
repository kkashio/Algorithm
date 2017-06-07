import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 2..
 */
public class Q12846 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //init

        int n = scan.nextInt();
        int[] salary = new int[n];

        for(int i=0; i<n; i++){
            salary[i] = scan.nextInt();
        }

        //연속된 값들의 개수를 가장 작은 수로 곱했을때 최대 값을 구하라
        //제한시간 1초 n<10만 , 임금 100만 시간 복잡도 n제곱 까지 가능해보임

        int min_salary;
        int max_total_salary = 0;
        int total_salary;
        for(int i=0; i<n; i++){
            min_salary = 1000001;
            int day = 0;
            for(int j=i; j<n; j++){
                total_salary = 0;
                day++;

                if(salary[j]<min_salary){
                    min_salary = salary[j];
                }

                total_salary += day*min_salary;

                if(total_salary > max_total_salary){
                    max_total_salary = total_salary;
                }
            }
        }

        System.out.println(max_total_salary);

    }
}
