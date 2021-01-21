public class Balanced_Binary_Tree_110_very_important {
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
    //N：节点个数
    //自顶向下
    //时间和空间复杂度见leetcode 110分析
    //时间复杂度：O(NlogN),不早结束的话是N^2
    //空间复杂度：O(N), The recursion stack may contain all nodes if the tree is skewed.
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        //当前层的深度的差距要在1之内，并且左孩子和右孩子也需要平衡，当前点才能说平衡
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //求深度
    private int depth(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(depth(root.left),depth(root.right)) + 1;
    }

    //自底向上
    //方法如下，这种方法被称为the bottom up的方法，即从底向上的方法，即后序遍历的方法。
    //这种方法不是显式的从根节点开始计算每个节点的高度，然后比较左右子树的高度差。而是在计算树的高度的同时判断该树是不是平衡的。
    //即先判断子树是不是平衡的，若是，则返回子树的高度；若不是，则返回一个非法的数字，如负数。
    //当一个节点是左右子树有一个不是平衡二叉树则不必继续计算，直接返回false；当左右子树都是平衡时，再比较两个子树的高度是否相差1。若不是，则返回false，否则返回该节点的高度。

    //Time complexity : O(n). For every subtree, we compute its height in constant time as well as compare the height of its children. //不会重复查看点
    //Space complexity : O(n). The recursion stack may go up to O(n) if the tree is unbalanced.
    public boolean isBalanced_2(TreeNode root) {
        if(root == null){
            return true;
        }
        //查看以root为根节点的树是否平衡
        return recursion(root) != -1;
    }
    private int recursion(TreeNode root){
        if(root == null){
            return 0;
        }
        //如果子树不平衡，这本身不平衡
        int left = recursion(root.left);
        if( left == -1){
            return -1;
        }
        int right = recursion(root.right);
        if(right == -1){
            return -1;
        }
        if(Math.abs(left - right) > 1){
            return - 1;
        }
        //若平衡，返回深度
        else{
            return Math.max(left, right) + 1;
        }
    }
}
