package zadanie1Lab3;

import interfaces.InterStack;
import lib.TStackNode;

import java.util.EmptyStackException;

public class TStack<E> implements InterStack<E> {
    private TStackNode<E> top;

    public TStack() {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        if (top == null)
            return true;
        else
            return false;
    }

    @Override
    public E top() {
        if( top == null ){
            throw new EmptyStackException();
        } else {
            return top.getData();
        }
    }

    @Override
    public E pop() {
        if( top == null ){
            throw new EmptyStackException();
        } else {
            E dataOut = top.getData();
            top = top.getPrev();
            return dataOut;
        }
    }

    @Override
    public int size() {
        if( top == null ){
            return 0;
        } else {
            TStackNode<E> refNode = top;
            int counter = 0;
            while (refNode != null) {
                counter++;
                refNode = refNode.getPrev();
            }
            return counter;
        }
    }

    @Override
    public int deepLevel(E item) {
        TStackNode<E> tmp = top;
        int index=0;
        while(tmp != null){
            if(item == tmp.getData()){
                return index;
            }
            tmp = tmp.getPrev();
            index++;
        }
        return -1;
    }

    @Override
    public void push(E item) {
        if (top == null) {
            top = new TStackNode<>(item, null);
        } else {
            TStackNode<E> refNode = new TStackNode<>(item, top);
            top = refNode;
        }
    }
    public void deleteBottom(){
        if(top==null) throw new EmptyStackException();
        else{
            TStackNode<E> tmp = top;
            if(tmp.getPrev()==null) tmp = null;
            else{
                while(tmp.getPrev().getPrev()!=null){
                    tmp = tmp.getPrev();
                }
                tmp.setPrev(null);
            }
        }
    }
}
