import java.util.*;

/**
 * Created by Je.vinci.Inc. on 2017. 2. 19..
 */
public class Q1764 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        //ArrayList<String> result = new ArrayList<>();

        HashSet<String> result = new LinkedHashSet<>();

        HashSet<String> unheard = new HashSet<>();

        for(int i=0; i<n; i++){
            unheard.add(scan.next());
        }
        for(int i=0; i<m; i++){
            String unseen = scan.next();
            if(unheard.contains(unseen)){
                result.add(unseen);
            }
        }
        List<String> list = new ArrayList<>(result);
        System.out.println(result.size());
        Collections.sort(list);
        for(String tmp : list){
            System.out.println(tmp);
        }

    }
}
