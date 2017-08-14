import java.util.ArrayList;
import java.util.Scanner;

public class Q3098 {
    static int n,m,map[][];
    static ArrayList<Integer> ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        map = new int[n][n];
        ans = new ArrayList<>();
        int i,j,a,b,cnt,c,d,sol;

        for(i=0; i<m; i++) {
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            map[a][b] = 1;
            map[b][a] = 1;
        }
        c=(n*(n-1))/2;
        cnt=m;
        d=0;
        while(cnt<c){
            d++;
            sol = link(d);
            ans.add(sol);
            cnt += sol;
        }
        System.out.println(d);
        for(int z: ans)
            System.out.println(z);
    }

    static private int link(int day){
        int i,j,k,cnt=0;
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                if(map[i][j] == day){
                    for(k=0; k<n; k++){
                        if(map[i][k] > 0 && map[i][k] < day+1 && k != j && map[j][k] == 0) {
                            map[j][k] = day+1;
                            map[k][j] = day+1;
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
