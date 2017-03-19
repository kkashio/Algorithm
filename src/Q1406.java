import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Je.vinci.Inc. on 2017. 3. 10..
 */
public class Q1406 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String initStr = scan.next();
        int n = scan.nextInt();
        char[] command = new char[n];
        char[] input = new char[n];

        for(int i=0; i<n; i++){
            command[i] = scan.next().charAt(0);
            if(command[i]=='P'){
                input[i]=scan.next().charAt(0);
            }
        }

        //start
        LinkedList<Character> preList = new LinkedList<>();
        LinkedList<Character> postList = new LinkedList<>();
        char tmp;

        for(int i=0; i<initStr.length(); i++){
            preList.add(initStr.charAt(i));
        }

        for(int i=0; i<n; i++){
            switch (command[i]){
                case 'L' :
                    if(preList.size() > 0){
                        tmp = preList.getLast();
                        preList.removeLast();
                        postList.addFirst(tmp);
                    } break;
                case 'D' :
                    if(postList.size() > 0){
                        tmp = postList.getFirst();
                        postList.removeFirst();
                        preList.addLast(tmp);
                    } break;
                case 'B' :
                    if(preList.size() > 0){
                        preList.removeLast();
                    } break;
                case 'P' :
                    preList.addLast(input[i]);
            }
        }

        preList.addAll(postList);
        for(char c : preList) {
            System.out.print(c);
        }
    }
}
