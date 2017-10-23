import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoSolution5 {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int len=timetable.length;

        int[] mintable = new int[len];
        for(int i=0; i<len; i++) {
            mintable[i] = convertToMin(timetable[i]);
        }

        Arrays.sort(mintable);

        int bus = 540 ,ans = 0;
        int tmp = 0;
        for(int i=0; i<n; i++){
            //현재버스 타야할 사람고 수용인원 비교
            int cnt=0;

            for(int j=tmp; j<len; j++){
                if(mintable[j] <= bus && cnt<m){
                    cnt++;
                    tmp=j+1;
                }
            }

            if(i==n-1){
                //마지막 버스 남은 사람수와 버스가 태우고 갈수있는 사람의 수 비교
//                for(int j=tmp; j<len; j++){
//                    if(mintable[j] <= bus && cnt <=m){
//                        cnt++;
//                        tmp=j+1;
//                    }
//                }
                if(m > cnt){
                    ans=bus;
                } else {
                    ans=mintable[tmp-1]-1;
                }

            }
            bus += t;
        }

        answer = convertToStr(ans);
        return answer;
    }

    int convertToMin(String str){
        int sum =0;
        StringTokenizer tokenizer = new StringTokenizer(str, ":");
        sum+=Integer.parseInt(tokenizer.nextToken())*60;
        sum+=Integer.parseInt(tokenizer.nextToken());
        return sum;
    }
    String convertToStr(int i){
        String str = "";
        if(i/60 >= 10){
            str+=i/60;
        } else {
            str+="0"+i/60;
        }
        str += ":";
        if(i%60 >=10){
            str += i%60;
        } else {
            str+="0"+i%60;
        }
        return str;
    }

    public static void main(String[] args) {
        KakaoSolution5 k = new KakaoSolution5();

        String[] arr = {"09:00", "09:00", "09:00", "09:00"};
        System.out.println(k.solution(2,1,2, arr));
    }
}
