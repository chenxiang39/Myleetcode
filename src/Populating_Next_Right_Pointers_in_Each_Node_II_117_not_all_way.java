import java.util.LinkedList;
import java.util.Queue;

//与116一样
public class Populating_Next_Right_Pointers_in_Each_Node_II_117_not_all_way {
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
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int amount = size;
            for(int i = 0; i < size; i++){
                Node aux = q.poll();
                amount--;
                if(amount == 0){
                    aux.next = null;
                }
                else{
                    aux.next = q.peek();
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
}
