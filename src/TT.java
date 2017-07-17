import java.util.LinkedList;
import java.util.List;

/**
 * Created by seongmin Park on 2017. 7. 11..
 */
public class TT {
    static int map[][], visited[][], move[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static List<Widget> resultList;

    public static void main(String[] args) {
        int x = 4; //가로 길이
        int y = 4; //세로 길이

        visited = new int[y][x];
        map = new int[y][x];
        resultList = new LinkedList<>();

        //위치 초기화
        //이미 존재하는 위젯 위치 입력
        Widget sample8 = new Widget(0,0,1,1);
        Widget sample4 = new Widget(0,1,2,2);
        Widget sample2 = new Widget(3,0,1,1);
        Widget sample1 = new Widget(2,1,2,1);

        setWidgetOnMap(sample1);
        setWidgetOnMap(sample2);
        setWidgetOnMap(sample4);
        setWidgetOnMap(sample8);

        int width = 2; //들어갈 위젯 넓이
        int height = 1; //들어갈 위젯 높이

        for(int[] arr : map) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        arrayCopy(map,visited);
        for(int i=0; i<x; i++){
            for(int j=0; j<y; j++){
                if(checkArea(i,j,width,height)){
                    resultList.add(new Widget(i,j,width,height));
                }
            }
        }

        for(Widget w : resultList){
            System.out.println("result x,y : " + w.x + " " + w.y);
        }

    }

    static class Widget{
        private int x;
        private int y;
        private int width;
        private int height;

        public Widget(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

    static void setWidgetOnMap(Widget widget){
        for(int i=widget.x; i<widget.width+widget.x; i++){
            for(int j=widget.y; j<widget.y+widget.height; j++){
                map[j][i] = 1;
            }
        }
    }

    static void arrayCopy(int a[][], int b[][]){
        for(int i=0; i<a.length; i++){
            System.arraycopy(a[i],0,b[i],0,a[i].length);
        }
    }


    static boolean checkArea(int x, int y, int w, int h){
        if(h+y > map.length || w+x > map[0].length)
            return false;

        for(int i=x; i<w+x; i++){
            for(int j=y; j<h+y; j++) {
                if(map[j][i] == 1)
                    return false;
            }
        }

        return true;
    }

}
