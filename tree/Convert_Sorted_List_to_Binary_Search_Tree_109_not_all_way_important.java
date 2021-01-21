import java.util.ArrayList;

public class Convert_Sorted_List_to_Binary_Search_Tree_109_not_all_way {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
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
    //类似108，区别在于将链表转换成了数组
    public TreeNode sortedListToBST(ListNode head) {
        ListNode dummy = head;
        ArrayList<Integer> h = new ArrayList<>();
        //转换成Arraylist
        while(head!= null){
            h.add(head.val);
            head = head.next;
        }
        return recursion(0,h.size() - 1,h);
    }
    public TreeNode recursion(int start,int end, ArrayList<Integer> h){
        if(start > end){
            return null;
        }
        int i = (start + end)/2;
        TreeNode aux = new TreeNode(h.get(i));
        aux.left = recursion(start, i - 1,h);
        aux.right = recursion(i + 1, end,h);
        return aux;
    }
}
