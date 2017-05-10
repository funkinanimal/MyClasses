package unittests;

/**
 * Created by Слава on 10.05.2017.
 */
public class DEQueue<T> {

    private T type; //<-for what this?

    private Node back;
    private Node front;
    private int size;

    public DEQueue(){
        size = 0;
    }

    public void pushBack(T arg){

        Node now = new Node(arg);

        if (back == null)
            back = now;
        else
            back.setLeft(now);

        if (front == null)
            front = now;

        size++;
    }

    public void pushFront(T arg){

    }

    public void popBack(){

    }

    public void popFront(){

    }
/*
    public T back(){

    }

    public T front(){

    }
*/
    public int size(){
        return size;
    }

    public void clear(){

    }
/*
    public T[] toArray(){

    }*/
}
