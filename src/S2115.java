import java.util.*;

/**
 * Created by seongmin Park on 2017. 10. 7..
 * 삼성 벌꿀채취 2115
 */
public class S2115 {
    static int n,m,c,map[][],max;
    static List<Pair> list;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(), tc=0, value;
        while(tc++<t){
            n=sc.nextInt();
            m=sc.nextInt();
            c=sc.nextInt();
            map=new int[n][n];
            list = new ArrayList<>();
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j <n ; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n-m; j++) {
                    value = getValue(i,j);
                    list.add(new Pair(i,j,value));
                }
            }

            Collections.sort(list,(e1,e2)->e2.v-e1.v);
            int size = list.size(), ans=0;
            for (int i=1; i<size; i++){
                if(list.get(0).y == list.get(i).y && ((list.get(i).x >= list.get(0).x && list.get(i).x <= list.get(0).x+m) || (list.get(i).x+m >= list.get(0).x && list.get(i).x+m <= list.get(0).x+m))){
                    continue;
                }
                ans = list.get(0).v + list.get(i).v;
                break;
            }
            System.out.printf("#%d %d\n",tc,ans);

        }

    }
    static int[] cp;
    static void dfs(int sum, int value){
        if(sum > c)
            return;
        for(int i=0; i<m; i++){
            if(!visit[i]){
                visit[i] = true;
                dfs(sum+cp[i], value+(cp[i]*cp[i]));
                visit[i] = false;
            }
        }
        if(value > max)
            max = value;
    }

    static int getValue(int y, int x){
        visit = new boolean[m];
        max = 0;
        cp = Arrays.copyOfRange(map[y],x,x+m);
        for (int i = 0; i < m; i++) {
            visit[i] = true;
            dfs(cp[i],cp[i]*cp[i]);
            visit[i] = false;
        }

        return max;
    }

    static private class Pair{
        int y,x,v;

        public Pair(int y, int x, int v) {
            this.y = y;
            this.x = x;
            this.v = v;
        }
    }
}
