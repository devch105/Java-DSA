package Trees.LeetcodeQuestions;

public class P_124 {

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

    public static int checkMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMax = checkMax(root.left);
        int rightMax = checkMax(root.right);

        int rootMax = root.val
                + Math.max(0, leftMax)
                + Math.max(0, rightMax);
        max = Math.max(max, rootMax);

        return root.val + Math.max(0, Math.max(leftMax, rightMax));
    }
}
