import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103_very_important {
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
    //类似102题
    //时间复杂度：O(n)
    //空间复杂度：O(n)，最坏情况下是n/2,叶子结点的最大宽度
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        //注意！！！！！！
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> cur = new ArrayList<>();
        q.offer(root);
        //bfs
        boolean isReverse = false;
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
            if(isReverse){
                Collections.reverse(cur);       //对cur元素进行反转，https://www.yiibai.com/java/util/collections_reverse.html
            }
            result.add(new ArrayList(cur));     //注意！！！！类似40题
            cur.clear();
            isReverse = !isReverse;         //翻转flag变化
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(root));
    }
}
