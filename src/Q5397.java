import java.util.LinkedList;
import java.util.Scanner;

public class Q5397 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCase = scan.nextInt();
        String[] input = new String[testCase];

        for(int i=0; i<testCase; i++){
            input[i] = scan.next();
        }

        //start
        LinkedList<Character> preList;
        LinkedList<Character> postList;
        char tmp;

        for(int i=0; i<testCase; i++){
            char ch;
            preList = new LinkedList<>();
            postList = new LinkedList<>();
            for(int j=0; j<input[i].length(); j++){
                tmp = input[i].charAt(j);
                switch (tmp){
                    case '<':
                        if(preList.size() > 0){
                            ch = preList.getLast();
                            preList.removeLast();
                            postList.addFirst(ch);
                        }
                        break;
                    case '>':
                        if(postList.size() > 0){
                            ch = postList.getFirst();
                            postList.removeFirst();
                            preList.addLast(ch);
                        }
                        break;
                    case '-':
                        if(preList.size() > 0){
                            preList.removeLast();
                        }
                        break;
                    default:
                        preList.addLast(tmp);
                }
            }
            preList.addAll(postList);
            for(char c : preList) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
