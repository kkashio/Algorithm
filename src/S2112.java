import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 7..
 */
public class S2112 {
    static Queue<Pair> queue;
    static int d,w,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), tc=0;
        while(tc++<t){
            d=sc.nextInt(); w=sc.nextInt(); k=sc.nextInt();
            queue = new LinkedList<>();
            int[] init = new int[d];
            queue.offer(new Pair(init,0));
            bfs();
        }
    }

    static void bfs(){
        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            int[] cMe = Arrays.copyOf(curr.me, w);
            //check 투과
            for(int i=0; i<d; i++){
                if(cMe[i] != 0) continue;
//                cMe[i] =
//                queue.offer(new Pair())
            }
            //
        }
    }

    static class Pair{
        int me[], lv;
        public Pair(int me[], int lv) {
            this.me = Arrays.copyOf(me,w);
            this.lv = lv;
        }
    }
}
