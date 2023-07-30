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

        for(int i=1;i<arr.length-1;i++) {
            curr.next = new LinkedList.Node(arr[i]);
            curr = curr.next;
        }
        curr.next = new LinkedList.Node(arr[arr.length-1]);
        curr.next = head.next;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = {1,3242,3,2,12421};
        LinkedList.Node head = createSingleLL(arr);

        LinkedList linkedList = new LinkedList();
        LinkedList.Node head1 = linkedList.reverseIterative(head);

        linkedList.traverseIterative(head1);
    }
}
