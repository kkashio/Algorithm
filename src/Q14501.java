import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by seongmin Park on 2017. 6. 5..
 */
public class Q14501 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;

        for(int i=1; i<n; i++){

        }

        int[] sum_arr = new int[n];
        int a = 0;
        while(!stack.isEmpty()){
            a = stack.pop();
            if(a+arr[a][0] > n)
                continue;
            sum_arr[a] = arr[a][1];
            for(int j=a+1; j<a+arr[a][0]; j++){
                sum_arr[j] = -1;
            }
        }
        int total = 0;
        for(int b : sum_arr){
            if(b == -1)
                continue;
            total += b;
        }
        System.out.println(total);
    }
}
