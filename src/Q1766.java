import java.util.*;

/**
 * Created by seongmin Park on 2017. 7. 10..
 */
public class Q1766 {
    static int n, m, a, b, con[];
    static Map<Integer, ArrayList<Integer>> map;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        con = new int[n+1];
        map = new HashMap<>();
        queue = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            if (map.get(a) == null) {
                ArrayList<Integer> tmp = new ArrayList<>();
                map.put(a, tmp);
            }

            map.get(a).add(b);
            con[b]++;
        }

        for(int i=1; i<=n; i++){
            if(con[i] == 0)
                queue.offer(i);
        }

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            System.out.print(tmp+" ");

            if(map.get(tmp) == null) continue;

            for(int i : map.get(tmp)){
                con[i]--;
                if(con[i] == 0)
                    queue.offer(i);
            }
        }
    }
}



