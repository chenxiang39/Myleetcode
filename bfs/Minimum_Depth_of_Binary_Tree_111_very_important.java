import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Depth_of_Binary_Tree_111_very_important {
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
    //类似102，bfs
    //Time complexity : in the worst case for a balanced tree we need to visit all nodes level by level up to the tree height, that excludes the bottom level only. This way we visit N/2 nodes, and thus the time complexity is O(N).
    //Space complexity : in the worst case we could keep up to the entire tree, that results in O(N) space complexity.
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int result = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean mustStop = false;
        while(!q.isEmpty()){
            int size = q.size();
            //层序遍历
            for(int i = 0; i < size; i++){
                TreeNode aux = q.poll();
                if(aux.left == null && aux.right == null){      //一旦发现某一层出现节点没有左右节点，则是最浅的深度，标记停止
                    mustStop = true;
                }
                else{
                    if(aux.left != null){
                        q.offer(aux.left);
                    }
                    if(aux.right != null){
                        q.offer(aux.right);
                    }
                }
            }
            if(mustStop){           //标记停止，退出循环
                break;
            }
            else{
                result++;          //继续遍历
            }
        }
        return result;
    }

}
