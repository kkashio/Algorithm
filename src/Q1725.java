import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Je.vinci.Inc. on 2017. 4. 6..
 */
public class Q1725 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = scan.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i<n; i++){
            int left = i;
            while(!stack.empty() && arr[stack.peek()] > arr[i]){
                int height = arr[stack.peek()];
                stack.pop();
                int width = i;
                if(!stack.empty()){
                    width = (i-stack.peek() - 1);
                }
                if(ans < width*height){
                    ans = width*height;
                }
            }
            stack.push(i);
        }

        while(!stack.empty()){
            int height = arr[stack.peek()];
            stack.pop();
            int width = n;
            if(!stack.empty()){
                width = n-stack.peek()-1;
            }
            if(ans < width*height){
                ans = width*height;
            }
        }

        System.out.println(ans);

    }
}
