import java.util.Stack;

/**
 * Created by seongmin Park on 2017. 9. 16..
 */
public class KakaoSolution2 {
    public int solution(String dartResult) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        int len = dartResult.length();
        char now,next,nnext, nnnext;
        for(int i=0; i<len; i++) {
            stack.push(dartResult.charAt(i));
        }
        int num=0;
        char bonus = 'x';
        while(!stack.isEmpty()){
            now = stack.pop();
            if(now > 64){ //보너스
                next = stack.pop();
                if(next=='0') {
                    if(!stack.isEmpty()) {
                        nnext = stack.pop();
                        if (nnext == '1') {
                            next = 58;
                        } else {
                            stack.push(nnext);
                        }
                    }
                }
                num = pow(next-48, now);

                if(bonus == '*') {
                    num = num * 2;
                    bonus = 'x';
                }
            }else if(now >34){
                next = stack.pop(); //보너스
                nnext = stack.pop(); //숫자
                if(nnext=='0') {
                    if(!stack.isEmpty()) {
                        nnnext = stack.pop();
                        if (nnnext == '1') {
                            nnext = 58;
                        } else {
                            stack.push(nnnext);
                        }
                    }
                }
                num = pow(nnext-48,next);
                if(bonus=='*') {
                    num *= 2;
                    bonus = 'x';
                }
                if(now=='*'){
                    num = num * 2;
                    bonus = '*';
                } else {
                    num = -1 * num;
                }
            }
            answer += num;
        }

        return answer;
    }

    int pow(int num, char ch){
        int ret;
        if(ch == 'D'){
            ret = (num)*(num);
        } else if(ch == 'T'){
            ret = (num)*(num)*(num);
        } else {
            ret = num;
        }
        return ret;
    }

    public static void main(String[] args) {
        KakaoSolution2 k = new KakaoSolution2();
        System.out.println(k.solution("0S*3T#0S#"));
    }
}
