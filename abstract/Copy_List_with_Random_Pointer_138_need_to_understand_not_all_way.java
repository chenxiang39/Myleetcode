import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Copy_List_with_Random_Pointer_138_need_to_understand_not_all_way {
    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //类似133,此处用Map保存访问过的节点，key为原节点，value为新的复制节点
    //Time complexity : O(n),n为节点个数
    //Space complexity : O(n), HashMap
    static HashMap<Node,Node> isVis = new HashMap<>();
    public static Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node original = head;
        while(original != null){
            Node copy = copyNode(original);
            copy.next = copyNode(original.next);
            copy.random = copyNode(original.random);
            original = original.next;
        }
        return isVis.get(head); //返回head的复制节点
    }
    private static Node copyNode(Node originNode){
        if(originNode == null){
            return null;
        }
        //出现过的就返回
        if(isVis.containsKey(originNode)){
            return isVis.get(originNode);
        }
        //没出现过的就建新节点并添加进Map
        else{
            Node copyNode = new Node(originNode.val);
            isVis.put(originNode,copyNode);
            return copyNode;
        }
    }

    //other way
    //Time complexity: O(the length of list), actually two loops;
    //Space complexity: O(the length of list) ==> HashMap
    //https://www.bilibili.com/video/BV1UA411J775
    public Node copyRandomList_2(Node head) {
        HashMap<Node,Node> isVis = new HashMap<>();     //key ==> original node, value ==> new node
        Node cur = head;

        //loop1 : create all new node that only contain val;
        while(cur != null){
            isVis.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        //loop2 : accroding to original list, we use the same new created node to point, in order to add next and random in new nodes;
        while(cur!= null){
            isVis.get(cur).next = isVis.get(cur.next);
            isVis.get(cur).random = isVis.get(cur.random);
            cur = cur.next;
        }

        return isVis.get(head);
    }
    public static void main(String[] args){
        Node l1 = new Node(7);
        Node l2 = new Node(13);
        Node l3 = new Node(11);
        Node l4 = new Node(10);
        Node l5 = new Node(1);
        Node l6 = null;
        l1.next = l2;
        l1.random = null;
        l2.next = l3;
        l2.random = l1;
        l3.next = l4;
        l3.random = l5;
        l4.next = l5;
        l4.random = l3;
        l5.next = l6;
        l5.random = l1;

        Node l7 = copyRandomList(l1);
        while(l7!= null) {
            System.out.println(l7.val);
            l7 = l7.next;
        }
    }
}
