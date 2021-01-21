import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists_23_very_important {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //like 148
    //Use MinPQ
    public ListNode mergeKLists(ListNode[] lists) {
        //Time complexity: O(NlogK),  k is the number of linked lists, where N is the total number of nodes
        //Space complexity: O(1)
        //这种解法利用了最小堆这种数据结构，首先把k个链表的首元素都加入最小堆中，它们会自动排好序。
        //然后每次取出最小的那个元素加入最终结果的链表中，然后把取出元素的下一个元素再加入堆中，下次仍从堆中取出最小的元素做相同的操作，
        //以此类推，直到堆中没有元素了，此时k个链表也合并为了一个链表，返回首节点即可，
        PriorityQueue<ListNode> minPQ = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(ListNode head: lists){
            if(head != null){           //防止空节点加入堆
                minPQ.offer(head);
            }
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(!minPQ.isEmpty()){
            ListNode aux = minPQ.peek().next;       //取出元素的下一个元素
            temp.next = minPQ.poll();       //时间复杂度：O(logK)
            if(aux!=null){
                minPQ.offer(aux);       //把取出元素的下一个元素再加入堆中
            }
            temp.next.next = null;      //切断加入元素后面的链表
            temp = temp.next;
        }
        return dummy.next;
    }

    //Like MergeSort
    //Time complexity: O(NlogK),  k is the number of linked lists, where N is the total number of nodes
    //Space complexity: O(1)
    public ListNode mergeKLists_2(ListNode[] lists) {
        //corner case
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = sort(lists, 0, lists.length -1);
        return dummy.next;
    }
    public ListNode sort(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode l = sort(lists, left, mid);
        ListNode r = sort(lists, mid + 1, right);
        return merge(l, r);
    }

    public ListNode merge(ListNode l, ListNode r){
        ListNode dummy = new ListNode();
        ListNode aux = dummy;
        while(l!= null && r!= null){
            if(l.val < r.val){
                ListNode temp = l.next;
                l.next = null;
                aux.next = l;
                aux = aux.next;
                l = temp;
            }
            else{
                ListNode temp = r.next;
                r.next = null;
                aux.next = r;
                aux = aux.next;
                r = temp;
            }
        }
        while(l!= null){
            ListNode temp = l.next;
            l.next = null;
            aux.next = l;
            aux = aux.next;
            l = temp;
        }
        while(r!= null){
            ListNode temp = r.next;
            r.next = null;
            aux.next = r;
            aux = aux.next;
            r = temp;
        }
        return dummy.next;
    }
}
