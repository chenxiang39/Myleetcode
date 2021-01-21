import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105_need_to_understand {
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
    // https://www.bilibili.com/video/BV1R5411s7Zw
    // 时间复杂度和空间复杂度都为O(n), n为树的节点数
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < preorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, HashMap<Integer, Integer> inorderMap){
        if(pstart > pend){
            return null;
        }
        if(pstart == pend){
            return new TreeNode(preorder[pstart]);
        }

        TreeNode root = new TreeNode(preorder[pstart]);
        int leftRange = inorderMap.get(preorder[pstart]) - istart;

        TreeNode left = build(preorder, pstart + 1, pstart + 1 + leftRange - 1, inorder, istart, inorderMap.get(preorder[pstart]) - 1, inorderMap);

        TreeNode right = build(preorder, pstart + 1 + leftRange - 1 + 1, pend, inorder, inorderMap.get(preorder[pstart]) + 1, iend, inorderMap);

        root.left = left;
        root.right = right;
        return root;
    }
}
