import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 7..
 */
public class Q9205 {

    static int[] visited;
    static int[][] location;
    static int n;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int test_case = scan.nextInt();
        String[] result = new String[test_case];

        for(int i=0; i<test_case; i++){
            n = scan.nextInt();
            location = new int[n+2][2];

            for(int j=0; j<n+2; j++){
                location[j][0] = scan.nextInt();
                location[j][1] = scan.nextInt();
            }

            if(distance(n+1,0) <= 1000){
                result[i] = "happy";
                continue;
            }

            visited = new int[n+2];
            if(DFS(0)){
                result[i] = "happy";
            } else {
                result[i] = "sad";
            }

        }

        for(String str : result)
            System.out.println(str);
    }


    public static boolean DFS(int now){
        //거리가 1000 미만인 곳으로 이동
        visited[now] = 1;
        if(now == n+1)
            return true;
        for(int i=1; i<n+2; i++){
            if(visited[i] == 0 && distance(now,i) <= 1000){
                if(DFS(i))
                    return true;
            }
        }

        return false;
    }

    static int distance(int now, int next){
        return Math.abs(location[now][0] - location[next][0]) + Math.abs(location[now][1] - location[next][1]);
    }
}
