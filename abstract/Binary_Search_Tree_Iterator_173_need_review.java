import java.util.Stack;

public class Binary_Search_Tree_Iterator_173_need_review {
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
    // class BSTIterator {
//     //中序遍历，空间复杂度不符合要求
//     LinkedList<Integer> q ;
//     public BSTIterator(TreeNode root) {
//         q = new LinkedList<>();
//         insertIntoQ(root);
//     }
//     private void insertIntoQ(TreeNode root){
//         if(root == null){
//             return;
//         }
//         insertIntoQ(root.left);
//         q.offer(root.val);
//         insertIntoQ(root.right);
//     }
//     /** @return the next smallest number */
//     public int next() {
//         return q.poll();
//     }

    //     /** @return whether we have a next smallest number */
//     public boolean hasNext() {
//         return q.size() != 0;
//     }
// }
    class BSTIterator {
        //leetcode solution动画的思想
        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            insertLeft(root);
        }
        //只保存左孩子进栈（空间复杂度为O(h)）
        private void insertLeft(TreeNode root){
            if(root == null){
                return;
            }
            stack.push(root);
            insertLeft(root.left);
        }
        /** @return the next smallest number */
        //出栈的时候加入该点的右孩子部分(以右孩子为根节点遍历左孩子)，以此达到空间复杂度为O(h)的效果，h为树的高度
        public int next() {
            TreeNode target = stack.pop();
            insertLeft(target.right);
            return target.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return stack.size() != 0;
        }
    }
}
