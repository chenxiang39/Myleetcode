import java.util.ArrayList;
import java.util.List;

public class Path_Sum_112_not_all_way {
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
    //dfs
    //分析详见113
    public static boolean hasPathSum(TreeNode root, int sum) {
        List<List<TreeNode>> result = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        dfs(result,cur, root, sum);
        return !result.isEmpty();     //看是否存在路径
    }
    //寻找路径
    private static void dfs(List<List<TreeNode>> result, List<TreeNode> cur, TreeNode root, int sum){
        if(root == null){
            return;
        }
        sum = sum - root.val;
        cur.add(root);
        if(sum == 0){
            //和到了，并且已经遍历到叶子结点了，加入path
            if(root.left == null && root.right == null){
                result.add(new ArrayList(cur));
                return;
            }
        }
        //继续遍历
        if(root.left!= null){
            dfs(result, cur, root.left, sum);
            cur.remove(cur.size() - 1);     //还原
        }
        if(root.right!= null){
            dfs(result, cur, root.right, sum);
            cur.remove(cur.size() - 1);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = null;
        root.right.right = new TreeNode(5);
        System.out.println(hasPathSum(root,7));
    }
}
