import java.util.*;

public class shipping_center {
    public static String shippingCenter(char[][] pairs){
        StringBuilder res = new StringBuilder();
        HashMap<Character, ArrayList> graph = new HashMap<>();
        TreeMap<Character, Integer> node = new TreeMap<>();
        for(char[] pair: pairs){
            char start = pair[0];
            char end = pair[1];
            if(!graph.containsKey(start)){
                ArrayList<Character> list = new ArrayList<>();
                list.add(end);
                graph.put(start, list);
            }
            else{
                ArrayList<Character> list = graph.get(start);
                list.add(end);
                graph.put(start,list);
            }
            if(!graph.containsKey(end)){
                ArrayList<Character> list = new ArrayList<>();
                graph.put(end, list);
            }
            node.put(start, node.getOrDefault(start,0));
            node.put(end,node.getOrDefault(end,0) + 1);
        }
        for(char c : node.keySet()){
            if(node.get(c) == 0){
                res.append(c);
                res.append(":");
                bfs(graph, c, res);
                res.append("\n");
            }
        }
        return res.toString();
    }
    //bfs
    public static void bfs(HashMap<Character, ArrayList> graph, char c, StringBuilder res){
        Queue<Character> q = new LinkedList<>();
        q.offer(c);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                char cur = q.poll();
                ArrayList<Character> list = graph.get(cur);
                if(list.size() == 0){
                    res.append(cur);
                    res.append(" ");
                }
                else {
                    for (Character charc : list) {
                        if (!q.contains(charc)) {
                            q.offer(charc);
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        char[][] pairs = {
                {'A','B'},
                {'A','C'},
                {'B','K'},
                {'C','K'},
                {'E','L'},
                {'F','G'},
                {'J','M'},
                {'E','F'},
                {'G','H'},
                {'G','I'},
        };
        System.out.println(shippingCenter(pairs));
    }
}
