import java.util.*;

/**
 * Created by seongmin Park on 2017. 6. 9..
 */
public class Q1475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        char key;
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<n.length(); i++){
            if(n.charAt(i) == '9') {
                key = '6';
            } else {
                key = n.charAt(i);
            }


            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            } else {
                map.put(key, 1);
            }
        }

        if(map.containsKey('6')){
            int val = map.get('6');
            if(val%2 == 1)
                val+=1;

            val /= 2;
            map.put('6', val);
        }


        Map.Entry max = map.entrySet().stream()
                .max((x,y)->x.getValue().compareTo(y.getValue()))
                .get();

        System.out.println(max.getValue());





    }
}
