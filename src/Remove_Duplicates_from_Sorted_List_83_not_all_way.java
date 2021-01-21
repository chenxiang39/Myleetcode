public class Remove_Duplicates_from_Sorted_List_83_not_all_way {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //my way
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode dummy = head;
        ListNode start = head;
        ListNode end = head.next;
        while(end != null){
            if(start.val != end.val){
                start = end;
                end = end.next;
            }
            else {
                while (end != null && end.val == start.val){    //跳过重复的元素
                    end = end.next;
                }
                start.next = end;           //连接新的元素
                start = end;                //start切换到新元素
                if(end!= null){             //不能忘！！！！！
                    end = end.next;         //end继续向后
                }
            }
        }
        return dummy;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        l1.next = l2;
//        l2.next = l3;
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);
//        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;

        ListNode l7 = deleteDuplicates(l1);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
