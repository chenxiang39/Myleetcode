public class Rotate_List_61_not_all_way {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //not good way (Time Limit Exceeded)
    public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next== null){
            return head;
        }
        ListNode willFinalNode;
        ListNode T = head;
        while (k > 0){
            willFinalNode = head;
            while (willFinalNode.next.next!= null){
                willFinalNode = willFinalNode.next;
            }
            T = new ListNode(willFinalNode.next.val);
            willFinalNode.next = null;
            T.next = head;
            head = T;
            k--;
        }
        return head;
    }
    //could accepted
    public static ListNode rotateRight_2(ListNode head, int k) {
        if(head == null || head.next== null){
            return head;
        }
        int length = 1;             //计算ListNode的有效节点数
        ListNode finalNode = head;
        ListNode dummy = head;
        //O(n), n => Number of nodes
        while(finalNode.next != null){
            finalNode = finalNode.next;
            length++;
        }
        k = k % length;
        int needGenerate = length - k;     //要生成的节点数
        //O(n)
        for (int i = 0; i < needGenerate;i++){
            ListNode x = new ListNode(dummy.val);
            finalNode.next = x;             //在最后的点之后生成之前的新的节点
            dummy = dummy.next;             //dummy向后推，将起点改变
            finalNode = finalNode.next;
        }
        return dummy;           //从dummy开始计算
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = null;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode l7 = rotateRight_2(l1, 2);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
