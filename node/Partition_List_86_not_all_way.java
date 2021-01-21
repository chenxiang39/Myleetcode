public class Partition_List_86_not_all_way {
    //Time Complexity: O(N), where N is the number of nodes in the original linked list and we iterate the original list.
    //Space Complexity: O(N), storage listNode
    //my way
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static ListNode partition(ListNode head, int x) {
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode();
        ListNode aux = dummy;               //存储应该被放入存储链表元素之前的元素（方便删除应该放入存储链表的元素）
        ListNode dummyaux = dummy;
        dummy.next = head;
        ListNode storage = new ListNode();      //存储应该放在后面的元素列表
        ListNode s = storage;                   //存储链表的头
        ListNode pointer = head;
        while(pointer != null){
            if(pointer.val < x){
                aux = pointer;
                pointer = pointer.next;
            }
            else{
                storage.next = new ListNode(pointer.val);   //将大于等于x的元素存入存储链表
                storage = storage.next;
                if(pointer!= null && aux!= null){
                    aux.next = pointer.next;        //删掉存进存储链表的元素
                }
                pointer = pointer.next;
            }
        }
        while (dummyaux.next!= null){
            dummyaux = dummyaux.next;
        }

        dummyaux.next = s.next;     //接入存储链表
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = partition(l1,0);
        while (l7 != null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
