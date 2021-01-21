import java.util.HashSet;

public class Intersection_of_Two_Linked_Lists_160_need_review {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    //Set
    //n: the length of A, m: the length of B
    //Time complexity: O(n + m)
    //Space complexity : O(m) or O(n)
    //将a链表的所有节点存进set,再对比b和set,如果包含，则输出结果，因为后面的节点都相同了
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;
        while(a != null){
            set.add(a);
            a = a.next;
        }
        while(b != null){
            if(set.contains(b)){
                return b;
            }
            b = b.next;
        }
        return null;
    }
}
