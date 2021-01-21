public class Reverse_Nodes_in_k_Group_25_very_important {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //https://www.cnblogs.com/springfor/p/3864530.html
    //Time complexity: O(n);   n : the length of list
    //Space complexity: O(1);
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null && head.next == null){
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        int pointer = 0;
        while(cur!= null){
            pointer++;
            cur = cur.next;
            if(pointer == k){
                pre = reverse(pre,cur);
                pointer = 0;
            }
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode result = last;
        ListNode cur = last.next;
        pre.next = null;
        while(cur != next){
            ListNode aux = cur.next;
            cur.next = last;
            last = cur;
            cur = aux;
        }
        pre.next = last;
        result.next = next;
        return result;
    }
}
