import java.util.Stack;

public class Add_Two_Number_two_445_need_review {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    //reverse list, then solution like Leetcode 2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode l3 = new ListNode();
        ListNode result = l3;
        int carry = 0;
        while(l1 != null || l2 != null){
            int l1V;
            int l2V;
            if(l1 == null){
                l1V = 0;
            }
            else{
                l1V = l1.val;
                l1 = l1.next;
            }
            if(l2 == null){
                l2V = 0;
            }
            else{
                l2V = l2.val;
                l2 = l2.next;
            }
            int sum = l1V + l2V + carry;
            l3.val = sum % 10;
            carry = sum/10;
            if(l1 == null && l2 == null){
                break;
            }
            l3.next = new ListNode();
            l3 = l3.next;
        }
        if(carry != 0){
            l3.next = new ListNode(carry);
        }
        return reverse(result);
    }

    //leetcode 206
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    //Use stack
    //needn't reverse list
    public ListNode addTwoNumbers_2(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        int result = 0;
        int v1 = 0;
        int v2 = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(s1.isEmpty()){
                v1 = 0;
            }
            else{
                v1 = s1.pop();
            }
            if(s2.isEmpty()){
                v2 = 0;
            }
            else{
                v2 = s2.pop();
            }
            result = v1 + v2 + carry;
            carry = result / 10;
            stack.push(result % 10);
        }
        if(carry!= 0){
            stack.push(carry);
        }
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while(!stack.isEmpty()){
            temp.next = new ListNode(stack.pop());
            temp = temp.next;
        }
        return dummy.next;
    }
}
