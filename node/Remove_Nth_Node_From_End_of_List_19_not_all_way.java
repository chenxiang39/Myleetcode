public class Remove_Nth_Node_From_End_of_List_19_not_all_way {
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int Index = 0;          //记录节点的下标
        int all = 0;            //记录节点的总个数
        ListNode aux = head;     //记录头部
        ListNode aux1 = head;     //记录头部(遍历使用)
        while (aux1!=null){
            aux1 = aux1.next;
            all++;
        }
        if (n == all){          //如果要删除头节点
            head = head.next;
        }
        while(Index < all - (n + 1)){
            aux = aux.next;     //让aux移动到target(需要被删除的节点)节点的前一个
            Index++;
        }
        ListNode T = aux.next;      //T为要被删除的节点
        if(aux.next!= null){
            aux.next = T.next;
        }
        else {
            aux.next = null;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = removeNthFromEnd(l1,1);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}