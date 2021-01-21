import java.util.LinkedList;
import java.util.Queue;

public class Populating_Next_Right_Pointers_in_Each_Node_116_very_important_not_all_way {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
    //类似102
    //bfs
    //时间复杂度： O （N）因为我们每个节点只处理一次。请注意，在这种情况下处理节点意味着从队列中弹出节点，然后建立下一个指针。
    //空间复杂度： O （N）。这是一个完美的二叉树，这意味着最后一级包含N / 2节点。广度优先遍历的空间复杂度是队列占用的空间，它取决于特定级别节点的最大数量。因此，在这种情况下，空间复杂度为上为O（N）
    public static Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int amount = size;      //当前层还剩几个元素没有被遍历
            for(int i = 0; i < size; i++){
                Node aux = q.poll();
                amount--;
                if(amount == 0){            //如果是这一层最后的一个元素
                    aux.next = null;
                }
                else{               //否则next指向这层的下一个元素
                    aux.next = q.peek();        //peek的意思是检索但不删除此列表的头（第一个元素）。
                }
                if(aux.left!= null){
                    q.offer(aux.left);
                }
                if(aux.right!= null){
                    q.offer(aux.right);
                }
            }
        }
        return root;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(connect(root));
    }
}
