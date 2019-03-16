package com.algorithms.leetCode;

public class LinkAdd {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(7);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(7);
        addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = l1;
        ListNode b = l2;
        ListNode head = new ListNode(0);
        ListNode current = head;
        int carry = 0;
        while (a != null || b != null || carry != 0) {
            int x = (a != null) ? a.val : 0;
            int y = (b != null) ? b.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        return head.next;
    }
}
