public class Reverse_Linked_List_206_very_very_important {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //使用前置指针
    //Time complexity : O(n). Assume that n is the list's length, the time complexity is O(n).
    //Space complexity : O(1).
    public ListNode reverseList_2(ListNode head) {
        ListNode pre = null;    //注意，必须是null，如果是新建的节点，则答案的结尾会多出节点导致错误
        ListNode cur = head;
        while(cur!= null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //递归
    //Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
    //Space complexity : O(n). The extra space comes from implicit stack space due to recursion. The recursion could go up to n levels deep.
    public ListNode reverseList(ListNode head) {
        //head == null的条件为了防止head直接为null
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);    //p不能进行以下操作，因为p是新链表的头，后面的操作只是构建链表，同时将head往前推
        head.next.next = head;      //下一个节点的下一个节点指向本身(反转)
        head.next = null;       //删除原来顺序的链接
        return p;           //返回构建好的链表，如果重新进入循环，则表示还没退回到head
    }
}
