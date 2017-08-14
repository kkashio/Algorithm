import java.util.Scanner;

public class Q3057 {
    static int r,c,m[][],maxLen;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j,k,l,nowMax=2;
        r=sc.nextInt();
        c=sc.nextInt();
        m=new int[r][c];
        maxLen = -1;
        for(i=0; i<r; i++) {
            String str = sc.next();
            for (j = 0; j < c; j++) {
                m[i][j] = str.charAt(j)-48;
            }
        }

        for(i=0; i<r-1; i++){
            for(j=0; j<c-1; j++){
                int len = Math.min(r-i,c-j);
                for(k=1; k<len-1; k++){
                    if(isKiller(i,j,k)){
                        if(nowMax < k)
                            nowMax = k;
                    }
                }
            }
        }
        System.out.println(nowMax);
    }

    static boolean isKiller(int a, int b, int c){
        int i,j,k;
        for(i=a; i<a+c; i++){
            for(j=b; j<b+c; j++){
                if(m[i][j] != m[j][i])
                    return false;
            }
        }
        return true;
    }
}
