import java.util.Scanner;

public class Q2840 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int point = 0;
        boolean err = false;
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] num = new int[k];
        char[] ch = new char[k];
        char[] result = new char[n];
        char[] dup = new char[128];
        //input
        for(int i=0; i<k; i++){
            num[i] = scan.nextInt();
            ch[i] = scan.next().charAt(0);
        }

        //init result array
        for(int i=0; i<n; i++){
            result[i] = '?';
        }

        //algo
        for(int i=0; i<k; i++){
            dup[ch[k-1-i]]++;

            if(result[point] != '?') {

                if(result[point] != ch[k-1-i]) {
                    err = true;
                    break;
                } else {
                    dup[ch[k-1-i]]--;
                }
            }
            result[point] = ch[k-1-i];


            if(dup[ch[k-1-i]] == 2) { //A라는 글자가 두개이상 쓰였는지 검사하는거
                err = true;
            }
            point += num[k-1-i];

            if(point >= n){
                point = point % n;
            }
        }

        if(err){
            System.out.println("!");
            return ;
        }

        for(char c : result)
            System.out.print(c);
    }
}
