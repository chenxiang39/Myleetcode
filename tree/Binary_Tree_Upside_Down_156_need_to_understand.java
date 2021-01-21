public class Binary_Tree_Upside_Down_156_need_to_understand {
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
    //专注于左节点
    //时间复杂度为O(h)，h为树的高度
    //空间复杂度为O(1)
    //https://blog.csdn.net/whuwangyi/article/details/43186045
    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null){
            return root;
        }
        //层层遍历找到最左边的节点，开始自低向上构建
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        //顺时针旋转
        TreeNode left = root.left;      //例子中的y
        TreeNode right = root.right;    //例子中的z
        root.left = null;               //root ==>  例子中的x，是传入的参数
        root.right = null;
        left.left = right;      //y的左边指向z
        left.right = root;      //y的右边指向x
        //处理完后返回
        return newRoot;
    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        TreeNode result = upsideDownBinaryTree(root);
    }
}
