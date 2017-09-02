import org.omg.CORBA.INTERNAL;

public class LinkedListDeque<sth> {

    /**  nest class    */
    public class Node {
        public Node pre;
        public sth item;
        public Node next;

        public Node(Node m, sth i, Node n) {
            pre = m;
            item = i;
            next = n;

        }
    }


    private int size = 0 ;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(sentinel,null,sentinel);
        size = 0;

    }

    public LinkedListDeque(sth x){

        sentinel.next = new Node(sentinel, x, sentinel);
        sentinel.pre = sentinel.next;
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(sth x) {
        if(sentinel.next == null){
            sentinel.next = new Node(sentinel,x,sentinel);
            sentinel.pre = sentinel.next;

        }
        else {

            Node temp= new Node(sentinel,x,sentinel.next);
            sentinel.next.pre = temp.next;
            sentinel.next = temp;

        }
        size += 1;
    }

    public void removeFirst() {
        sentinel.next.next.pre = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
    }



    public void addLast(sth x){

        if (sentinel.next == null){
            sentinel.next = new Node(sentinel,x,sentinel);

        }
        else {
            Node temp= new Node(sentinel.pre,x,sentinel);
            sentinel.pre.next = temp;
            sentinel.pre = temp;
        }
        size+=1;


    }


    public void printDeque(){

        while (sentinel.next.item !=null){
            System.out.println(sentinel.next.item);
            this.removeFirst();
        }



    }
    /** Returns the number of items in the list. */
    public int size() {
        return this.size;
    }

    public boolean isEmpty(){
        boolean res = false;
        if (this.size == 0) res = true;

        return res;
    }

    public sth get(int index){
        Node ptr = sentinel.next;

        if(size-1<index){
            return null;
        }
        while(index!=0){
            ptr = ptr.next;
            index-=1;
        }

        return ptr.item;

    }

    public sth getRecursive(int index){

        if(index-1>size) return null;
        while(index>0){

            removeFirst();
            getRecursive(index - 1);
        }
        return sentinel.next.item;


    }


}
