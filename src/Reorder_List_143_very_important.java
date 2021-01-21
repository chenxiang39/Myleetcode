public class Reorder_List_143_very_important {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //分三步处理问题
    //找到中间节点（若非正中间则取后面一个）
    //将后半部分的链表逆转
    //将两部分链表合并
    //Time complexity: O(N). There are three steps here. To identify the middle node takes O(N) time.
    //To reverse the second part of the list, one needs N/2 operations.
    //The final step, to merge two lists, requires N/2 operations as well. In total, that results in O(N) time complexity.

    //Space complexity: O(1), since we do not allocate any additional data structures.
    public void reorderList(ListNode head) {
        //find middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow => middle node

        //reverse middle node to tail node
        ListNode pre = null;
        ListNode cur = slow;
        ListNode temp = cur;
        while(cur!= null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        //merge two list
        ListNode firstNode = head;
        ListNode secondNode = pre;
        ListNode firstAux;
        ListNode secondAux;
        while(firstNode != secondNode && firstNode.next!= secondNode){
            firstAux = firstNode.next;
            secondAux = secondNode.next;
            firstNode.next = secondNode;
            secondNode.next = firstAux;
            firstNode = firstAux;
            secondNode = secondAux;
        }
    }
}
