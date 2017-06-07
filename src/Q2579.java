import java.util.Scanner;

/**
 *
 *  https://www.acmicpc.net/problem/2579
 *  2579 문제
 */
public class Q2579 {

    static boolean[] memo;
    static int[] memoValue;
    int[] step = {1,2};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();

        memo = new boolean[n];
        memoValue = new int[n];
        boolean[] check = new boolean[n];
        check[n-1] = true;
        int sum = arr[n-1];

        for(int i=n-2; i>+0; i--){
            for(int j=0; j<2; j++){
                //if(check[i] )
            }
        }
    }

    static int getValue(){
        return 0;
    }




    /*static boolean[] check;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;
        arr = new int[n];
        check = new boolean[n];

        for(int i=0; i<n; i++)
            arr[i] = scan.nextInt();

        //algorithm start!
        int maxNum;
        //last num
        sum = arr[n-1];
        check[n-1] = true;
        arr[n-1] = 0;
        for(int i=0; i<n-1; i++){
            //find max value
            maxNum = findMaxValue();
            if(!isCheck3cons(maxNum)){
                //System.out.println(sum + " + " + arr[maxNum]);
                sum += arr[maxNum];
            }
            arr[maxNum] = 0;

        }
        System.out.println(sum);

    }

    static int findMaxValue(){
        int max = 0;
        int maxNum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max) {
                max = arr[i];
                maxNum = i;
            }
        }
        return maxNum;
    }

    static boolean isCheck3cons(int maxNum){
        check[maxNum] = true;
        int start;
        int end;

        if(maxNum < 3) {
            start = 0;
        } else {
            start = maxNum - 2;
        }

        if(arr.length < maxNum+3){
            end = arr.length-2;
        } else {
            end = maxNum+1;
        }

        for(int i=start; i<end; i++){
            if(check[i] && check[i+1] && check[i+2]){
                check[maxNum] = false;
                return true;
            }
        }

        return false;

    }*/
}
