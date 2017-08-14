import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q2118 {
    static int n, dist[], sum, half,max;
    static Stack<Integer> stack;
    static Queue<Integer> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new int[n];
        stack = new Stack<>();
        queue = new LinkedList<>();
        int i, value;

        for (i = 0; i < n; i++)
            dist[i] = sc.nextInt();


        for (i = 0; i < n; i++) {
            sum += dist[i];
            queue.offer(i);
        }

        half = sum/2;
        value = sum;
        for(i=0; i<n; i++){
            while(value > half)
                value -= dist[queue.poll()];
            if(max < value)
                max=value;
            queue.offer(i);
            value+=dist[i];
        }

        System.out.println(max);
    }

}
