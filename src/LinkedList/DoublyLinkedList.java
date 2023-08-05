package LinkedList;

public class DoublyLinkedList {
    public static class DoublyNode {
        int data;
        DoublyNode prev= null;
        DoublyNode next = null;

        DoublyNode() {
        }

        DoublyNode(int data) {
            this.data = data;
        }

        DoublyNode(int data, DoublyNode prev, DoublyNode next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    public DoublyNode reverse(DoublyNode head) {

        DoublyNode nxt, prv = null;
        while(head!=null) {
            prv = head;
            nxt = head.next;
            head.next = head.prev;
            head.prev = nxt;

            head = head.prev;
        }
        return prv;
    }
}
