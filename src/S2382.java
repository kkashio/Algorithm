import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 25..
 */
public class S2382 {
    static int n,m,k, dx[]={0,1,-1,0}, dy[]={-1,0,0,1};
    static Micro map[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(), tc=0;
        while(tc++<t){
            n=sc.nextInt(); m=sc.nextInt(); k=sc.nextInt();
            map=new Micro[n][n];
            int y,x,dir,tot;
            for(int i=0; i<k; i++){
                y=sc.nextInt(); x=sc.nextInt(); tot=sc.nextInt(); dir=sc.nextInt();
                map[y][x]=new Micro(0,dir,tot);
            }

            while(m-->0){
                move();
            }
        }
    }
    static class Micro{
        int cnt,dir,tot;
        public Micro(int cnt,int dir,int tot){
            this.cnt=cnt;
            this.dir=dir;
            this.tot=tot;
        }
    }

    static void move(){
        int nx, ny;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == null) continue;
                ny=dy[map[i][j].dir];
                nx=dx[map[i][j].dir];

                //가쪽에 닿는 경우, 아무것도 없는경우, 친구를만난경우1,2
                if(ny == 0 || nx == 0 || ny == n-1 || nx == n-1){

                }
            }
        }
    }
}
