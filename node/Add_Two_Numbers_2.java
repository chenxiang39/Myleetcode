public class Add_Two_Numbers_2 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {

        }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //Time complexity : O(max(m,n)), Assume that m and n represents the length of l1 and l2 respectively
    //Space complexity: O(max(m,n), The length of the new list is at most max(m,n) + 1 .
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode l3 = new ListNode(0);
            ListNode answer = l3;        //记录头部
            int l1Val,l2Val = 0;
            int carry = 0;//表示进位
            int sum; //将插入新链表的数
            while (l1 != null || l2 != null){
                if (l1 == null){
                    l1Val = 0;       //少位数则设置为0
                }
                else {
                    l1Val = l1.val;
                }
                if (l2 == null){
                    l2Val = 0;       //少位数则设置为0
                }
                else {
                    l2Val = l2.val;
                }
                sum = l1Val + l2Val + carry;
                carry = sum/10;  //和大于等于10则进位
                sum = sum%10;    //得出答案
                l3.next = new ListNode(sum);
                l3 = l3.next;
                if (l1 != null){
                    l1 = l1.next;
                }
                if (l2 != null){
                    l2 = l2.next;
                }
            }
            if(carry>0){
                l3.next=new ListNode(carry); //判断需不需要再来一个节点
            }
            return answer.next ; //从头部下一位开始遍历
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l4.next = l5;
        l5.next = l6;

        ListNode l7 = addTwoNumbers(l1, l4);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
