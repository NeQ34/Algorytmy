package lib;

import inter.InterQueueIterable;

import java.util.Iterator;
import java.util.Random;

public class TQueueArray<E> implements InterQueueIterable<E> {
    private int head;
    private int tail;
    private int size;
    final private int maxSize;
    private E[] array;

    public TQueueArray(int maxSize) {
        this.maxSize = maxSize > 1 ? maxSize : 256;
        head = 0;
        tail = 0;
        size = 0;
        array = (E[]) new Object[this.maxSize];
    }

    @Override
    public boolean put(E element) { //todo: refactoring
        if( isEmpty() ){
            array[tail] = element;
            size++;
            return true;
        } else if (isFull()) {
            return false;
        } else {
            tail = (tail+1)%maxSize;
            array[tail] = element;
            size++;
            return true;
        }
    }

    @Override
    public E top() {
        if(size>0) return array[head];
        else return null;
    }

    @Override
    public E get() {
        E tmp = array[head];
        head++;
        size--;
        return null;
    }

    @Override
    public boolean pop() {
        if(isEmpty()) {
            return false;
        }else if(size==1) {
            head = 0;
            tail = 0;
            size = 0;
            return true;
        }else{
            head = (head+1) % maxSize;
            size--;
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean isFull() {
        return size==maxSize;
    }

    @Override
    public int size() {
        return size;
    }
    public int reset(E toPut){
        Random random = new Random();
        size = random.nextInt(maxSize);
        head = random.nextInt(maxSize-size);
        tail = head+size;
        for (int i=head;i<tail;i++){
            array[i] = toPut;
        }
        return head;
    }
    public boolean putFront(E element){
        try{
            E[] tmpArr = (E[]) new Object[this.maxSize];
            System.arraycopy(array, head,tmpArr,head+1,size);
            size++;
            tail++;
            tmpArr[head] = element;
            array = tmpArr;
            return true;
        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }
    public E getBack(){
        E tmp = array[tail];
        size--;
        tail--;
        return tmp;
    }

    @Override
    public Iterator<E> iterator() {
        return new TQueueArrayIterator<E>(head,size,array,maxSize);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i=head;i<size;i++){
            sb.append("tab["+i+"]= " + array[i]+"\n");
        }
        if (head>tail){
            for (int i=0;i<head;i++){
                sb.append("tab["+i+"]= " + array[i]+"\n");
            }
        }
        return sb.toString();
    }
}
