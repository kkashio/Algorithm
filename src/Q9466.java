import java.util.Scanner;
import java.util.Stack;

public class Q9466 {
    static int graph[],n,cycle;
    static boolean visited[],set[];
    static Stack<Integer> stack;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            graph = new int[n];
            set = new boolean[n];
            stack = new Stack<>();
            for(int i=0; i<n; i++)
                graph[i]=sc.nextInt()-1;

            for(int i=0; i<n; i++) {
                cycle = i;
                visited = new boolean[n];
                if(!set[i]) {
                    visited[i]=true;
                    stack.push(i);
                    dfs(i);
                    visited[i]=false;
                    stack.removeAllElements();
                }
            }
            int cnt = 0;
            for(int i=0; i<n; i++){
                if(!set[i]) cnt++;
            }
            System.out.println(cnt);
        }
    }

    static private void dfs(int idx){
        int next = graph[idx];

        if(visited[next] || set[next]){
            if(next==cycle){
                while(!stack.isEmpty()) {
                    set[stack.pop()] = true;
                }
            }
            return;
        }
        visited[next] = true;
        stack.push(next);
        dfs(next);
        visited[next] = false;
    }
}
