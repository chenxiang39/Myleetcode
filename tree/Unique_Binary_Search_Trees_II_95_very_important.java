import java.util.List;
import java.util.LinkedList;

public class Unique_Binary_Search_Trees_II_95_very_important {
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
    //https://www.bilibili.com/video/BV17i4y137xb?from=search&seid=10465512164201828715
    //https://www.cnblogs.com/springfor/p/3884029.html
    public  static List<TreeNode> generateTrees(int n) {
        if(n == 0){
            return new LinkedList<>();
        }
        return createTree(1,n);     //从1作为root开始，到n作为root结束
    }
    public static List<TreeNode> createTree(int start, int end){
        List<TreeNode> result = new LinkedList();
        if(start > end){
            result.add(null);
            return result;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> leftChild = createTree(start, i - 1);        //以i作为根节点，左子树由[1,i-1]构成，左子树都比i小
            List<TreeNode> rightChild = createTree(i + 1, end);         //右子树由[i+1, n]构成，右子树都比i大
            for(TreeNode left : leftChild){
                for(TreeNode right: rightChild){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);           //LinkedList添加速度快 //存储所有可能行
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(generateTrees(3));
    }
}
