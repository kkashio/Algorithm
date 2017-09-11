import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 7..
 */
public class Q2668 {
    static int n,arr[],goal;
    static boolean visited[], ans[];
    static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        n=sc.nextInt();
        arr = new int[n+1];
        visited = new boolean[n+1];
        ans = new boolean[n+1];
        for(i=1; i<n+1; i++){
            arr[i]=sc.nextInt();
        }
        for (i=1; i<n+1; i++) {
            if(!ans[i]) {
                goal=i;
                list = new ArrayList<>();
                list.add(i);
                dfs(i);
            }
        }
        int cnt=0;
        for (i=1; i<n+1; i++) {
            if(ans[i])
                cnt++;
        }
        System.out.println(cnt);
        for (i=1; i<n+1; i++) {
            if(ans[i])
                System.out.println(i);
        }
    }

    static void dfs(int num){
        //기저사례
        if(arr[num]==goal){
            for(Integer i : list){
                ans[i] = true;
            }
            return;
        }
        if(!visited[arr[num]]) {
            visited[arr[num]] =true;
            dfs(arr[num]);
            visited[arr[num]] =false;
        }
    }
}
