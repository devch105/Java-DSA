
package Trees.LeetcodeQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void printPreorder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printPreorder(root.left);
        printPreorder(root.right);
    }

    // Build a binary tree from level-order representation.
    // -1 represents a null node.
    public TreeNode buildTree(int[] arr) {

        if (arr == null || arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (i < arr.length && !queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Binary Search Tree

    public TreeNode buildBST() {
        int[] arr = { 4, 2, 7, 1, 3, 6, 9 };
        return createBST(arr);
    }

    public TreeNode createBST(int[] arr) {

        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = null;

        for (int value : arr) {
            root = insertBST(root, value);
        }

        return root;
    }

    private TreeNode insertBST(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insertBST(root.left, value);
        } else if (value > root.val) {
            root.right = insertBST(root.right, value);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        int arr[] = { 9, 6, -3, -1, -1, -6, 2, -1, -1, 2, -1, -6, -6, -6 };
        root = root.buildTree(arr);

        System.out.println("Max Path Exist : " + maxPathSum(root));
    }

    static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        checkMax(root);

        return max;
    }

    public static int checkMax(TreeNode newNode) {
        if (newNode == null) {
            return 0;
        }

        int leftMax = checkMax(newNode.left);
        int rightMax = checkMax(newNode.right);

        int rootMax = newNode.val
                + Math.max(0, leftMax)
                + Math.max(0, rightMax);
        max = Math.max(max, rootMax);

        return newNode.val + Math.max(0, Math.max(leftMax, rightMax));
    }

}
