import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
//是一个hashmap + heap的题。给一个array of strings，找出现次数最多的string。如果两个string的frequency相同，按照alphabetical的顺序返回大的string。
//Example: products = [‘redShirt’, ‘greenPants’, ‘redShirt’, ‘orangeShoes’, ‘blackPants’, ‘blackPants’]
//Return: 'redshirt'
public class aaa {
    public static String a(String[] strs){
        HashMap<String, Integer> map = new HashMap<>();
        for(String str : strs){
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        PriorityQueue<String> maxPQ = new PriorityQueue<String>(
                (a,b)->{
                    if(map.get(a) != map.get(b)){
                        return map.get(b) - map.get(a);
                    }
                    else{
                        return b.compareTo(a);
                    }
                }
        );
        for(String key : map.keySet()){
            maxPQ.offer(key);
        }
        return maxPQ.peek();
    }
    public static void main(String[] args){
        String[] str = {"redShirt","greenPants","redShirt","orangeShoes","blackPants","blackPants"};
        System.out.println(a(str));
    }
}
