import java.util.LinkedList;
import java.util.Queue;

public class Maximum_Depth_of_Binary_Tree_104_very_important {
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
    public int maxDepth(TreeNode root) {
        int result = 0;
        if(root == null){
            return result;
        }
        //BFS
        //类似102题
        //时间复杂度：O(n)
        //空间复杂度：O(2的(logN −1)次方)= O(N/2) = O(N),
        // i.e. the maximum number of nodes at the same level (the number of leaf nodes in a full binary tree),
        // since we traverse the tree in the BFS manner.
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size;i++){
                TreeNode aux = q.poll();
                if(aux.left!= null){
                    q.offer(aux.left);
                }
                if(aux.right!= null){
                    q.offer(aux.right);
                }
            }
            result++;           //逐层遍历，存在则加1
        }
        return result;
    }
}
