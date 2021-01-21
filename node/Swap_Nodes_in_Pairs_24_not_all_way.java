public class Swap_Nodes_in_Pairs_24_not_all_way {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        if (head == null || head.next == null ){
            return head;
        }
        while (head != null){
            {
                //先将head的next节点保存下来
                if (head.next != null){     //如果head.next节点为空，则不做下面操作
                    ListNode a = new ListNode(head.next.val);
                    dummy.next = a;         //赋值
                    head.next = head.next.next;     //将head的next节点转到原来next节点的next节点（删除原来next节点）
                    dummy = dummy.next;             //dummy继续遍历
                }
            }
            //先将head节点保存下来
            {
                ListNode b = new ListNode(head.val);
                dummy.next = b;     //赋值
                head = head.next;       //将head节点转到next节点（初始的head.next.next节点）
                dummy = dummy.next;     //dummy继续遍历
            }
        }
        return result.next;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l3.next = l4;
        l4.next = l5;
//        l5.next = l6;

        ListNode l7 = swapPairs(l1);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
