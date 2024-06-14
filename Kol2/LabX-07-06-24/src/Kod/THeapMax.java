package Kod;

import Kod.InterHeap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class THeapMax<E extends Comparable<E>> implements InterHeap<E> {
    private ArrayList<E> array;

    public THeapMax() {
        array = new ArrayList<E>();
    }

    @Override
    public boolean insert(E element) {
        int child,parent;
        child = size();
        try {
            array.add(element);
        } catch (Exception e) {
            return false;
        }
        while (  child != 0  ){
            parent = (child-1)/2;
            if( array.get(child).compareTo(array.get(parent)) > 0   ){
                E tmp = array.get(child);
                array.set(child,array.get(parent));
                array.set(parent,tmp);
                child = parent;
            } else {
               break;
            }
        }
        return true;
    }

    @Override
    public E delete() {
        if( isEmpty() )
            return null;
        E tmp = array.get(0);
        array.set(0, array.get(size()-1));
        array.remove(size()-1);
        int child;
        int parent = 0;
        while ( parent*2+1 < size() ){
            if( parent*2+2 < size() ){
                // 2 potomków
                child = array.get(parent*2+1).compareTo( array.get(parent*2+2)) > 0 ?
                        parent*2+1 : parent*2+2;
            } else {
                // 1 potomek
                child = parent*2+1;
            }
            if( array.get(parent).compareTo( array.get(child) ) < 0 ){
                E tmpData = array.get(parent);
                array.set(parent,array.get(child));
                array.set(child,tmpData);
                parent = child;
            } else {
                break;
            }
        }
        return tmp;
    }
    public int find(E element){
        if(array.isEmpty()) return -1;
        int child,parent;
        child = size()-1;
        while(child!=0){
            parent = (child-1)/2;
            if(array.get(child).compareTo(element)>0) child = parent;
            else return array.indexOf(element);
        }
        return -1;
    }
    //a
    public void preorder(){
        List<E> preorderList = new ArrayList<>();
        preorderRec(0,preorderList);
        System.out.println("\nPreorder:");
        for(E elem : preorderList){
            System.out.print(elem+",");
        }
    }
    public void preorderRec(int nodeIndex, List<E> list){
        if(nodeIndex>size()-1) return;
        list.add(array.get(nodeIndex));
        preorderRec(2*nodeIndex+1,list);
        preorderRec(2*nodeIndex+2,list);
    }
    public void inorder(){
        List<E> inorderList = new ArrayList<>();
        inorderRec(0,inorderList);
        System.out.println("\nInorder:");
        for(E elem : inorderList){
            System.out.print(elem+",");
        }
    }
    public void inorderRec(int nodeIndex, List<E> list){
        if(nodeIndex>size()-1) return;
        inorderRec(2*nodeIndex+1,list);
        list.add(array.get(nodeIndex));
        inorderRec(2*nodeIndex+2,list);
    }
    public void postorder(){
        List<E> postorderList = new ArrayList<>();
        postorderRec(0, postorderList);
        System.out.println("\nPostorder:");
        for(E elem : postorderList){
            System.out.print(elem+",");
        }
    }
    public void postorderRec(int nodeIndex, List<E> list){
        if(nodeIndex>size()-1) return;
        postorderRec(2*nodeIndex+1,list);
        postorderRec(2*nodeIndex+2,list);
        list.add(array.get(nodeIndex));
    }
    //c
    public boolean checkHeap(ArrayList<E> array){
        for(int i=array.size()-1; i>0; --i){
            int parent = (i-1)/2;
            if(array.get(i).compareTo(array.get(parent))>0) return false;
        }
        return true;
    }
    //d
    public boolean insertHeap(E element, ArrayList<E> array){
        
    }
    @Override
    public boolean isEmpty() {
        return array.size() == 0;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return array.size();
    }
}
