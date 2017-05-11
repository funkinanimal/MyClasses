package unittests;

/**
 * Created by Слава on 10.05.2017.
 */
class DEQueue<T> {

    private Node<T> back;
    private Node<T> front;
    private int size;

    DEQueue(){
        size = 0;
    }

    void pushBack(T arg){

        Node<T> now = new Node<>(arg);

        if (back == null)
            back = now;
        else
        {
            back.setLeft(now);
            now.setRight(back);
            back = now;
        }

        if (front == null)
            front = now;

        size++;
    }

    void pushFront(T arg){

        Node<T> now = new Node<>(arg);

        if(front == null)
            front = now;
        else
        {
            front.setRight(now);
            now.setLeft(front);
            front = now;
        }

        if(back == null)
            back = now;

        size++;
    }

    void popBack(){
        if(back != null){
            back = back.getRight();
            size--;
        }
        else
            System.out.print("queue is empty");
    }

    void popFront(){
        if(front != null){
            front = front.getLeft();
            size--;
        }
        else
            System.out.print("queue is empty");
    }

    T back(){
        return back.getValue();
    }

    T front(){
        return front.getValue();
    }

    int size(){
        return size;
    }

    void clear(){
        front = null;
        back = null;
        size = 0;
    }

    Object[] toArray(){
        Object[] array = new Object[size];
        Node<T> now = back;
        for (int i = 0; i < size; i++)
        {
            array[i] = now.getValue();
            now = now.getRight();
        }
        return array;
    }
}
