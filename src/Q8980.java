import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 13..
 */
public class Q8980 {
    static int n, c, m, vilige[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        c=sc.nextInt();
        m=sc.nextInt();
        vilige = new int[n];
        List<Pair> list = new LinkedList<>();

        for(int i=0; i<m; i++)
            list.add(new Pair(sc.nextInt(),sc.nextInt(),sc.nextInt()));

        Collections.sort(list,(p1,p2)->p1.out-p2.out); //out으로 정렬

        int ans=0;
        for(Pair p : list){
            for(int i=p.in; i<p.out; i++){
                if(p.vol==0) break;
                if(vilige[i]+p.vol > c)
                    p.vol=c-vilige[i];
                vilige[i] += p.vol;
            }
            ans+=p.vol;
        }

        System.out.println(ans);
    }

    static class Pair{
        int in,out,vol;
        public Pair(int in,int out,int vol){
            this.in= in;
            this.out= out;
            this.vol= vol;
        }
    }
}
