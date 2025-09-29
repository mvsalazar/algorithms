package com.interview.prep.algorithms;

public class ReverseLinkedList {
    static class ListNode { 
        int val; 
        ListNode next; 
        ListNode(int v){
            val=v;
        } 

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode curr = this;
            while (curr != null) {
                sb.append(curr.val).append(" -> ");
                curr = curr.next;
            }
            sb.append("null");
            return sb.toString();
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null, current = head;
        while (current != null) {
            ListNode next = current.next;
            System.out.println("Next: " + next);
            current.next = previous;
            System.out.println("Current.next " + current.next);
            previous = current;
            System.out.println("Previous: " + previous);
            current = next;
            System.out.println("Current: " + current);
        }
        return previous;
    }

    public static String solution() {
        return null;
    }

    public static void main(String[] args) {
        // Create nodes
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println(reverseList(head));
    }
}
