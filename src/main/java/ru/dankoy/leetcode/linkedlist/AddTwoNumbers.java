package ru.dankoy.leetcode.linkedlist;

import java.math.BigInteger;

import ru.dankoy.leetcode.linkedlist.MergeSortedLinkedLists.ListNode;

/**
 * 2. Add Two Numbers
 * Solved
 * Medium
 * 
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading
 * zeros.
 * 
 * 
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(2, new ListNode(4,
                new ListNode(3, null)));
        ListNode list2 = new ListNode(5, new ListNode(6, new ListNode(4,
                null)));

        var res = addTwoNumbers(list1, list2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 1. retrieve numbers from lists

        BigInteger i1 = toNum(l1);
        BigInteger i2 = toNum(l2);

        // sum numbers

        BigInteger sum = i1.add(i2);

        // put numbers into new list

        return fromNum(sum);

    }

    private static BigInteger toNum(ListNode l) {

        StringBuilder sb = new StringBuilder();

        ListNode curr = l;
        ListNode next = l.next;

        while (curr != null) {
            sb.append(curr.val);
            curr = next;
            if (curr != null)
                next = curr.next;
        }

        String n = sb.reverse().toString();

        return new BigInteger(n);

    }

    private static ListNode fromNum(BigInteger num) {

        StringBuilder sb = new StringBuilder();

        String s = sb.append(num).reverse().toString();

        var chars = s.toCharArray();

        ListNode head = null;
        ListNode prev = null;

        for (int i = 0; i < chars.length; i++) {

            ListNode curr = new ListNode();
            int intChar = Integer.valueOf(Character.toString(chars[i]));
            curr.val = intChar;

            if (prev != null) {
                prev.next = curr;
                prev = curr;
            } else {
                head = curr;
                prev = curr;
            }

        }

        return head;

    }

}
