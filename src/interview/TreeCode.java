package interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TreeCode {
    public static List <List <Integer>> cacheList1 = new ArrayList <List <Integer>>();

    public static void main(String[] args) {
        System.out.println("Hello world");
        TreeCode tree = new TreeCode();
        /*Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        System.out.println("Traversing tree in order");
        tree.traverseInOrder(root );
        System.out.println();*/
        Node root1 = new Node(3);
        root1.left = new Node(6);
        root1.right = new Node(9);
        root1.right.left = new Node(7);
        root1.right.right = new Node(8);
        //List<Integer> cacheList = new ArrayList <>();
        tree.traverseInOrder(root1);
        System.out.println();

        System.out.println(recursiveMethod("sanjay"));
        String inputString = "qwer rtyu     ertyu   3456";

        String stringWithoutSpaces = inputString.replaceAll("\\s+", "");
        System.out.println(stringWithoutSpaces);


    }

    public static String recursiveMethod(String str) {
        if ((null == str) || (str.length() <= 1)) {
            return str;
        }
        return recursiveMethod(str.substring(1)) + str.charAt(0);
    }

    public void traverseInOrder1(Node node, List <Integer> cacheList) {
        if (node != null) {
            System.out.print(" " + node.value);
            cacheList.add(node.value);
            traverseInOrder1(node.left, cacheList);
            traverseInOrder1(node.right, cacheList);
            cacheList1.add(new ArrayList <>(cacheList));
            cacheList.clear();


        }
    }


    public void traverseInOrder(Node node) {
        if (node != null) {
            System.out.print(" " + node.value);
            traverseInOrder(node.left);
            traverseInOrder(node.right);
        }
    }

    public void insert(Node node, int value) {
        if (value < node.value) {
            if (node.left != null) {
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else if (value > node.value) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                        + node.value);
                node.right = new Node(value);
            }
        }
    }

    public static class Node {
        Node left;
        Node right;
        int value;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

    }
}