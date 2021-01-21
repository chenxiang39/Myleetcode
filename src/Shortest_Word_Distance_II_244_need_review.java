import java.util.ArrayList;
import java.util.HashMap;

public class Shortest_Word_Distance_II_244_need_review {
    //key为字符串，value为出现的位置的集合
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    public Shortest_Word_Distance_II_244_need_review(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }
            else{
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(words[i],list);
            }
        }
    }
    //双循环遍历
    public int shortest(String word1, String word2) {
        ArrayList w1 = map.get(word1);
        ArrayList w2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < w1.size();i++){
            for(int j = 0; j < w2.size();j++){
                int dis = Math.abs((Integer) w1.get(i) - (Integer) w2.get(j));
                result = Math.min(result, dis);
            }
        }
        return result;
    }
    //双指针遍历
    public int shortest_2(String word1, String word2) {
        ArrayList w1 = map.get(word1);
        ArrayList w2 = map.get(word2);

        int result = Integer.MAX_VALUE;
        int p1 = 0;
        int p2 = 0;
        while(p1 < w1.size() && p2 < w2.size()){
            //由于已经按大小排序了，因此只要根据大小，将指针推进，因为更大的减固定值，不会比原来的值减固定值小(距离不会减少，因此将小的值增大，减少之间的距离)
            result = Math.min(result, Math.abs((Integer)w1.get(p1) - (Integer)w2.get(p2)));
            if((Integer)w1.get(p1) > (Integer)w2.get(p2)){
                p2++;
            }
            else{
                p1++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        Shortest_Word_Distance_II_244_need_review obj = new Shortest_Word_Distance_II_244_need_review(words);
        int param_1 = obj.shortest(word1,word2);
        System.out.println(param_1);
    }
}
