import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * Created by Je.vinci.Inc. on 2017. 3. 28..
 */
public class PerfactSearch {
    static int v;
    static int[][] map = {{0,1500,700,600,500,0},
            {1500,0,600,2000,500,1700},
            {700,600,0,1000,700,600},
            {600,2000,1000,0,600,500},
            {500,500,700,600,0,1200},
            {0,1700,600,500,1200,0}};


    public static void main(String[] args) {
        v = 5;
        List<Integer> list = new LinkedList<>();
        shortestRoute(list,4);
    }

    //주어진 경로의 길이를 반환하는 함수
    public static int getRouteLength(List<Integer> list){
        int sum = map[0][list.get(0)];
        for(int i=0; i<list.size(); i++){
            if(i==list.size()-1) {
                sum += map[list.get(i)][v];
            }
            else
                sum += map[list.get(i)][list.get(i+1)];

            System.out.print(list.get(i) + "-> " );
        }
        System.out.println(sum);
        return 0;
    }

    //주어진 경로에 해당 도시가 이미 포함되어 있는지를 반환하는 함수
    public static boolean isVisited(List<Integer> list, int v){
        return list.contains(v);
    }

    public static int shortestRoute(List<Integer> curList, int toVisit){
        // 기저 사례: 이미 경로가 완성되었을 때 현재 길이를 반환
        if(toVisit == 0) return getRouteLength(curList);
        int ret = 987654321;
        for(int next = 1; next < 5; ++next){
            if(isVisited(curList, next)) continue;
            curList.add(next);
            ret = min(ret,shortestRoute(curList, toVisit -1));
            curList.remove(curList.size()-1);
        }
        return ret;
    }

    public static int min(int a, int b){
        if(a > b) return b;
        else return a;
    }
}
