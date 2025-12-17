package algorithms;

public class SingleLinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;

    public SingleLinkedList(){
        this.head = null;
        this.tail = null;
    }

    public LinkedListNode<T> getHead(){
        return this.head;
    }
    public LinkedListNode<T> getTail(){
        return this.tail;
    }
}
