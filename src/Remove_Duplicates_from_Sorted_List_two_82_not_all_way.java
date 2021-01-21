public class Remove_Duplicates_from_Sorted_List_two_82_not_all_way {
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
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode start = head;
        ListNode end = head.next;
        ListNode beforestart = dummy;
        while(end!= null){
            if(start.val != end.val){
                beforestart = start;         //将start之前的指向start(跟随，有效节点,因为后面一个元素与这个元素不同)
                start = end;                //start指向下一个新元素
                end = end.next;             //end指向start的后面
            }
            else{
                while(end != null && start.val == end.val){     //遍历直到出现不一样的元素
                    end = end.next;
                }
                beforestart.next = end;         //将start之前的指向新出现的元素
                start = end;                //start指向新出现的元素
                if(end!= null){             //如果非null,不能忘！！！！！！！！！
                    end = end.next;             //end指向新出现元素（start）的后面一个元素
                }
            }
        }
        return dummy.next;
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
