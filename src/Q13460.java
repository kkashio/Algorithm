import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 19..
 */
public class Q13460 {
    static Queue<Pair> queue;
    static int n,m, mx[] = {1,0,-1,0}, my[] = {0,1,0,-1};
    static char borad[][];
    static Point hole;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n=sc.nextInt();
        m=sc.nextInt();
        borad = new char[n][m];
        int i,j;
        String input;
        Point red=null,bule=null;
        for(i=0; i<n; i++){
            input = sc.next();
            borad[i] = input.toCharArray();
            for(j=0; j<m; j++) {
                if(borad[i][j]=='R')
                    red = new Point(i,j);
                if(borad[i][j]=='B')
                    bule = new Point(i,j);
                if(borad[i][j]=='O')
                    hole = new Point(i,j);
            }
        }
        queue = new LinkedList<>();
        queue.offer(new Pair(red,bule,1));
        System.out.println(bfs());

    }


    static int bfs(){
        Point curBule, curRed;
        int cnt,nx,ny;
        while(!queue.isEmpty()){
            curBule = queue.peek().bule;
            curRed = queue.peek().red;
            cnt = queue.poll().cnt;

            if(cnt > 10) return -1;
            for(int i=0; i<4; i++){
                // 오른쪽 아래 왼쪽 위
                boolean mRed=true, mBule=true;
                int bx=curBule.x,by=curBule.y,rx=curRed.x,ry=curRed.y;
                while(mRed || mBule){
                    // 왼쪽으로 한칸 이동
                    by += my[i]; bx += mx[i];
                    if(borad[by][bx] == '#'){
                        by -=my[i]; bx -= mx[i];
                        mBule = false;
                    } else if (borad[by][bx] == '0') {
                        //블루가 들어가면 안됨
                        break;
                    } else if(borad[by][bx] == 'R'){
                        by -=my[i]; bx -= mx[i];
                    }

                    ry+=my[i]; rx+=mx[i];
                    if(borad[ry][rx] == '#'){
                        ry-=my[i]; rx-=mx[i];
                        mRed = false;
                    } else if(borad[ry][rx] == 'O') {
                        return cnt;
                    } else if(borad[ry][rx] == 'B'){
                        ry -=my[i]; rx -= mx[i];
                        mBule = false;
                        mRed = false;
                    }
                    if(!mRed && !mBule){
                        queue.offer(new Pair(new Point(by,bx),new Point(ry,rx),cnt+1));
                    }
                }
            }
        }
        return -1;
    }



    static class Point{
        int y,x;
        public Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static class Pair{
        Point red;
        Point bule;
        int cnt;
        public Pair(Point red, Point bule, int cnt){
            this.red = red;
            this.bule = bule;
            this.cnt = cnt;
        }
    }
}
