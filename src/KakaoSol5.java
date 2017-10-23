import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoSol5 {
    Map<String, Integer> visited1;
    Map<String, Integer> visited2;

    public int solution(String str1, String str2) {
        int answer = 0;
        visited1 = new HashMap<>();
        visited2 = new HashMap<>();
        List<String> list1 = trans(str1);
        List<String> list2 = trans(str2);

        answer = sol(list1,list2);
        return answer;
    }

    List<String> trans(String s){
        int idx=0;
        int len=s.length();
        char[] ch=new char[3];
        ch[2] = 0;
        s = s.toLowerCase();
        List<String> list = new ArrayList<>();
        while(idx<len-1){
            if(s.charAt(idx) >= 'a' && s.charAt(idx) <= 'z' && s.charAt(idx+1) >= 'a' && s.charAt(idx+1) <= 'z'){
                ch[0] = s.charAt(idx);
                ch[1] = s.charAt(idx+1);
                list.add(String.valueOf(ch));
                idx++;
            } else {
                idx++;
            }
        }
        return list;
    }

    int sol(List<String> list1,List<String> list2){
        if(list1.isEmpty() && list2.isEmpty()){
            return 65536;
        }
        int kyo =0, hab=0;
        for(String s : list1){
            if(visited1.get(s) >= 1){
                if(visited2.get(s) < visited1.get(s)){
                    kyo++;
                    visited2.put(s,visited2.get(s)+1);
                } else {
                    hab++;
                }
            } else {
                if(visited1.get(s) == null) {
                    visited1.put(s, 1);
                } else {
                    visited1.put(s, visited1.get(s)+1);
                }

                if(visited2.get(s) == null) {
                    visited2.put(s, 1);
                } else {
                    visited2.put(s, visited2.get(s)+1);
                }
                hab++;

            }

        }
        return (int)((double)65536 * ((double)kyo / (double)hab));
    }


}
