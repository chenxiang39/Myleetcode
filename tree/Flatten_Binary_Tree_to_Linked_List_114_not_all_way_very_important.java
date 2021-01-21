public class Flatten_Binary_Tree_to_Linked_List_114_not_all_way_very_important {
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
    // recursion way
    // Time Complexity: O(N) since we process each node of the tree exactly once.
    // Space Complexity: O(N) which is occupied by the recursion stack.
    // The problem statement doesn't mention anything about the tree being balanced or not and hence,
    // the tree could be e.g. left skewed and in that case the longest branch (and hence the number of nodes in the recursion stack) would be N.
    public static void flatten(TreeNode root){
        root = recursion(root);
    }
    public static TreeNode recursion(TreeNode root){
        // Handle the null scenario
        if(root == null){
            return null;
        }
        // For a leaf node, we simply return the
        // node as is.
        if(root.left == null && root.right == null){
            return root;
        }
        // Recursively flatten the left subtree
        TreeNode leftTrail = recursion(root.left);
        // Recursively flatten the right subtree
        TreeNode rightTrail = recursion(root.right);
        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side anymore.
        if(leftTrail != null){
            leftTrail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // We need to return the "rightmost" node after we are
        // done wiring the new connections.
        return rightTrail == null ? leftTrail : rightTrail;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = null;
        flatten(root);
    }
}
