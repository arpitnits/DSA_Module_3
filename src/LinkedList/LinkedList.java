package LinkedList;

public class LinkedList {
    public static class Node {
        int data;
        Node next = null;

        Node() { }

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private void addDelimiter(Node head) {
        if(head!=null) {
            System.out.print("->");
        }
    }
    public void traverseIterative(Node head) {
        while(head!=null) {
            System.out.print(head.data);
            head = head.next;
            addDelimiter(head);
        }
    }
    public void traverseRecursive(Node head) {
        if (head==null) {
            return;
        }
        System.out.println(head.data);
        traverseRecursive(head.next);
    }
    public Node insertAtBeginning(Node head, int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        return newNode;
    }
    public Node insertAtEnd(Node head, int val) {
        Node newNode = new Node(val);
        Node curr = head;
        while(curr.next!=null) {
            curr = curr.next;
        }
        curr.next = newNode;
        return head;
    }
    public Node insertAtPosition(Node head, Node prevNode, int val) {
        Node newNode = new Node(val);
        Node curr = head;
        while (curr!=prevNode) {
            curr =curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }
    public boolean search(Node head, int target) {
        while(head!=null) {
            if(head.data==target) {
                return true;
            }
            head= head.next;
        }
        return false;
    }
    public int findSize(Node head) {
        int count =0;
        while (head!=null) {
            count++;
            head=head.next;
        }
        return count;
    }
    public Node delete(Node head, int key) {

        if(head!=null && head.data==key) {
            head = head.next;
            return head;
        }
        Node curr = head, prev = null;
        while(curr!=null && curr.data!=key) {
            prev = curr;
            curr = curr.next;
        }

        if(curr==null) {
            System.out.println("No key matched!");
            return head;
        }

        prev.next = curr.next;
        return head;
    }
    public Node reverseIterative(Node head) {

        Node curr = head, nxt, prev = null;
        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        return prev;
    }
}
