public class Count_Complete_Tree_Nodes_222_need_review {
    public class TreeNode {
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
   //递归算个数
    //可以学习binary search的方法
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
