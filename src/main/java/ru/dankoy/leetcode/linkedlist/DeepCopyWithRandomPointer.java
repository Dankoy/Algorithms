package ru.dankoy.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * Solved
 * Medium
 * Topics
 * premium lock iconCompanies
 * Hint
 * 
 * A linked list of length n is given such that each node contains an additional
 * random pointer, which could point to any node in the list, or null.
 * 
 * Construct a deep copy of the list. The deep copy should consist of exactly n
 * brand new nodes, where each new node has its value set to the value of its
 * corresponding original node. Both the next and random pointer of the new
 * nodes should point to new nodes in the copied list such that the pointers in
 * the original list and copied list represent the same list state. None of the
 * pointers in the new list should point to nodes in the original list.
 * 
 * For example, if there are two nodes X and Y in the original list, where
 * X.random --> Y, then for the corresponding two nodes x and y in the copied
 * list, x.random --> y.
 * 
 * Return the head of the copied linked list.
 * 
 * The linked list is represented in the input/output as a list of n nodes. Each
 * node is represented as a pair of [val, random_index] where:
 * 
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random
 * pointer points to, or null if it does not point to any node.
 * 
 * Your code will only be given the head of the original linked list.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 
 * Example 2:
 * 
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * 
 * Example 3:
 * 
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= n <= 1000
 * -104 <= Node.val <= 104
 * Node.random is null or is pointing to some node in the linked list.
 * 
 * 
 */
public class DeepCopyWithRandomPointer {

    public static void main(String[] args) {

        Node n1 = null;
        Node n2 = null;
        Node n3 = null;
        Node n4 = null;
        Node n5 = null;
        n5 = new Node(1, null, null);
        n4 = new Node(10, n5, null);
        n3 = new Node(11, n4, null);
        n2 = new Node(13, n3, null);
        n1 = new Node(7, n2, null);

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node nmnmm = copyRandomList(n1);

    }

    public static Node copyRandomList(Node head) {

        Map<Node, Node> oldNew = new HashMap<>();

        Node currentNode = head;
        Node newHead = null;

        while (currentNode != null) {

            Node newNode = new Node(currentNode.val, null, null);
            if (currentNode == head) {
                newHead = newNode;
            }

            if (oldNew.containsKey(currentNode)) {
                newNode = oldNew.get(currentNode);
            } else {
                oldNew.put(currentNode, newNode);
            }

            Node currentNext = currentNode.next;
            Node currentRandom = currentNode.random;

            Node newNext = null;
            if (currentNext != null) {
                newNext = new Node(currentNext.val, null, null);
            }

            if (!oldNew.containsKey(currentNext)) {
                newNode.next = newNext;
                oldNew.put(currentNext, newNext);
            } else {
                newNode.next = oldNew.get(currentNext);
            }

            Node newRandom = null;
            if (oldNew.containsKey(currentRandom)) {
                newRandom = oldNew.get(currentRandom);
            } else if (currentRandom != null) {
                newRandom = new Node(currentRandom.val, null, null);
                oldNew.put(currentRandom, newRandom);
            }
            newNode.random = newRandom;

            currentNode = currentNext;
        }

        return newHead;

    }

    public static class Node {
        int val;
        Node next;
        Node random;

        Node() {
        }

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        void setRandom(Node random) {
            this.random = random;
        }
    }

}
