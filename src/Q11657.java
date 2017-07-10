import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 7. 10..
 */
public class Q11657 {
    static int n,m,dist[];
    static Bus[] bus;
    static final int NONE = -1, INF=10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();

        bus = new Bus[m];
        dist = new int[n+1];

        for(int i=0; i<m; i++){
            bus[i] = new Bus(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        for(int i=0; i<n+1; i++){
            dist[i] = INF;
        }

        dist[1] = 0;

        if(bellman()){
            for(int i=2; i< n+1; i++){
                System.out.println(dist[i] == INF ? -1 : dist[i]);
            }
        } else {
            System.out.println(NONE);
        }
    }

    static boolean bellman(){
        for (int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(dist[bus[j].end] > dist[bus[j].start] + bus[j].weight){
                    dist[bus[j].end] = dist[bus[j].start] + bus[j].weight;
                }
            }
        }

        for(int i=0; i<m; i++){
            if(dist[bus[i].end] > dist[bus[i].start] + bus[i].weight){
                return false;
            }
        }
        return true;
    }

    static class Bus{
        int start;
        int end;
        int weight;

        public Bus(int start, int end, int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}


