package lib;

import inter.InterQueueIterable;

import java.util.Iterator;

public class TQueue<E> implements InterQueueIterable<E> {
    private TQueueNode<E> head;
    private TQueueNode<E> tail;

    public TQueue() {
        head = null;
        tail = null;
    }

    @Override
    public boolean put(E element) {
        TQueueNode<E> ref;
        try {
            ref = new TQueueNode<E>(element);
        } catch (Exception e) {
            return false;
        }
        if( head == null ){
            head = ref;
            tail = ref;
        } else {
            tail.setPtr( ref );
            tail = tail.getPtr();
        }
        return true;
    }

    @Override
    public E top() {
//        if( head == null )
//            return null;
//        else
//            return head.getData();
        return head == null ? null : head.getData();
    }

    @Override
    public E get() {
        if (head == null) {
            return null;
        } else if ( head.getPtr() == null ) { //FIXME: refactor
            E dataRef = head.getData();
            head = null;
            tail = null;
            return dataRef;
        } else {
            E dataRef = head.getData();
            head = head.getPtr();
            return dataRef;
        }
    }

    @Override
    public boolean pop() {
        return false;
    }

    @Override
    public boolean isEmpty() {
//        if (head == null) {
//            return false;
//        } else {
//            return true;
//        }
//        return head == null ? true: false;
        return head == null;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        TQueueNode<E> tmp = head;
        int counter=0;
        while(tmp!=null){
            counter++;
            tmp = tmp.getPtr();
        }
        return counter;
    }
    public boolean single(){
        if(head!=null) return head.getPtr()==null;
        else return false;
    }
    public boolean switchHeadTail(){
        if(size()>1){
            E first = head.getData();
            head.setData(tail.getData());
            tail.setData(first);
            return true;
        }else return false;
    }
    public void join(E[] array){
        for(E element : array){
            put(element);
        }
    }
    public void join(TQueue<E> outer){
        TQueueNode<E> tmp = outer.head;
        while(tmp!=null){
            put(tmp.getData());
            tmp = tmp.getPtr();
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.format("Zawartość kolejki: %n"));
        int no=1;
        for(E element : this){
            str.append(no).append(". ").append(element).append(String.format("%n"));
        }
        return str.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new TQueueIterator<E>(head);
    }
}
