import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2146 {
    static int n, oMap[][],lMap[][],mY[]={0,1,0,-1}, mX[]={1,0,-1,0}, landCnt, bridge[][], min=987654321;
    static Queue<Pair> queue, sQueue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        oMap = new int[n][n];
        bridge = new int[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                oMap[i][j] = sc.nextInt();
        lMap = new int[n][n];
        sQueue = new LinkedList<>();
        labeling();
        for(int i=1; i<landCnt+1; i++) {
            bridge(i);
        }

        System.out.println(min);
    }

    static private void labeling(){
        landCnt=1;
        queue = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if(oMap[i][j] == 1 && lMap[i][j] == 0){
                    queue.offer(new Pair(i,j));
                    bfs(landCnt);
                    landCnt++;
                }
            }
        }
        //print();
    }

    static private void bridge(int sLand){
        initLmap();
        int nX, nY;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(lMap[i][j] == sLand){
                    for(int k=0; k<4; k++){
                        nY = i+mY[k];
                        nX = j+mX[k];

                        if(nY > n-1 || nY < 0 || nX > n-1 || nX < 0) continue;
                        if(lMap[nY][nX] == 0){
                            bridge[nY][nX] = 1;
                            queue.offer(new Pair(nY,nX,1));
                        }
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            int curY = queue.peek().y;
            int curX = queue.peek().x;
            int curLen = queue.poll().len;

            for(int i=0; i<4; i++){
                nY = curY+mY[i];
                nX = curX+mX[i];
                if(nY > n-1 || nX > n-1 || nY < 0 || nX < 0) continue;

                if(lMap[nY][nX] > 0 && lMap[nY][nX] != sLand){
                    if(curLen < min){
                        min = curLen;
                    }
                    return;
                }

                if(lMap[nY][nX] == 0 && bridge[nY][nX] == 0){
                    bridge[nY][nX] = 1;
                    queue.offer(new Pair(nY,nX,curLen+1));
                }
            }
        }
        print();

    }

    static private void initLmap(){
        while(!queue.isEmpty()) queue.poll();

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                bridge[i][j] = 0;
            }
        }
    }

    static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(bridge[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void bfs(int num){
        while(!queue.isEmpty()) {
            int curY = queue.peek().y;
            int curX = queue.poll().x;

            for(int i=0; i<4; i++){
                int nY = curY+mY[i];
                int nX = curX+mX[i];
                if(nY > n-1 || nX > n-1 || nY < 0 || nX < 0) continue;
                if(oMap[nY][nX] == 1 && lMap[nY][nX] < 1){
                    lMap[nY][nX] = num;
                    queue.offer(new Pair(nY,nX));
                }
            }
        }
    }

    static class Pair{
        int y,x,len,s;
        public Pair(int y, int x, int len){
            this.y = y;
            this.x = x;
            this.len = len;
        }
        public Pair(int y,int x){
            this.y= y;
            this.x = x;
        }
    }
}


