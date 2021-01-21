public class Closest_Binary_Search_Tree_Value_270_need_review {
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
    //二分查找，target比当前值小时就去左子树查找，否则就去右子树
    //时间复杂度： O(h),h为树的高度，不是logN是因为树可能不是平衡的
    //空间复杂度是O(1)
    public int closestValue(TreeNode root, double target) {
        int result = root.val;
        while(root != null){
            //比较差值并更新
            if((double)Math.abs(root.val - target) < (double)Math.abs(result - target)){
                result = root.val;
            }
            if(root.val > target){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        return result;
    }
}
