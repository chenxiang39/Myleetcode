import java.util.Comparator;
import java.util.PriorityQueue;

public class Sort_List_148_very_important {
    //Use min PriorityQueue;
    //Time complexity: O(NlogN); N => the number of nodes in list
    //Space complexity: O(N)
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });

        //put all nodes into minPQ;
        while(head != null){
            ListNode aux = head.next;
            head.next = null;
            minPQ.add(head);
            head = aux;
        }

        //get nodes and create new linked;

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while(!minPQ.isEmpty()){
            temp.next = minPQ.poll();
            temp = temp.next;
        }

        return dummy.next;
    }
    //merge
    //Time complexity: O(NlogN); N => the number of nodes in list
    //Space complexity: O(1)
    public ListNode sortList_2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        // step 1. cut the list to two halves
        ListNode pre = null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;        //分割
        // step 2. sort each half
        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        //merge
        return merge(l,r);
    }

    public ListNode merge(ListNode l, ListNode r){
        //set dummy node because we don't know which node is the head node
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(l != null && r!= null){
            if(l.val < r.val){
                temp.next = l;
                l = l.next;
            }
            else{
                temp.next = r;
                r = r.next;
            }
            temp = temp.next;
        }
        if(l != null){
            temp.next = l;
        }
        if(r != null){
            temp.next = r;
        }
        return dummy.next;
    }
}
