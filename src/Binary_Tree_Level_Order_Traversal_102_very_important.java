import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_102_very_important {
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
    //BFS
    //Time complexity : O(N) since each node is processed exactly once.
    //Space complexity: O(N), result => all nodes,Queue and cur is dynamic
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //注意！！！！
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();     //LinkedList：https://www.cnblogs.com/qinyuguan/p/11420022.html
        q.offer(root);
        List<Integer> cur = new ArrayList<>();
        while(!q.isEmpty()){
            int size = q.size();        //size表示一层的数量
            //一层一层遍历,cur保存一层的节点
            for(int i = 0; i < size; i++){
                TreeNode aux = q.poll();        //将一层的所有节点poll出
                cur.add(aux.val);
                if(aux.left!= null){
                    q.offer(aux.left);          //下一层的点进队列
                }
                if(aux.right!= null){
                    q.offer(aux.right);
                }
            }
            result.add(new ArrayList(cur));
            cur.clear();        //添加完后清除该层的节点
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(levelOrder(root));
    }
}
