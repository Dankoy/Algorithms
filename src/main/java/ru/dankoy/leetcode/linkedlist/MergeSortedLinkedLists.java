package ru.dankoy.leetcode.linkedlist;

/**
 * 21. Merge Two Sorted Lists
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * 
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * 
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 * 
 * 
 */
public class MergeSortedLinkedLists {

    public static void main(String[] args) {

        ListNode list1 = new ListNode(-9, new ListNode(-7,
                new ListNode(-3, new ListNode(-3, new ListNode(-1, new ListNode(2, new ListNode(3)))))));
        ListNode list2 = new ListNode(-7, new ListNode(-7, new ListNode(-6,
                new ListNode(-6, new ListNode(-5, new ListNode(-3, new ListNode(2, new ListNode(4))))))));

        ListNode res = mergeTwoLists(list1, list2);

        System.out.println(res);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode resultHead = null;
        ListNode resultTail = null;

        ListNode next1 = list1;
        ListNode next2 = list2;

        // choose head

        while (next1 != null || next2 != null) {

            var val1 = next1 != null ? next1.val : Integer.MIN_VALUE;
            var val2 = next2 != null ? next2.val : Integer.MIN_VALUE;

            ListNode next = null;
            ListNode prev = null;

            if (val1 == val2) {

                next = new ListNode(val2);
                prev = new ListNode(val1, next);

                next1 = next1 != null ? next1.next : next1;
                next2 = next2 != null ? next2.next : next2;

            } else if (val1 > val2) {

                if (val2 == Integer.MIN_VALUE) {
                    prev = new ListNode(val1, null);
                    next1 = next1 != null ? next1.next : next1;
                } else {
                    prev = new ListNode(val2, null);
                    next2 = next2 != null ? next2.next : next2;
                }

            } else {

                if (val1 == Integer.MIN_VALUE) {
                    prev = new ListNode(val2, null);
                    next2 = next2 != null ? next2.next : next2;
                } else {
                    prev = new ListNode(val1, null);
                    next1 = next1 != null ? next1.next : next1;
                }

            }

            // Проверка головы. Если она пуста, то добавить, когда начала списка
            // формируется.
            // Иначе добавлять в конец списка.
            if (resultHead == null) {
                resultHead = prev;
                resultTail = next != null ? next : prev;
            } else {
                resultTail.next = prev;
                resultTail = next != null ? next : prev;
            }

        }

        return resultHead;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
