import java.util.*;

public class Clone_Graph_133_very_important_not_all_way {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    //bfs
    //leetcode approach 2
    // Time Complexity : O(N) since we process each node exactly once.
    // Space Complexity : O(N). This space is occupied by the visited dictionary and in addition to that,
    // space would also be occupied by the queue since we are adopting the BFS approach here.
    // The space occupied by the queue would be equal to O(W) where W is the width of the graph. Overall, the space complexity would be O(N).
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        // Put the first node in the queue
        q.offer(node);
        // Clone the first node and put it in the visited dictionary.
        map.put(node, new Node(node.val, new ArrayList()));
        //bfs
        while(!q.isEmpty()){
            Node cur = q.poll();
            // Iterate through all the neighbors of the node "cur"
            for(Node neighbor: cur.neighbors){
                // Clone the neighbor and put in the visited, if not present already
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // Add the newly encountered node to the queue.
                    q.offer(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "cur".
                map.get(cur).neighbors.add(map.get(neighbor));      //添加必定能成功，因为即使neighbor的neighbors ArrayList信息还不完善(与cur这个点已经无关，cur这个点的neighbor都已经加全),之后的遍历中都会逐步完善
            }
        }
        return map.get(node);
    }

}
