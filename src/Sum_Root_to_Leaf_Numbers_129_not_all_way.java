public class Sum_Root_to_Leaf_Numbers_129_not_all_way {
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
    //dfs
    //参考资料：https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/328601/all-dfs-traversals-preorder-postorder-inorder-in-java-in-5-lines
    //时间复杂度: O(n), n : amount of nodes
    //空间复杂度: O(H), H : 树的最大高度(StringBuilder)
    int result = 0;
    public int sumNumbers(TreeNode root) {
        //特殊情况
        if(root == null){
            return result;
        }
        StringBuilder cur = new StringBuilder();
        dfs(cur, root);
        return result;
    }
    private void dfs(StringBuilder cur, TreeNode root){
        cur.append(root.val);
        //遇到叶子结点就结算数字和
        if(root.left == null && root.right == null){
            result += Integer.parseInt(cur.toString());
        }
        if(root.left != null){
            dfs(cur, root.left);
            cur.deleteCharAt(cur.length() - 1);     //回溯
        }
        if(root.right != null){
            dfs(cur, root.right);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
//        root.right.left = new TreeNode(6);
//        root.right.right = null;
        Sum_Root_to_Leaf_Numbers_129_not_all_way a = new Sum_Root_to_Leaf_Numbers_129_not_all_way();
        System.out.println(a.sumNumbers(root));
    }
}
