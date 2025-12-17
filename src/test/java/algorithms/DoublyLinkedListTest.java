// src/test/java/algorithms/DoublyLinkedListTest.java
package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<Integer> buildList(Integer... vals) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        for (Integer v : vals) list.pushBack(v);
        return list;
    }

    private LinkedListNode<Integer> nodeAt(DoublyLinkedList<Integer> list, int index) {
        LinkedListNode<Integer> cur = list.getHead();
        int i = 0;
        while (cur != null && i < index) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    private void printList(DoublyLinkedList<Integer> list){
        LinkedListNode<Integer> curr = list.getHead();
        while (curr != null) {
            System.out.print(curr.value);
            if(curr.next != null){
                System.out.print("--->");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    @Test
    void removeMiddleNode() {
        DoublyLinkedList<Integer> list = buildList(1, 2, 3);
        LinkedListNode<Integer> node = nodeAt(list, 1); // value 2
        printList(list);
        //System.out.println(node.previous.value);
        //System.out.println("head: " + list.getHead().value + ", tail: " + list.getTail().value);

        list.remove(node);

        assertEquals(2, list.getSize(), "size after removing middle node");
        assertNotNull(list.getHead(), "head should not be null");
        assertNotNull(list.getTail(), "tail should not be null");
        assertEquals(Integer.valueOf(1), list.getHead().value, "head value");
        assertEquals(Integer.valueOf(3), list.getTail().value, "tail value");
        assertSame(list.getHead().next, list.getTail(), "head.next should be tail");
        assertSame(list.getTail().previous, list.getHead(), "tail.previous should be head");
    }

    @Test
    void removeHeadNode() {
        DoublyLinkedList<Integer> list = buildList(1, 2, 3);
        LinkedListNode<Integer> node = nodeAt(list, 0); // head (1)
        //System.out.println(node.next.value);
        list.remove(node);

        assertEquals(2, list.getSize(), "size after removing head");
        assertNotNull(list.getHead(), "head should not be null after removing previous head");
        assertEquals(Integer.valueOf(2), list.getHead().value, "new head value");
        assertNull(list.getHead().previous, "new head.previous must be null");
    }

    @Test
    void removeTailNode() {
        DoublyLinkedList<Integer> list = buildList(1, 2, 3);
        LinkedListNode<Integer> node = nodeAt(list, 2); // tail (3)
        list.remove(node);

        assertEquals(2, list.getSize(), "size after removing tail");
        assertNotNull(list.getTail(), "tail should not be null after removal");
        assertEquals(Integer.valueOf(2), list.getTail().value, "new tail value");
        assertNull(list.getTail().next, "new tail.next must be null");
    }

    @Test
    void removeSingleNode() {
        DoublyLinkedList<Integer> list = buildList(1);
        LinkedListNode<Integer> node = nodeAt(list, 0); // only node
        list.remove(node);

        assertEquals(0, list.getSize(), "size after removing the only node");
        assertNull(list.getHead(), "head should be null for empty list");
        assertNull(list.getTail(), "tail should be null for empty list");
    }
}