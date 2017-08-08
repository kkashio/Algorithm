import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 8. 7..
 */
public class Q1331 {
    static Pair[] command;
    static boolean visit[][], flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int i;
        String str;
        command = new Pair[36];
        visit = new boolean[6][6];

        for(i=0; i<36; i++){
            str = sc.next();
            command[i] = new Pair(i,str.charAt(0)%65,str.charAt(1)-49);
        }

        visit[command[0].y][command[0].x] = true;

        for(i=1; i<36; i++) {
            if (!move(command[i])) break;
        }


        if(flag)
            System.out.println("Valid");
        else
            System.out.println("Invalid");
    }

    static boolean move(Pair now){
        if(visit[now.y][now.x]) {
            return false;
        }

        if(!isMovable(now, command[now.c-1])){
            return false;
        }

        if(now.c == 35){
            if(isMovable(now, command[0])) {
                flag = true;
                return true;
            }
            return false;
        }
        visit[now.y][now.x] = true;

        return true;
    }

    static boolean isMovable(Pair now, Pair pre){
        if((Math.abs(pre.x-now.x)==2 && Math.abs(pre.y-now.y)==1) || (Math.abs(pre.x-now.x)==1 && (Math.abs(pre.y-now.y)==2)))
            return true;
        return false;
    }

    static private class Pair {
        int x, y, c;
        public Pair(int c, int x, int y){
            this.c=c;
            this.x=x;
            this.y=y;
        }
    }
}
