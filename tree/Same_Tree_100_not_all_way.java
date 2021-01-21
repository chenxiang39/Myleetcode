public class Same_Tree_100_not_all_way {
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
    //Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
    //Space complexity : O(log(N)) in the best case of completely balanced tree(除了底下两层，都是双节点) and (N) in the worst case of completely unbalanced tree(都是单节点), to keep a recursion stack.
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){         //都为null, 表示一样
            return true;
        }
        else{
            if(p == null || q == null){         //一个是null，一个不为null
                return false;
            }
        }
        if(p.val != q.val){
            return false;
        }
        //如果这层没有false,继续下一层,直到最后一层，开始一层一层向上返回结果
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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
        System.out.println(isSameTree(root,root2));
    }
}
