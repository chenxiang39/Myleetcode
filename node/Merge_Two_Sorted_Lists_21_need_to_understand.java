import org.w3c.dom.NodeList;

public class Merge_Two_Sorted_Lists_21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    // My way
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode result = l3;
        while (l1 != null || l2!= null){
            if (l1 == null){         //l1 为 null就只加l2的内容
                l3.next = new ListNode(l2.val);
                l3 = l3.next;
                if (l2 != null){
                    l2 = l2.next;
                }
                continue;           //必须要加continue，结束添加后重新循环
            }
            if (l2 == null){
                l3.next = new ListNode(l1.val);
                l3 = l3.next;
                if (l1 != null){
                    l1 = l1.next;
                }
                continue;
            }
            if (l2.val > l1.val){           //小的内容加进l3;
                l3.next = new ListNode(l1.val);
                l3 = l3.next;
                if (l1 != null){
                    l1 = l1.next;
                }
                continue;
            }
            else {
                l3.next = new ListNode(l2.val);
                l3 = l3.next;
                if (l2 != null){
                    l2 = l2.next;
                }
                continue;
            }
        }
        return result.next;
    }
    //Recursive way
    public static ListNode mergeTwoLists_2(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next = mergeTwoLists_2(l1.next,l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists_2(l2.next,l1);
            return l2;
        }
    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(5);

        l4.next = l5;
        l5.next = l6;

        ListNode l7 = mergeTwoLists_2(l1, l4);
        while(l7!= null) {
            System.out.print(l7.val);
            l7 = l7.next;
        }
    }
}
