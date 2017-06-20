import java.util.Scanner;
import java.util.Stack;

/**
 * Created by seongmin Park on 2017. 6. 9..
 */
public class Q1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> s = new Stack<>();

        int[] arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int num = 1;

        s.push(num);
        System.out.println("+");

        for(int i=0; i<n; i++) {
            while (num < arr[i]) {
                s.push(num++);
                System.out.println("+");
            }
            if (s.peek() == arr[i]) {
                s.pop();
                System.out.println("-");
            }
        }

    }
}
