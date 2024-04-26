package zadanie1Lab3;

public class TStackNode<E> {
    private E data;
    private lib.TStackNode prev;

    public TStackNode(E data, lib.TStackNode prev) {
        this.data = data;
        this.prev = prev;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public lib.TStackNode getPrev() {
        return prev;
    }

    public void setPrev(lib.TStackNode prev) {
        this.prev = prev;
    }
}
