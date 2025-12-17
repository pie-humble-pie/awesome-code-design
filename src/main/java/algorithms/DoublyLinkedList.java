package algorithms;

public class DoublyLinkedList<T> {
    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public LinkedListNode<T> getHead(){
        return this.head;
    }

    public LinkedListNode<T> getTail(){
        return this.tail;
    }

    public int getSize(){
        return this.size;
    }

    public void pushBack(T value) {
        if(tail == null){
            head = tail = new LinkedListNode<>(value);
        }
        else{
            LinkedListNode<T> newNode = new LinkedListNode<>(value);
            tail.next = newNode;
            newNode.previous = tail;
            tail = tail.next;
        }
        size++;
    }

    public void pushFront(T value) {
        if(head == null){
            head = tail = new LinkedListNode<>(value);
        }
        else{
            LinkedListNode<T> newNode = new LinkedListNode<>(value);
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
        size++;
    }

    public LinkedListNode<T> popFront(){
        if(head == null) return null; // empty list
        LinkedListNode<T> node = head;
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
            head.previous = null;
            node.next = null;
        }
        size--;
        return node;
    }

    public LinkedListNode<T> popBack(){
        if(tail == null) return null; //empty list
        LinkedListNode<T> node = tail;
        if(head == tail){
            head = tail = null;
        }
        else{
            tail = tail.previous;
            tail.next = null;
            node.previous = null;
        }
        size--;
        return node;
    }

    public LinkedListNode<T> remove(LinkedListNode<T> node){
        if(node == null) return null;
        if(node == head) return popFront();
        if(node == tail) return popBack();

        LinkedListNode<T> prev = node.previous;
        LinkedListNode<T> next = node.next;
        prev.next = next;
        next.previous = prev;
        node.next = null;
        node.previous = null;
        size--;
        return head;
    }







}
