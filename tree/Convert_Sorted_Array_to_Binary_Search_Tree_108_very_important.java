public class Convert_Sorted_Array_to_Binary_Search_Tree_108_very_important {
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
    //Time complexity: O(N) since we visit each node exactly once.
    //Space complexity: O(N). O(N) to keep the output, and O(logN) for the recursion stack.
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(0, nums.length - 1, nums);
    }
    private TreeNode recursion(int left, int right, int[] nums){
        if(left > right){
            return null;
        }
        // always choose left middle node as a root
        int r = (left + right) / 2;
        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[r]);
        root.left = recursion(left , r - 1,nums);
        root.right = recursion(r + 1, right, nums);
        return root;
    }
}
