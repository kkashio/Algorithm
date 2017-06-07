import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 6. 2..
 */
public class Q1012 {

    final static int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    static int inputX,inputY;
    static int map[][];
    static int visited[][];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int test_case = scan.nextInt();
        int result[] = new int[test_case];


        for(int i=0; i<test_case; i++){
            inputX = scan.nextInt();
            inputY = scan.nextInt();
            map = new int[inputX][inputY];
            visited = new int[inputX][inputY];
            int cabbage = scan.nextInt();
            int worm = 0;

            for(int j=0; j<cabbage; j++){
                map[scan.nextInt()][scan.nextInt()] = 1;
            }

            //algorithm
            for(int j=0; j<inputX; j++){
                for(int k=0; k<inputY; k++){
                    //DFS
                    if(map[j][k] == 1) {
                        DFS2(new Ground(j,k));
                        worm++;
                    }
                }
            }
            result[i] = worm;
        }

        for(int a : result)
            System.out.println(a);
    }
    static class Ground{
        private int x;
        private int y;

        public Ground(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static void DFS2(Ground ground){
        int nextX;
        int nextY;
        visited[ground.x][ground.y] = 1;
        for(int a=0; a<4; a++){
            nextX = ground.x + move[a][0];
            nextY = ground.y + move[a][1];
            if(nextX >= 0 && nextX < inputX && nextY >=0 && nextY < inputY){
                if(map[nextX][nextY] == 1 && visited[nextX][nextY] == 0){
                    DFS2(new Ground(nextX, nextY));
                }
            }
        }
        map[ground.x][ground.y] = 0;
    }
}
