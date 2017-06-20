import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 14..
 */
public class Q2174 {
    static int a,b,n,m;
    static int[][] map;
    static List<Robot> robots;
    static List<Character> direction;
    static int move[][] = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        m = sc.nextInt();

        direction = new LinkedList<>();
        direction.add('N');
        direction.add('E');
        direction.add('S');
        direction.add('W');
        robots = new LinkedList<>();
        map = new int[b+1][a+1];
        for(int i=1; i<=n; i++){
            robots.add(new Robot(i,sc.nextInt(),sc.nextInt(),sc.next().charAt(0)));
            map[robots.get(i-1).y][robots.get(i-1).x] = i;
        }
        int robot_seq, repeat;
        char command;
        boolean flag = true;
        //print();
        for(int i=0; i<m; i++){
            robot_seq = sc.nextInt();
            command = sc.next().charAt(0);
            repeat = sc.nextInt();

            if(!flag) continue;

            for(int j=0; j<repeat; j++){
                if(!run(robot_seq, command)) {
                    flag = false;
                    break;
                }
                //print();
            }
        }

        if(flag)
            System.out.println("OK");

    }
    static boolean run(int seq, char command){
        Robot robot = robots.get(seq-1);

        switch (command){
            case 'L' : robot.dir = commandL(robot.dir); break;
            case 'R' : robot.dir = commandR(robot.dir); break;
            case 'F' :
                map[robot.y][robot.x] = 0;
                robot.x += move[direction.indexOf(robot.dir)][0];
                robot.y += move[direction.indexOf(robot.dir)][1];
                if(!check(robot)) return false;
                map[robot.y][robot.x] = robot.seq;
            break;
        }

        return true;
    }

    static class Robot{
        private int seq;
        private int x;
        private int y;
        private char dir;

        public Robot(int seq, int x, int y, char dir){
            this.seq = seq;
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static Character commandR(char dir){
        int idx = direction.indexOf(dir);
        if(idx == 3) {
            return direction.get(0);
        } else {
            return direction.get(idx+1);
        }
    }

    static Character commandL(char dir){
        int idx = direction.indexOf(dir);
        if(idx == 0) {
            return direction.get(3);
        } else {
            return direction.get(idx-1);
        }
    }

    static boolean check(Robot robot){
        if(robot.x <= 0 || robot.x > a || robot.y <= 0 || robot.y > b) {
            System.out.println("Robot " + robot.seq + " crashes into the wall");
            return false;
        }

        if(map[robot.y][robot.x] != 0 && map[robot.y][robot.x] != robot.seq){
            System.out.println("Robot "+ robot.seq+" crashes into robot "+map[robot.y][robot.x]);
            return false;
        }

        return true;
    }

    static void print(){
        for(int b = map.length-1; b >= 0; b--){
            for (int a : map[b]){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
