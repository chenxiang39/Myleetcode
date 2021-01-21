import java.util.Stack;

public class Validate_Binary_Search_Tree_98_very_important {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static boolean isValidBST(TreeNode root) {
        return recursion(root,null,null);
    }
    //Time complexity : O(N) since we visit each node exactly once.
    //Space complexity : O(N) since we keep up to the entire tree.
    //是用Integer是因为Integer是类，默认值为null，int是基本数据类型，默认值为0；
    //如果是用int，则需要设置成long类型来保证边缘测试的正确性，Integer则可以直接使用null
    public static boolean recursion(TreeNode root, Integer min, Integer max){      //int和Integer介绍：https://blog.csdn.net/andyzhaojianhui/article/details/84324466 和 https://blog.csdn.net/qq_16669583/article/details/92167216
        if(root == null){
            return true;
        }
        if(min != null && root.val <= min){
            return false;
        }
        if(max != null && root.val >= max){
            return false;
        }
        return recursion(root.left, min, root.val) && recursion(root.right, root.val,max);
    }
    //按中序遍历，应该是递增的顺序（先到最左边，再到中间，再到右边，然后再到上一层的节点）
    //Time complexity : O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.
    //Space complexity : O(N) to keep stack.
    public static boolean isValidBST_2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;      //一旦发现与递增的顺序不符合则为false
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = null;
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(8);
        System.out.println(isValidBST_2(root));
    }
}
