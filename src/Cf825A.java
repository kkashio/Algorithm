import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cf825A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {6,3,7,3,1,4,6,3};

        int tail=0,head=0;
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(!map.containsKey(arr[i])){
                tail = i;
                map.put(arr[i], true);
            } else if(arr[head]==arr[i]) {
                head++;
            }
        }
        System.out.printf("head:%d tail:%d length:%d",head,tail,tail-head+1);
    }
}
