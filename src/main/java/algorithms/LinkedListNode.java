package algorithms;

public class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next;
    LinkedListNode<T> previous;

    public LinkedListNode(T value){
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    public LinkedListNode(T value, LinkedListNode<T> next, LinkedListNode<T> previous){
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

}
