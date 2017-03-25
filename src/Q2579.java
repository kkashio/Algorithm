import java.util.Scanner;

/**
 *
 *  https://www.acmicpc.net/problem/2579
 *  2579 문제
 */
public class Q2579 {

    static boolean[] check;
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
        for(int i=0; i<n; i++){
            //find max value
            maxNum = findMaxValue();
            if(!isCheck3cons(maxNum)){
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

    static boolean isCheck3cons(int i){
        check[i] = true;
        if(i < 2){
            int z = (check.length > 5) ? i+1 : check.length-2;
            for(int j=0; j<z; j++){
                if(check[j] && check[j+1] && check[j+2]){
                    check[i] = false;
                    return true;
                }
            }
        } else if (i > arr.length-2){
            for(int j=i-2; j<i-(arr.length-i); j++){
                if(check[j] && check[j+1] && check[j+2]){
                    check[i] = false;
                    return true;
                }
            }
        } else {
            for(int j=i-2; j<i; j++){
                if(check[j] && check[j+1] && check[j+2]){
                    check[i] = false;
                    return true;
                }
            }
        }
        return false;
    }
}
