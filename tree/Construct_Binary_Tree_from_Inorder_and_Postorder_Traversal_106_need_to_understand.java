import java.util.HashMap;
public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal_106_need_to_understand {
    //https://www.bilibili.com/video/BV1w54y1i7iN
    //时间复杂度和空间复杂度都为O(n), n为树的节点数
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inorderMap);
    }

    public TreeNode build(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend,  HashMap<Integer, Integer> inorderMap){
        if(pstart > pend){
            return null;
        }
        if(pstart == pend){
            return new TreeNode(postorder[pend]);
        }

        TreeNode root = new TreeNode(postorder[pend]);
        int leftRange = inorderMap.get(postorder[pend]) - istart;

        TreeNode left = build(inorder, istart, inorderMap.get(postorder[pend]) - 1, postorder, pstart, pstart + leftRange - 1, inorderMap);

        TreeNode right = build(inorder, inorderMap.get(postorder[pend]) + 1, iend, postorder, pstart + leftRange, pend - 1, inorderMap);

        root.left = left;
        root.right = right;
        return root;
    }
}
