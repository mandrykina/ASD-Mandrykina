package Lab7;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    class TreeNode {
        int value;
        TreeNode leftChild, rightChild;
        public TreeNode (int value) {
            this.value = value;
        }
    }

    public TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void insert(int node) {
        root = insert(root, new TreeNode(node));
    }

    public TreeNode insert(TreeNode root, TreeNode node) {
        if (root == null)
            return node;
        if (root.value <= node.value)
            root.leftChild = insert(root.leftChild, node);
        else root.rightChild = insert(root.rightChild, node);
        return root;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("В дереві немає елементів");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current != null) {
                    System.out.print(current.value + " ");
                    queue.add(current.leftChild);
                    queue.add(current.rightChild);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
        }
    }

    public void removeLeavesAndPrint() {
        root = removeLeaves(root);
        printTree();
    }

    private TreeNode removeLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.leftChild == null && root.rightChild == null) {
            return null;
        }
        root.leftChild = removeLeaves(root.leftChild);
        root.rightChild = removeLeaves(root.rightChild);
        return root;
    }

    public void removeByValue(int value) {
        root = removeByValue(root, value);
    }

    private TreeNode removeByValue(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (value > root.value) {
            root.leftChild = removeByValue(root.leftChild, value);
        } else if (value < root.value) {
            root.rightChild = removeByValue(root.rightChild, value);
        } else {
            if (root.leftChild == null && root.rightChild == null) {
                return null;
            }
            if (root.leftChild == null) {
                return root.rightChild;
            }
            if (root.rightChild == null) {
                return root.leftChild;
            }
            root.value = minValue(root.leftChild);
            root.leftChild = removeByValue(root.leftChild, root.value);
        }
        return root;
    }

    private int minValue(TreeNode root) {
        int minVal = root.value;
        while (root.rightChild != null) {
            minVal = root.rightChild.value;
            root = root.rightChild;
        }
        return minVal;
    }

    public void printInLine(TreeNode root) {
        if (root != null) {
            printInLine(root.leftChild);
            System.out.print(root.value + " ");
            printInLine(root.rightChild);
        }
    }

    public TreeNode search(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return root;
        }
        if (value > root.value) {
            return search(root.leftChild, value);
        } else {
            return search(root.rightChild, value);
        }
    }
}
