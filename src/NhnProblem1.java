import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 23..
 */
public class NhnProblem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String item;
        String input;
        input = sc.nextLine();
        String[] arr = input.split(" ");
        int size = arr.length;
        List<String> ans = new ArrayList<>();
        for(int i=0; i<size; i++) {
            item = arr[i];
            if (list.contains(item)) {
                list.remove(item);
                list.add(item);
            } else {
                if (list.size() >= 3) {
                    ans.add(list.remove(0));
                    list.add(item);
                } else {
                    list.add(item);
                }
            }
        }
        if(ans.size()==0){
            System.out.println(0);
        } else {
            for(String s : ans){
                System.out.println(s);
            }
        }
    }
}
