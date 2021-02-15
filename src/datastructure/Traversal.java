package datastructure;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
    Node root;

    public void setRootNode(Node root) {
        this.root = root;
    }

    public Traversal() {
    }

    public void printPreOrder(Node node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.data + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    public void printInOrder(Node node) {
        if (node == null) {
            return;
        } else {
            printInOrder(node.left);
            System.out.print(node.data + " ");
            printInOrder(node.right);
        }
    }

    public void printPostOrder(Node node) {
        if (node == null) {
            return;
        } else {
            printInOrder(node.left);
            printInOrder(node.right);
            System.out.print(node.data + " ");

        }
    }

    public void printLevelOrder(Node node) {
        if (node == null) {
            return;
        }
        Queue <Node> queue = new LinkedList <>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

    }

    /// quite difficult
    public void printInOrderWithStack(Node node) {
        if (node == null) {
            return;
        }
        Stack <Node> stack = new Stack <>();
        Node curr = node;

        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }

    /// quite difficult
    public void printPreOrderWithStack(Node node) {
        if (node == null) {
            return;
        }
        //import java.util.Stack;
        Stack <Node> stack = new Stack <>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.data + " ");
            if (temp.right != null) {
                stack.add(temp.right);
            }
            if (temp.left != null) {
                stack.add(temp.left);
            }
        }
    }


    @Test
    public void Test() {
        Traversal tree = new Traversal();
        tree.setRootNode(new Node(1));
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(10);
        System.out.println("DFS-INORDER-TRAVERSAL - WITH RECURSION!...");
        tree.printInOrder(tree.root);
        System.out.println("\nDFS-INORDER-TRAVERSAL - WITH STACK!...");
        tree.printInOrderWithStack(tree.root);
        System.out.println("\nDFS-PREORDER-TRAVERSAL - WITH RECURSION!...");
        tree.printPreOrder(tree.root);
        System.out.println("\nDFS-PREORDER-TRAVERSAL - WITH STACK!...");
        tree.printPreOrderWithStack(tree.root);
        System.out.println("\nDFS-POSTORDER-TRAVERSAL - WITH RECURSION!...");
        tree.printPostOrder(tree.root);
        System.out.println("\nBFS-levelORDER-TRAVERSAL WITH QUEUE!...");
        tree.printLevelOrder(tree.root);
    }

    public static void main(String[] args) {
        Traversal tree = new Traversal();
        tree.setRootNode(new Node(1));
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(10);
        System.out.println("DFS-INORDER-TRAVERSAL!...");
        tree.printInOrder(tree.root);
        System.out.println("\nDFS-PREORDER-TRAVERSAL!...");
        tree.printPreOrder(tree.root);
        System.out.println("\nDFS-POSTORDER-TRAVERSAL!...");
        tree.printPostOrder(tree.root);

        System.out.println("\nHamming ===> " + tree.hammingWeight(1101));

    }

    public int hammingWeight(int n) {
        int hammingWeight = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                hammingWeight++;
            }
            n = n / 2;
        }
        return hammingWeight;
    }

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

}
