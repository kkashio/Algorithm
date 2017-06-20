import java.util.Scanner;
import java.util.Stack;

/**
 * Created by seongmin Park on 2017. 6. 9..
 */
public class Q10828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            String command = sc.next();

            switch (command) {
                case "push" :
                    stack.push(sc.nextInt());
                    break;
                case "pop" :
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.pop());
                    break;
                case "size" :
                    System.out.println(stack.size());
                    break;
                case "empty" :
                    if(stack.isEmpty())
                        System.out.println(1);
                    else
                        System.out.println(0);
                    break;
                case "top" :
                    if(stack.isEmpty())
                        System.out.println(-1);
                    else
                        System.out.println(stack.peek());
                    break;
            }
        }
    }
}
