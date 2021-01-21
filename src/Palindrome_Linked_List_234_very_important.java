import java.util.Stack;

public class Palindrome_Linked_List_234_very_important {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public boolean isPalindrome(ListNode head) {
        //Use stack to check the element
        //n : the length of ListNode
        //Time complexity: O(n)
        //Space complexity: O(n)
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        int length = 0;
        while(p!= null){
            p = p.next;
            length++;
        }
        p = head;
        int count = 0;
        while(count < length / 2){
            stack.push(p.val);      //add element
            p = p.next;
            count++;
        }
        if(length % 2 == 1){
            p = p.next;
        }
        while(p!= null){
            //check element
            if(p.val == stack.peek()){
                stack.pop();
                p = p.next;
            }
            else{
                return false;
            }
        }
        return true;
    }

    //将后面部分进行反转再比较
    //n : the length of ListNode
    //Time complexity: O(n)
    //Space complexity: O(1)
    public boolean isPalindrome_2(ListNode head) {
        //corner case
        if(head == null){
            return true;
        }
        ListNode p = head;
        int length = 0;
        while(p!= null){
            p = p.next;
            length++;
        }
        p = head;
        int count = 1;
        while(count < length / 2){
            p = p.next;
            count++;
        }
        ListNode aux = p.next;
        //cut the back half of linkedlist
        p.next = null;
        //reverselinkedlist
        p = reverseLinkedList(aux);

        ListNode q = head;
        count = 0;
        //比较
        while(count < length / 2){
            if(q.val != p. val){
                return false;
            }
            q = q.next;
            p = p.next;
            count++;
        }
        return true;
    }

    public ListNode reverseLinkedList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur!= null){
            ListNode aux = cur.next;
            cur.next = pre;
            pre = cur;
            cur = aux;
        }
        return pre;
    }
}
