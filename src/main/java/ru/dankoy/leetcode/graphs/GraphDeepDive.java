package ru.dankoy.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Generated;

public class GraphDeepDive {

    public static void main(String[] args) {

        Node a = new Node();
        a.name = "a";
        Node b = new Node();
        b.name = "b";
        Node c = new Node();
        c.name = "c";
        Node d = new Node();
        d.name = "d";
        Node e = new Node();
        e.name = "e";
        Node f = new Node();
        f.name = "f";
        Node g = new Node();
        g.name = "g";
        Node h = new Node();
        h.name = "h";

        c.child.add(d);
        c.child.add(e);
        c.child.add(f);

        b.child.add(g);
        b.child.add(h);

        a.child.add(b);
        a.child.add(c);

        var list = toFlatList(a);

        list.forEach(n -> System.out.println(n.name));

    }

    private static class Node {
        private String name;
        public List<Node> child = new ArrayList();
    }

    private static List<Node> toFlatList(Node n) {

        List<Node> nodes = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        Set<Node> visited = new HashSet<>();

        stack.push(n);
        visited.add(n);
        // nodes.add(n); // adds root

        while (!stack.isEmpty()) {
            var curr = stack.pop();
            var childred = curr.child;

            nodes.add(curr);

            for (Node node : childred) {
                if (!visited.contains(node)) {
                    visited.add(node);
                    stack.push(node);
                    // nodes.add(node);
                }
            }
        }

        return nodes;

    }

}
