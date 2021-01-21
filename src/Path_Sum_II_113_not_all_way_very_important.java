import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113_not_all_way_very_important {
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
    //Time Complexity: O(N^2)
    //where NN are the number of nodes in a tree.
    // In the worst case, we could have a complete binary tree and if that is the case, then there would be N/2 leafs.
    // For every leaf, we perform a potential O(N) operation of copying over the pathNodes nodes to a new list to be added to the final pathsList.
    // Hence, the complexity in the worst case could be O(N^2)

    // Space Complexity: O(N). The space complexity, like many other problems is debatable here.
    // I personally choose not to consider the space occupied by the output in the space complexity.
    // So, all the new lists that we create for the paths are actually a part of the output and hence, don't count towards the final space complexity.
    // The only additional space that we use is the pathNodes list to keep track of nodes along a branch.
    // We could include the space occupied by the new lists (and hence the output) in the space complexity and in that case the space would be O(N^2)
    // There's a great answer on Stack Overflow about whether to consider input and output space in the space complexity or not. I prefer not to include them.
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(result, cur, root, sum);
        return result;
    }
    //寻找路径
    private void dfs(List<List<Integer>> result,List<Integer> cur,TreeNode root, int sum){
        if(root == null){
            return;
        }
        cur.add(root.val);
        sum = sum - root.val;
        //和到了，并且已经遍历到叶子结点了，加入path
        if(sum == 0){
            if(root.left == null && root.right == null){
                result.add(new ArrayList(cur));
                return;
            }
        }
        //继续遍历
        if(root.left!= null){
            dfs(result, cur, root.left, sum);
            cur.remove(cur.size() - 1);
        }
        if(root.right!= null){
            dfs(result, cur, root.right, sum);
            cur.remove(cur.size() - 1);
        }
    }
}
