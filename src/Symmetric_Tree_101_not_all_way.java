public class Symmetric_Tree_101_not_all_way {
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
    //recursion way
    //Time complexity : O(n). Because we traverse the entire input tree once, the total run time is O(n), where nn is the total number of nodes in the tree.
    // Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n).
    // Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case.
    public static boolean isSymmetric(TreeNode root) {
        return recursion(root,root);        //同根，不同方向
    }
    public static boolean recursion(TreeNode left, TreeNode right){
        if(left == null && right == null){      //都为null, 表示一样
            return true;
        }
        if(left == null || right == null){          //一个是null，一个不为null
            return false;
        }
        //值一样，然后各自遍历自己的左子树和对方的右子树，自己的右子树和对方的左子树
        return left.val == right.val && recursion(left.right,right.left) && recursion(left.left,right.right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        TreeNode root2 = new TreeNode(5);
        root2.left = null;
        root2.right = new TreeNode(6);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(8);
        System.out.println(isSymmetric(root));
    }
}
