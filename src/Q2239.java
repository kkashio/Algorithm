import java.util.ArrayList;
import java.util.Scanner;

public class Q2239 {
    static int sdoku[][];
    static ArrayList<Pair> zeros;
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sdoku = new int[9][9];
        int i,j,k;
        String num;
        zeros = new ArrayList<>();
        for(i=0; i<9; i++){
            num = sc.next();
            for(j=0; j<9; j++){
                sdoku[i][j] = num.charAt(j)-48;
                if(sdoku[i][j]==0)
                    zeros.add(new Pair(i,j));
            }
        }

        dfs(0);
    }

    static private void dfs(int idx){
        if(idx==zeros.size()){
            print();
            System.exit(0);
        }
        int x = zeros.get(idx).x;
        int y = zeros.get(idx).y;
        for(int i=1; i<10; i++){
            sdoku[x][y] = i;
            if(!check(x,y,i))
                dfs(idx+1);
            sdoku[zeros.get(idx).x][zeros.get(idx).y] = 0;
        }
    }

    static private boolean check(int x, int y, int n){
        if(n==0) return true;

        for(int i=0; i<9; i++){
            if(sdoku[x][i]==n && i!=y){
                return true;
            }
            if(sdoku[i][y]==n && i!=x){
                return true;
            }
        }

        int rx, ry;
        if(x >= 0 && x < 3)
            rx = 0;
        else if(x >= 3 && x < 6)
            rx = 3;
        else
            rx = 6;

        if(y >= 0 && y < 3)
            ry = 0;
        else if(y >= 3 && y < 6)
            ry = 3;
        else
            ry = 6;

        for(int i=rx; i<rx+3; i++){
            for(int j=ry; j<ry+3; j++){
                if(sdoku[i][j]==n && i!=x && j!=y){
                    return true;
                }
            }
        }
        return false;
    }

    static private void print(){
        for (int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                System.out.print(sdoku[i][j]);
            }
            System.out.println();
        }
    }

    static class Pair{
        int x,y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
