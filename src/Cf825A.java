/**
 * Created by seongmin Park on 2017. 7. 17..
 */
public class Cf825A {
    public static void main(String[] args) {
        int key = 0;
        key |= 1 << 1;
//        key |= 1 << 3;
//        key |= 4;
        key |= 1<<6;
        System.out.println(Integer.toBinaryString(key));
        if((key & (1<<3)) == 0) {
            System.out.println("1");
        }
        System.out.println(key & (8));
        if ((key & (1 << (20 / 10))) == 0) {


            System.out.println("틀림");
        }
    }
}
