import java.util.Stack;

public class Kth_Smallest_Element_in_a_BST_230_need_review {
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
    //中序遍历，类似94，根据次序来输出
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            if(root!= null && root.left != null){
                root = root.left;
                stack.push(root);
            }
            else{
                root = stack.pop();
                //每pop一个，k就减1，当减到0时就返回，因为BST按中序遍历正好是从小到大排布
                k--;
                if(k == 0){
                    return root.val;
                }
                if(root.right != null){
                    root = root.right;
                    stack.push(root);
                }
                else{
                    root = null;
                }
            }
        }
        return root.val;
    }
}
