import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Right_Side_View_199_need_review_very_important {
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
    //时间复杂度：O(N),N为节点数
    //空间复杂度：O(D),D为树中一层中可能包含的节点数的最大值（直径）
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        //一层一层的bfs
        //保存一层中最后的节点的值，因为是从左到右开始出队列
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode aux = q.poll();
                //最右边
                if(i == size - 1){
                    result.add(aux.val);
                }
                if(aux.left!= null){
                    q.offer(aux.left);
                }
                if(aux.right!= null){
                    q.offer(aux.right);
                }
            }
        }
        return result;
    }
}
