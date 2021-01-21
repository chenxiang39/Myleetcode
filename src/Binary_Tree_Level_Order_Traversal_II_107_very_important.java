import java.util.*;

public class Binary_Tree_Level_Order_Traversal_II_107_very_important {
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
    //bfs
    //最后翻转结果就行，类似102
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode aux = q.poll();
                cur.add(aux.val);
                if(aux.left!= null){
                    q.offer(aux.left);
                }
                if(aux.right!= null){
                    q.offer(aux.right);
                }
            }
            result.add(new ArrayList(cur));
            cur.clear();
        }
        Collections.reverse(result);
        return result;
    }
}
