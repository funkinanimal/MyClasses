package unittests;

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
            if (back.getRight() != null)
            {
                back = back.getRight();
                back.setLeft(null);
            }
            else {
                back = null;
                front = null;
            }
            size--;
        }
        else
            System.out.print("queue is empty");
    }

    void popFront(){
        if(front != null){
            if (front.getLeft() != null) {
                front = front.getLeft();
                front.setRight(null);
            }
            else {
                back = null;
                front = null;
            }
            size--;
        }
        else
            System.out.print("queue is empty");
    }

    T back(){
        if (back != null)
            return back.getValue();
        else
            return null;
    }

    T front(){
        if (front != null)
            return front.getValue();
        else
            return null;
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
