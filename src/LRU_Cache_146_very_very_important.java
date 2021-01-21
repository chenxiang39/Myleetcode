import java.util.HashMap;

public class LRU_Cache_146_very_very_important {
    //Use LinkedHashMap,介绍：https://www.jianshu.com/p/8f4f58b4b8ab
//    class LRUCache extends LinkedHashMap<Integer,Integer> {
//        int capacity;
//        public LRUCache(int capacity) {
//            super(capacity, 0.75F, true);
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return super.getOrDefault(key, - 1);
//        }
//
//        public void put(int key, int value) {
//            super.put(key,value);
//        }
//        //当size超过容量时，删除最老的节点
//        protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
//            return size() > capacity;
//        }
//    }

    //DoubleLinkedList + HashMap
    //Time complexity : O(1) both for put and get.
    //Space complexity : O(capacity) since the space is used only for a hashmap and double linked list with at most capacity + 1 elements.
        public class DoubleLinkedNode{      //双向链表节点
            int key;            //key
            int val;            //value
            DoubleLinkedNode pre;  //指向前节点
            DoubleLinkedNode next;  //指向后节点
            public DoubleLinkedNode(){}
            public DoubleLinkedNode(int key, int val){
                this.key = key;
                this.val = val;
            }
        }
        //always add node after head
        private void addNode(DoubleLinkedNode node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
        //removeNode
        private void removeNode(DoubleLinkedNode node){
            DoubleLinkedNode preNode = node.pre;
            preNode.next = node.next;
            preNode.next.pre = preNode;
        }
        //move node to head(after head)
        private void moveToHead(DoubleLinkedNode node){
            removeNode(node);       //先删除
            addNode(node);          //再添加，因为默认添加到head之后
        }
        //pop tail node(before tail)
        private DoubleLinkedNode popTail(){
            DoubleLinkedNode aux = tail.pre;
            removeNode(aux);
            return aux;
        }
        private HashMap<Integer,DoubleLinkedNode> map = new HashMap<>();       //保存key值和对应的双端链表的节点(map中的DoubleLinkedNode互相连接)
        private DoubleLinkedNode head;          //连接着map中的链表, 设置虚拟头和尾节点，防止出错
        private DoubleLinkedNode tail;          //连接着map中的链表
        private int capacity;
        private int size;       //当前链表的节点数
        public LRU_Cache_146_very_very_important(int capacity) {
            this.capacity = capacity;
            size = 0;
            head = new DoubleLinkedNode();
            tail = new DoubleLinkedNode();
            //初始化时头节点与尾节点互相连接
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DoubleLinkedNode node = map.get(key);
            if(node == null){
                return -1;
            }
            moveToHead(node);   //访问过的点移到前面
            return node.val;
        }

        public void put(int key, int value) {
            DoubleLinkedNode node = map.get(key);
            if(node == null){
                DoubleLinkedNode T = new DoubleLinkedNode(key,value);
                addNode(T);
                map.put(key,T);
                size++;
                //如果超过容量，则删除最后的尾节点（因此最大的时间复杂度是capacity + 1）
                if(capacity < size){
                    DoubleLinkedNode needToRemove = popTail();      //输出需要移除的尾部节点
                    map.remove(needToRemove.key);               //从map中移除该节点
                    size--;
                }
            }
            //已经存在该点，则更新值，并放到头部
            else{
                node.val = value;
                moveToHead(node);
            }
        }
        public static void main(String[] args){
            LRU_Cache_146_very_very_important cache = new LRU_Cache_146_very_very_important(3);
            cache.put(1,1);
            cache.put(2,2);
            cache.put(3,3);
            cache.put(4,4);
            System.out.println(cache.get(1));
            System.out.println(cache.get(4));
            System.out.println(cache.get(3));
        }
}
