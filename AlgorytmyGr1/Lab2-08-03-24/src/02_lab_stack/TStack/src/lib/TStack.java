package lib;

import interfaces.InterStack;

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
        return 0;
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
}
