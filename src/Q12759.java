import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 13
 * start 13:45
 * 1차 14:06 56% 실패
 * 2차 14:24 64% 실패
 * 3차 14:52
 */
public class Q12759 {
    static int[][] board ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int turn = sc.nextInt();
        int winner=0;
        board = new int[3][3];
        for(int i=0; i<9; i++){
            board[sc.nextInt()-1][sc.nextInt()-1] = turn;
            if(isWin()){
                winner = turn;
                break;
            }
            if(isDraw())
                break;
            turn = turn==2 ? 1 : 2;
        }
        System.out.println(winner);
    }
    static boolean isWin(){
        //가로, 세로, 대각선 검사
        for(int i=0; i<3; i++){
            if(board[i][0] != 0 && board[i][0]==board[i][1] && board[i][0]==board[i][2]) return true;
            if(board[0][i] != 0 && board[0][i]==board[1][i] && board[0][i]==board[2][i]) return true;
        }
        if(board[0][0] != 0 && board[0][0]==board[1][1] && board[0][0]==board[2][2]) return true;
        if(board[0][2] != 0 && board[0][2]==board[1][1] && board[0][2]==board[2][0]) return true;

        return false;
    }

    static boolean isDraw(){
        //한줄에 1과 2가 있는 확인
        boolean one,two,chk[] = new boolean[8];
        int t=0;

        for(int i=0; i<3; i++){
            one=false; two=false;
            for(int j=0; j<3; j++) {
                if (board[i][j] == 1)
                    one = true;
                else if(board[i][j] == 2)
                    two = true;
            }
            if(one && two)
                chk[t]=true;
            t++;
        }
        for(int i=0; i<3; i++){
            one=false; two=false;
            for(int j=0; j<3; j++) {
                if (board[j][i] == 1)
                    one = true;
                else if(board[j][i] == 2)
                    two = true;
            }
            if(one && two)
                chk[t]=true;
            t++;
        }
        one = false; two=false;
        for(int i=0; i<3; i++){
            if(board[i][i] == 1)
                one = true;
            else if(board[i][i] == 2)
                two = true;
        }
        if(one && two)
            chk[t]=true;
        t++;
        one = false; two=false;
        for(int i=0; i<3; i++){
            if(board[i][2-i]==1)
                one=true;
            else if(board[i][2-i]==2)
                two=true;
        }
        if(one && two)
            chk[t]=true;

        for(boolean b : chk){
            if(!b) return false;
        }
        return true;
    }
}
