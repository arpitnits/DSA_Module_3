package LinkedList;

public class LLMain {

    public static LinkedList.Node createSingleLL(int[] arr) {
        LinkedList.Node head = new LinkedList.Node(arr[0]);
        LinkedList.Node curr = head;

        for(int i=1;i<arr.length;i++) {
            curr.next = new LinkedList.Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }
    public static LinkedList.Node createCircularLL(int[] arr) {
        LinkedList.Node head = new LinkedList.Node(arr[0]);
        LinkedList.Node curr = head;

        for(int i=1;i<arr.length;i++) {
            curr.next = new LinkedList.Node(arr[i]);
            curr = curr.next;
        }
        curr.next = head.next;
        return head;
    }

    public static DoublyLinkedList.DoublyNode createDoublyLinkedList(int[] arr) {
        DoublyLinkedList.DoublyNode head = new DoublyLinkedList.DoublyNode(arr[0]);
        DoublyLinkedList.DoublyNode curr= head;

        for(int i=1;i<arr.length-1;i++) {
            curr.next = new DoublyLinkedList.DoublyNode(arr[i]);
            curr.next.prev = curr;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,18,2,9,24, 5, 8};
        LinkedList.Node head = createSingleLL(arr);

        LinkedList linkedList = new LinkedList();
        LinkedList.Node head1 = linkedList.mergeSort(head);
        //System.out.println(middleNode.data);
        linkedList.traverseIterative(head1);
    }
}
