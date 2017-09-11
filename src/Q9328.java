import java.util.*;

/**
 * Created by seongmin Park on 2017. 9. 4..
 */
public class Q9328 {
    static int mW[]={0,1,0,-1}, mH[]={1,0,-1,0},w,h,cnt;
    static boolean visit[][], isEnd;
    static Queue<Node> queue;
    static char map[][];
    static Map<Character, Boolean> key;
    public static void main(String[] args) {
        int i,j;
        String input;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            isEnd=false;
            cnt=0;
            h = sc.nextInt()+2;
            w = sc.nextInt()+2;
            map = new char[h][w];
            key = new HashMap<>();
            for(i=0; i<h; i++)
                for(j=0; j<w; j++)
                    map[i][j] = '.';

            for(i=1; i<h-1; i++) {
                input=sc.next();
                for (j = 1; j < w - 1; j++) {
                    map[i][j] = input.charAt(j-1);
                }
            }
            String keys = sc.next();
            if(!keys.equals("0")) {
                for (i = 0; i < keys.length(); i++)
                    key.put(keys.charAt(i), true);
            }

            while(!isEnd) {
                visit = new boolean[h][w];
                queue = new LinkedList<>();
                queue.offer(new Node(0,0));
                bfs();
            }
            System.out.println(cnt);
        }
    }

    static private void bfs(){
        int cw,ch,nW,nH;
        char rowKey;

        while(!queue.isEmpty()){
            cw = queue.peek().w;
            ch = queue.poll().h;

            for(int i=0; i<4; i++){
                nW = cw + mW[i];
                nH = ch + mH[i];
                if(nW == -1 || nH == -1 || nW > w-1 || nH > h-1) continue;

                if(!visit[nH][nW] && map[nH][nW] != '*'){
                    visit[nH][nW] = true;
                    if(map[nH][nW] > 96){ //키를 발견
                        if(!key.containsKey(map[nH][nW])){
                            //키추가후 새로시작
                            key.put(map[nH][nW],true);
                            map[nH][nW]='.';
                            return;
                        }
                    } else if(map[nH][nW] > 64){ //문을 발견
                        rowKey=(char) (map[nH][nW]+32);
                        if(key.containsKey(rowKey)){
                            map[nH][nW] = '.'; //오픈
                        } else {continue;}
                    } else if(map[nH][nW]=='$'){
                        map[nH][nW] = '.';
                        cnt++;
                    }
                    queue.offer(new Node(nH,nW));
                }
            }
        }
        isEnd=true;
    }

    static class Node{
        int w,h;
        public Node(int h, int w){
            this.h= h;
            this.w=w;

        }
    }
}
