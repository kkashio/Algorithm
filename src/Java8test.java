import java.util.ArrayList;
import java.util.List;

/**
 * Created by PARK on 2017-02-15.
 */
public class Java8test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        String[] strArr = list.stream().map(e -> e.toString()).toArray(String[]::new);

        for(String a : strArr)
            System.out.println(a);
    }

}