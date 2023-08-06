package LinkedList;

import java.util.Stack;

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
    public void alternateSplit(Node head) {
        Node headA, headB, nxt;
        headA = head;
        if(head==null || head.next==null) {
            headB = null;
            return;
        }
        headB = head.next;
        Node curr = head;
        while(curr.next!=null) {
            nxt = curr.next;
            curr.next = curr.next.next;
            curr = nxt;
        }
    }
    public Node mergeTwoLL(Node headA, Node headB) {
        if(headA == null)
            return headB;
        if(headB == null)
            return headA;

        Node head;
        if(headA.data<= headB.data) {
            head = headA;
            headA = headA.next;
        } else {
            head = headB;
            headB = headB.next;
        }

        Node curr = head;
        while(headA!=null && headB!=null) {
            if(headA.data<= headB.data) {
                curr.next = headA;
                headA = headA.next;
            } else {
                curr.next = headB;
                headB = headB.next;
            }
            curr =curr.next;
        }

        while(headA!=null) {
            curr.next = headA;
            headA = headA.next;
            curr = curr.next;
        }

        while(headB!=null) {
            curr.next = headB;
            headB = headB.next;
            curr = curr.next;
        }

        return head;
    }
    private int[] convertToArray(Node head, int n) {
        int[] arr = new int[n];
        int i=0;
        while(head!=null) {
            arr[i++] = head.data;
            head = head.next;
        }
        return arr;
    }
    public int[] nextLargerElement(Node head) {
        int n = findSize(head);
        int[] arr = convertToArray(head, n);

        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[n];

        for(int i=0;i<n;i++) {

            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                nextGreater[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        return nextGreater;
    }
    public Node addTwoNumbers(Node l1, Node l2) {
        l1 = reverseIterative(l1);
        l2 = reverseIterative(l2);

        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        int sum, val,carryOver =0;
        Node head =null, curr = null;
        while (l1!=null && l2!=null) {
            sum = l1.data + l2.data + carryOver;
            val = sum%10;
            carryOver = sum/10;
            if(head==null) {
                head = new Node(val);
                curr = head;
            } else {
                curr.next = new Node(val);
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {
            sum = l1.data + carryOver;
            val = sum%10;
            carryOver = sum/10;
            curr.next = new Node(val);
            l1 = l1.next;
            curr = curr.next;
        }

        while(l2!=null) {
            sum = l2.data + carryOver;
            val = sum%10;
            carryOver = sum/10;
            curr.next = new Node(val);
            l2 = l2.next;
            curr = curr.next;
        }

        if(carryOver!=0) {
            curr.next = new Node(carryOver);
        }

        return head;
    }

    public Node findMiddleRevamp(Node head) {
        Node slow =head, fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node mergeSort(Node head) {
        if(head==null || head.next==null) {
            return head;
        }

        Node mid = findMiddleRevamp(head);
        Node midNxt = mid.next;
        mid.next = null;
        Node firstHalf = mergeSort(head);
        Node secondHalf = mergeSort(midNxt);

        head = mergeTwoLL(firstHalf, secondHalf);

        return head;
    }












}
