import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 8. 19..
 */
public class Q3830R {
    static int n,m;
    static String ans;
    static boolean visit[];
    static LinkedList<Sample> tree[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        while (true) {
            n=sc.nextInt();
            m=sc.nextInt();
            if(n==0 && m==0)
                break;
            tree = new LinkedList[n];
            for(i=0; i<n; i++)
                tree[i] = new LinkedList<>();

            for(i=0; i<m; i++){
                char command = sc.next().charAt(0);
                if(command == '!')
                    setTree(sc. nextInt()-1,sc.nextInt()-1,sc.nextInt());
                else
                    getData(sc.nextInt()-1,sc.nextInt()-1);
            }
        }
    }

    static private void setTree(int from, int to, int weight){
        tree[from].add(new Sample(to,weight));
        tree[to].add(new Sample(from,-weight));
    }

    static private void getData(int from, int to){
        ans = "UNKNOWN";
        visit = new boolean[n];
        visit[from]=true;
        for(Sample s :tree[from]) {
            visit[s.to]=true;
            s.sum = s.weight;
            dfs(s, to);
            visit[s.to]=false;
        }
        System.out.println(ans);
    }

    static private void dfs(Sample s, int to){
        if(!ans.equals("UNKNOWN"))
            return;
        if(s.to==to){
            ans = s.sum+"";
            return;
        }
        for(Sample nS :tree[s.to]){
            if(!visit[nS.to]) {
                nS.sum =s.sum+nS.weight;
                visit[nS.to]=true;
                dfs(nS, to);
                visit[nS.to]=false;
            }
        }
    }

    static private class Sample{
        int to;
        int sum;
        int weight;
        public Sample(int to, int weight){
            this.to = to;
            this.weight = weight;
            sum=0;
        }
    }
}
