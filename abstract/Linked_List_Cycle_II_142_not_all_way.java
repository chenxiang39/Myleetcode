import java.util.HashSet;

public class Linked_List_Cycle_II_142_not_all_way {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //利用HashSet,类似141，时间复杂度和空间复杂度都是O(n)
    public ListNode detectCycle(ListNode head) {
        ListNode dummy = head;
        HashSet<ListNode> set = new HashSet<>();
        while(dummy!= null){
            if(!set.contains(dummy)){
                set.add(dummy);
            }
            else{
                return dummy;
            }
            dummy = dummy.next;
        }
        return null;
    }
}
