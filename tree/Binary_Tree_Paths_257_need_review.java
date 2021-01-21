import java.util.ArrayList;
import java.util.List;


public class Binary_Tree_Paths_257_need_review {
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
    //递归方法
    //n表示node的数量
    //时间复杂度：O(n)
    //空间复杂度：O(n),最坏情况下，一半情况是logn，表示深度，因为最后答案的数量等于叶子节点的数量，只看递归栈的深度
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        recursion(result, "", root);
        return result;
    }

    public void recursion(List<String> result, String str, TreeNode root){
        if(root != null){
            str += Integer.toString(root.val);
            if(root.left == null && root.right == null){
                result.add(str);
            }
            else{
                str += "->";
                recursion(result, str, root.left);
                recursion(result, str, root.right);
            }
        }
    }
}
