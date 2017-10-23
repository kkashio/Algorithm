import java.util.Scanner;

/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoSolution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        KakaoSolution1 k = new KakaoSolution1();
        int[] arr1= {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};
        System.out.println(k.solution(5,arr1,arr2));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            answer[i] = new String();
            for(int j=n-1; j>=0; j--){
                boolean a = chk(arr1[i],j);
                boolean b = (chk(arr2[i],j));
                if(a || b) {
                    answer[i] += "#";
                }else {
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }

    boolean chk(int v, int idx){
        return (v & 1 << idx)>0;
    }


}
