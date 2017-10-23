import java.util.LinkedList;
import java.util.List;

/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoSolutionP3 {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> list = new LinkedList<>();
        if(cacheSize==0)
            return cities.length * 5;
        for(String s : cities){
            s = s.toLowerCase();
            if(list.contains(s)){
                list.remove(s);
                list.add(s);
                answer++;
                continue;
            }
            if(list.size() >= cacheSize){
                list.remove(0);
            }
            list.add(s);
            answer += 5;
        }
        return answer;
    }
}
