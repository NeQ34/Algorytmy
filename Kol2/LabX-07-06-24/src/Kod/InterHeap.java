package Kod;

public interface InterHeap<E> {
    boolean insert(E element);
    E delete();
    boolean isEmpty();
    boolean isFull();
    int size();
}
