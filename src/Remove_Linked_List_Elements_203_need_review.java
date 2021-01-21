public class Remove_Linked_List_Elements_203_need_review {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time complexity: O(N), it's one pass solution.
    //Space complexity: O(1), it's a constant space solution.
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();        //设置一个节点指向head
        dummy.next = head;
        ListNode pre = dummy;       //前节点
        while(head != null){
            if(head.val == val){        //如果当前节点的值与val相等
                pre.next = head.next;   //前一个节点直接连到后一个节点
                head = head.next;       //搜寻节点指向下一个
                continue;
            }
            head = head.next;       //值不相等的情况就同时前进(pre默认是head前一个节点)
            pre = pre.next;
        }
        return dummy.next;
    }
}
