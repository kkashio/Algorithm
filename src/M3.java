import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 10. 2..
 */
public class M3 {
    static int n, arr[], flag[], min;
    static boolean ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            ans = false;
            n = sc.nextInt();
            arr = new int[n];
            flag = new int[n];
            min = 987654321;
            for(int i=0; i<n; i++){
                arr[i]=sc.nextInt();
                if(min > arr[i])
                    min = arr[i];
            }
            if(min==1)
                min=2;
            powerset(n,0);
            System.out.printf("%s",ans ? "YES" : "NO");
        }
    }
//다 나누어 떨어지면 안된다
    static void powerset(int n, int dept){
        if(n==dept){
            boolean isDiv = true;
            ArrayList<Integer> list = new ArrayList<>();
            for(int div=min; div>1; div--){
                for (int i = 0; i < n; i++) {
                    if (flag[i] == 0) continue;
                    if(arr[i]%div!=0){
                        isDiv = false;
                        break;
                    }
                    isDiv = true;
                }
                if(isDiv) break;
            }
            boolean isLab = false;
            if(!isDiv){ //중복검사
                for(int i=0; i<n; i++){
                    if(flag[i]==0) continue;
                    if(list.contains(arr[i])) {
                        isLab = true;
                        break;
                    }
                    list.add(arr[i]);
                }
                if(!isLab){
                    ans = true;
                    return;
                }
            }

            return;
        }
        flag[dept]=1;
        powerset(n,dept+1);
        flag[dept]=0;
        powerset(n,dept+1);
    }
}
