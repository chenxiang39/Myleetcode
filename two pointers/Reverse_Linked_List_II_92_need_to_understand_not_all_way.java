public class Reverse_Linked_List_II_92_need_to_understand {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //递归，双指针，对值进行交换
    //Time Complexity: O(N) since we process all the nodes at-most twice. Once during the normal recursion process and once during the backtracking process. During the backtracking process we only just swap half of the list if you think about it, but the overall complexity is O(N).
    //Space Complexity: O(N) in the worst case when we have to reverse the entire list. This is the space occupied by the recursion stack.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        recursion(head,m,n);
        return head;
    }
    private void recursion(ListNode head, int m, int n){
        ListNode start = head;
        ListNode end = head;
        int count = 1;
        if(m >= n){     //指针交叉后停止
            return;
        }
        while(count < m){
            start = start.next;
            count++;
        }
        count = 1;
        while(count < n){
            end = end.next;
            count++;
        }
        int aux = start.val;        //创建新对象，方便交换
        start.val = end.val;
        end.val = aux;
        recursion(head, m + 1, n - 1);
    }
}
