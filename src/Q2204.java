import java.util.*;
import java.util.stream.Stream;

/**
 * Created by seongmin Park on 2017. 6. 12..
 */
public class Q2204 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> result = new LinkedList<>();
        int num = sc.nextInt();
        while(num != 0){
            Node[] arr = new Node[num];
            for(int i=0; i<num; i++){
                String str = sc.next();
                arr[i] = new Node(str, str.toLowerCase());
            }
            Arrays.sort(arr, ((o1, o2) -> o1.convert2Low.compareTo(o2.convert2Low)));
            result.add(arr[0].ori);
            num = sc.nextInt();
        }

        for(String str : result)
            System.out.println(str);
    }
    static class Node{
        private String ori;
        private String convert2Low;

        public Node(String ori, String convert2Low){
            this.ori = ori;
            this.convert2Low = convert2Low;
        }
    }
}
