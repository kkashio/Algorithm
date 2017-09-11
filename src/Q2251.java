import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 9..
 */
public class Q2251 {
    static boolean ans[]=new boolean[201],visited[][][] = new boolean[201][201][201];
    static int A,B,C;
    static Queue<Pair> queue;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A=sc.nextInt();
        B=sc.nextInt();
        C=sc.nextInt();
        queue = new LinkedList<>();
        queue.offer(new Pair(0,0,C));
        visited[0][0][C] = true;
        ans[C] = true;
        bfs();
        for(int i=0; i<C+1; i++){
            if(ans[i]){
                System.out.print(i+" ");
            }
        }
    }

    static private void bfs(){
        int curA, curB, curC;
        int nextA, nextB, nextC;

        while(!queue.isEmpty()){
            curA = queue.peek().a;
            curB = queue.peek().b;
            curC = queue.poll().c;
            //받는쪽이 넘칠경우, 안넘치고 다줄경우
            //A-B
            if(curA + curB > B){
                nextB = B;
                nextA = curA + curB - B;
            } else {
                nextB = curA + curB;
                nextA = 0;
            }
            nextC = curC;
            check(nextA,nextB,nextC);
            //B-A
            if(curB + curA > A){
                nextA = A;
                nextB = curB + curA - A;
            } else {
                nextA = curB + curA;
                nextB = 0;
            }
            nextC = curC;
            check(nextA,nextB,nextC);
            //A-C
            if(curA + curC > C){
                nextC = C;
                nextA = curA + curC - C;
            } else {
                nextC = curA + curC;
                nextA = 0;
            }
            nextB = curB;
            check(nextA,nextB,nextC);
            //C-A
            if(curC + curA > A){
                nextA = A;
                nextC = curC + curA - A;
            } else {
                nextA = curC + curA;
                nextC = 0;
            }
            nextB = curB;
            check(nextA,nextB,nextC);
            //B-C
            if(curB + curC > C){
                nextC = C;
                nextB = curB + curC - C;
            } else {
                nextC = curB + curC;
                nextB = 0;
            }
            nextA = curA;
            check(nextA,nextB,nextC);
            //C-B
            if(curC + curB > B){
                nextB = B;
                nextC = curC + curB - B;
            } else {
                nextB = curC + curB;
                nextC = 0;
            }
            nextA = curA;
            check(nextA,nextB,nextC);
        }
    }
    static private void check(int nextA, int nextB, int nextC){
        if(!visited[nextA][nextB][nextC]){
            visited[nextA][nextB][nextC] = true;
            queue.offer(new Pair(nextA,nextB,nextC));
            if(nextA == 0)
                ans[nextC] = true;
        }
    }

    private static class Pair{
        int a,b,c;
        public Pair(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }
    }
}
