import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Je.vinci.Inc. on 2017. 3. 19..
 */
public class Q3045 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        char command;
        int x,y,tmp;
        DoubleNodeList list = new DoubleNodeList();

        int n = scan.nextInt();
        int m = scan.nextInt();

        for(int i=1; i<=n; i++){
            list.push(i);
        }
        System.out.println(list.toString2());
        for(int i=0; i<m; i++){
            list.move(scan.next().charAt(0), scan.nextInt(), scan.nextInt());
        }
        ArrayList result = new ArrayList();
        for(int i=1; i<=list.size; i++){
            DoubleNodeList.Node nodeY = list.get(i);
            DoubleNodeList.Node nodeX = list.search(i);
            if((int)nodeY.data != i){
                list.swap(nodeX,nodeY);
                result.add("A " + nodeX.data +" "+ nodeY.data);
            }
        }

        System.out.println(result);
    }

    static class DoubleNodeList{

        private Node header;
        private Node tail;
        private int size;

        public DoubleNodeList(){
            header = null;
            tail = null;
            size = 0;
        }

        private void push(Object data){
            Node node = new Node(data);
            if(header == null){
                header = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            size++;
        }

        public void move(char command, int x, int y){
            Node nodeY = search(y);
            Node nodeX = remove(search(x));

            if(command == 'A'){ //앞에 푸쉬
                //nodeY의 상태
                if(nodeY == header){
                    nodeY.prev = nodeX;
                    header = nodeX;
                    nodeX.next = nodeY;
                } else {
                    nodeY.prev.next = nodeX;
                    nodeX.prev = nodeY.prev;

                    nodeY.prev = nodeX;
                    nodeX.next = nodeY;
                }
            } else if(command == 'B') {
                if(nodeY == tail){
                    nodeY.next = nodeX;
                    tail = nodeX;
                    nodeX.prev = nodeY;
                } else {
                    nodeY.next.prev = nodeX;
                    nodeX.next = nodeY.next;

                    nodeY.next = nodeX;
                    nodeX.prev = nodeY;
                }
            }
            size++;
        }
        private Node search(Object data){
            Node node = header;
            for(int i=0; i<size; i++){
                if(node.data == data){
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        private Node remove(Node node){
            if(node == header){
                node.next.prev = null;
                header = node.next;
            } else if(node == tail){
                node.prev.next = null;
                tail = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }

            node.prev = null;
            node.next = null;

            size--;

            return node;
        }

        private void swap(Node nodeX, Node nodeY){
            Node tmp = remove(nodeX);

            if(nodeY == header){
                nodeY.prev = tmp;
                header = tmp;
                tmp.next = nodeY;
            } else {
                nodeY.prev.next = tmp;
                tmp.prev = nodeY.prev;

                nodeY.prev = tmp;
                tmp.next = nodeY;
            }
            size++;
        }


        private String toString2(){
            String str = "";
            Node node = header;
            for(int i=0; i<size; i++){
                if(i == size -1){
                    str += node.data;
                } else {
                    str += node.data + " -> ";
                }
                node = node.next;
            }
            return str;
        }

        private Node get(int idx){
            Node node = header;
            for(int i=1; i<=size; i++){
                if(i==idx) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }

        public class Node{
            private Object data;
            private Node prev;
            private Node next;

            public Node(Object data){
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }
    }
}
