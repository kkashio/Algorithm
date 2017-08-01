import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 8. 1..
 */
public class Q14621 {
    static int n,m,parent[], min=0;
    static boolean arr[], visit[];
    static List<Edge> edges;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();

        arr = new boolean[n+1];
        edges = new ArrayList<>();
        parent = new int[n+1];
        visit = new boolean[n+1];

        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=1; i<=n; i++){
            if(sc.next().charAt(0) == 'M')
                arr[i] = true;
            else
                arr[i] = false;
        }

        for(int i=0; i<m; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int w = sc.nextInt();

            if(arr[s]^arr[e]) {
                edges.add(new Edge(s,e,w));
            }
        }

        edges.sort((Edge e1, Edge e2)->e1.w-e2.w);

        for(int i=0; i<edges.size(); i++){
            int rootX = findRoot(edges.get(i).s);
            int rootY = findRoot(edges.get(i).e);

            if(rootX == rootY) {continue;}
            else{
                parent[rootX] = rootY;
                min += edges.get(i).w;
                visit[edges.get(i).s] = true;
                visit[edges.get(i).e] = true;
            }
        }
        for(int i=1; i<=n; i++){
            if(!visit[i]){
                min = -1;
                break;
            }
        }
        System.out.println(min);
    }

    private static int findRoot(int x){
        if(x == parent[x]){
            return x;
        } else {
            parent[x] = findRoot(parent[x]);
            return parent[x];
        }
    }

    private static class Edge {
        int s,e,w;
        public Edge(int s,int e,int w){
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }
}
