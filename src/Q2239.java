import java.util.Scanner;

/**
 * Created by Seong min on 2017-09-03.
 */
public class Q2239 {
    static int sdoku[][]=new int[9][9];
    static boolean flag;
    public static void main(String[] args) {
        int i,j,k;
        Scanner sc = new Scanner(System.in);
        for (i=0; i<9; i++)
            for (j=0; j<9; j++)
                sdoku[i][j] = sc.nextInt();

        for (i=0; i<9; i++) {
            for (j=0; j<9; j++) {
                if(sdoku[i][j]==0){
                    dfs(i,j);
                }
            }
        }
    }

    static private void dfs(int row, int col){
        int i,j;
        if(flag)
            return;

        for(i=1; i<10; i++){
            for(j=0; i<9; j++){
                if(sdoku[row][j] == i)
                    break;
            }
            for(j=0; i<9; j++){
                if(sdoku[j][col] == i)
                    break;
            }
            sdoku[row][col] = i;
        }
    }
}
