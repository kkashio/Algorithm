import java.util.Scanner;

public class Nhn3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,n,k;
        n = sc.nextInt();
        char map[][]=new char[n][n];
        String ans[][] = new String[n][n];
        for(i=0; i<n; i++)
            for(j=0; j<n; j++)
                map[i][j] = sc.next().charAt(0);

        int[] mx = {0,-1,0,1};
        int[] my = {-1,0,1,0};
        int ny,nx;
        for(i=0; i<n; i++){
            for(j=0; j<n; j++){
                if(map[i][j] == '0'){
                    ans[i][j] = "-1";
                    continue;
                }
                int num=0;

                ny = i+my[0];
                nx = j+mx[0];
                if(ny >= 0)
                    if(map[ny][nx] != '0')
                        num += 1;

                ny = i+my[1];
                nx = j+mx[1];
                if(nx >= 0)
                    if(map[ny][nx] != '0')
                    num += 2;

                ny = i+my[2];
                nx = j+mx[2];
                if(ny < n)
                    if(map[ny][nx] != '0')
                    num += 8;

                ny = i+my[3];
                nx = j+mx[3];
                if(nx < n)
                    if(map[ny][nx] != '0')
                        num += 4;

                ans[i][j] = (num + (map[i][j]-65)*16)+"";
                if(ans[i][j].length()==1) ans[i][j] = " "+ans[i][j];
            }
        }

        for(i=0; i<n; i++){
            String ret = "";
            for(j=0; j<n; j++){
                ret += ans[i][j]+" ";
            }
            ret.trim();
            System.out.println(ret);
        }
    }
}
