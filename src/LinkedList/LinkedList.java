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
    public Node reverseRecursiveUtil(Node curr, Node prev) {
        if(curr==null) {
            return prev;
        }
        Node nxt = curr.next;
        curr.next = prev;

        return reverseRecursiveUtil(nxt, curr);
    }
    public Node reverseRecursive(Node head) {
        return reverseRecursiveUtil(head, null);
    }
    public Node getKthNode(Node head, int k) {
        int counter =1;
        Node curr = head;
        while(curr!=null) {
            if(counter==k)
                return curr;
            curr = curr.next;
            counter++;
        }
        return null;
    }
    public Node getKthNodeFromEnd(Node head, int k) {
        Node slow = head, fast =head;
        for(int i=0;i<k;i++) {
            fast = fast.next;
        }

        while(fast!=null) {
            slow =slow.next;
            fast = fast.next;
        }
        return slow;
    }
    public Node findMiddle(Node head) {
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node detectCycle(Node head) {
        Node slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                System.out.println("Cycle detected");
                return slow;
            }
        }
        System.out.println("No cycle detected");
        return null;
    }
    public boolean isPalindrome(Node head) {
        Node mid = findMiddle(head);
        Node firstHalf = head;
        Node secondHalf = reverseIterative(mid);

        while(secondHalf!=null) {
            if(firstHalf.data != secondHalf.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
    public Node firstNodeInCycle(Node head) {
        Node pos = detectCycle(head);
        if(pos==null)
            return null;
        Node entry = head;
        while(entry!=pos) {
            entry = entry.next;
            pos = pos.next;
        }
        return entry;
    }

    public Node intersectionPoint(Node headA, Node headB) {
        int c1 = findSize(headA);
        int c2 = findSize(headB);

        int diff = Math.abs(c1-c2);

        while(diff>0) {
            if(c1>c2)
                headA = headA.next;
            else
                headB = headB.next;
            diff--;
        }

        while(headA!=null && headB!=null) {
            if(headA==headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
