import java.util.HashSet;
public class Linked_List_Cycle_141_need_to_understand {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    //HashSet, n: the size of List
    //Time complexity: O(n), We visit each of the n elements in the list at most once. Adding a node to the hash table costs only O(1) time.
    //Space complexity: O(n), The space depends on the number of elements added to the hash table, which contains at most n elements.
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> isVis = new HashSet();
        while(head != null){
            if(!isVis.contains(head)){
                isVis.add(head);
            }
            else{
                return true;
            }
            head = head.next;
        }
        return false;
    }
    //two pointer
    //时间复杂度分析见leetcode,为O(n)
    //空间复杂度：O(1)
    public boolean hasCycle_2(ListNode head) {
        //想象有两个跑步者，一个一次移动一步，另一个两步，如果循环，则两者最终会相遇，如果不循环，则快的跑步者先到终点
        ListNode slow = head;   //慢速移动
        ListNode fast = head;   //快速移动
        while (fast != null && fast.next != null) {
            slow = slow.next;    //一次移动一步
            fast = fast.next.next;      //一次移动两步
            if (slow == fast) {         //如果相遇
                return true;
            }
        }
        return false;
    }
}
