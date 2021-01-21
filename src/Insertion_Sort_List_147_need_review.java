public class Insertion_Sort_List_147_need_review {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //https://www.cnblogs.com/springfor/p/3862468.html
    //pre始终指向sorted list的fakehead，cur指向当前需要被插入的元素，next指向下一个需要被插入的元素。
    public static ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        ListNode pre = result;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            pre = result;   //还原到开头
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }
            //cur插到pre和pre.next之间
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return result.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2147483646);
        ListNode l2 = new ListNode(2147483647);
        ListNode l3 = new ListNode(2147483647);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        char a = 'A';
        System.out.println(Integer.valueOf(a));
        ListNode l7 = insertionSortList(l1);
        while(l7!= null) {
            System.out.println(l7.val);
            l7 = l7.next;
        }
    }
}
