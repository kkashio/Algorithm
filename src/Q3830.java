import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 8. 16..
 */
public class Q3830 {
    static LinkedList<Sample> tree[];
    static Queue<Sample> queue;
    static int n,m;
    static String ans;
    static boolean visit[];
    static char com;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        while(true){
            n=sc.nextInt();
            m=sc.nextInt();
            if(n==0 && m==0) break;
            tree = new LinkedList[n];


            ans="";
            for(i=0; i<n; i++)
                tree[i] = new LinkedList<>();

            for(i=0; i<m; i++) {
                com = sc.next().charAt(0);
                if (com == '!') {
                    setSample(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
                } else {
                    getSample(sc.nextInt()-1,sc.nextInt()-1);
                    System.out.println(ans);
                }
            }
        }

    }

    static private void setSample(int from, int to, int weight){
        tree[from].add(new Sample(to,weight));
        tree[to].add(new Sample(from,-1*weight));
    }
    static private void getSample(int from, int to){
        visit = new boolean[n];
        visit[from]=true;
        bfs(from,to,0);
        visit[from]=false;
    }
    static private void bfs(int from, int to, int weight){
        int nTo, nWeight, sum;
        queue = new LinkedList<>();
        for(Sample s : tree[from])
            queue.offer(s);

        while(!queue.isEmpty()){
            nTo = queue.peek().to;
            nWeight = queue.peek().weight;
            if(nTo==to){
                ans = queue.peek().sum+nWeight+"";
                return;
            }
            queue.poll();
            for(Sample s : tree[nTo]){
                if(!visit[s.to]) {
                    visit[s.to]=true;
                    s.sum+=nWeight;
                    queue.offer(s);
                }
            }
        }
        if(queue.isEmpty()){
            ans="UNKNOWN";
            return;
        }
    }
    static private class Sample {
        int to;
        int weight;
        int sum;
        public Sample(int to, int weight){
            this.to=to;
            this.weight=weight;
        }
        public Sample(int to, int weight, int sum){
            this.to=to;
            this.weight=weight;
            this.sum = sum;
        }
    }
}
