import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal_94_very_important {
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
    //中序遍历
    //https://www.jianshu.com/p/4d85f858c41a
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursion(result,root);
        return result;
    }
    private void recursion(List<Integer> result, TreeNode T){
        if(T == null){
            return;
        }
        recursion(result, T.left);
        result.add(T.val);
        recursion(result,T.right);
    }

    //非递归解法
    public static List<Integer> inorderTraversal_2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode aux = root;
        while(!stack.isEmpty()){
            //只要你有左孩子，就将左孩子压入栈中
            if(aux!= null && aux.left!= null){
                aux = aux.left;
                stack.add(aux);
            }
            else{
                aux = stack.pop();      //弹出栈顶节点  左孩子--->根节点
                result.add(aux.val);
                if(aux.right!= null){     //如果栈点元素有右孩子的话，将有节点压入栈中
                    aux = aux.right;
                    stack.add(aux);
                }
                else{
                    aux = null;  //aux = stack.pop; 已经访问过p了，aux为最后的子节点了，无左子树和右子树
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        inorderTraversal_2(root);
    }
}
