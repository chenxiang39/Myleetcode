import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal_144_very_important {
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
    //recursive way
    //时间复杂度：O(n)
    //空间复杂度：O(n)
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            return result;
        }
        result.add(root.val);
        if(root.left!= null){
            preorderTraversal(root.left);
        }
        if(root.right!= null){
            preorderTraversal(root.right);
        }
        return result;
    }
    //非递归解法,使用stack存储，同时先存储右边节点，再存储左边节点，这样能做到先把根节点和左边节点先遍历完
    List<Integer> result_2 = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    public List<Integer> preorderTraversal_2(TreeNode root) {
        if (root == null) {
            return result_2;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode aux = stack.pop();     //每次取一个栈顶部的节点
            result_2.add(aux.val);
            if (aux.right != null) {
                stack.push(aux.right);
            }
            if (aux.left != null) {
                stack.push(aux.left);
            }

        }
        return result_2;
    }
}
