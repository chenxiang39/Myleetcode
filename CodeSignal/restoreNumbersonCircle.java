import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=671915&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3086%5D%5Bvalue%5D%3D11%26searchoption%5B3086%5D%5Btype%5D%3Dradio%26searchoption%5B3089%5D%5Bvalue%5D%5B5%5D%3D5%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3090%5D%5Bvalue%5D%3D2%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline
public class restoreNumbersonCircle {
    public static int[] restorenumbersoncircle(ArrayList<int[]> pairs){
        int length = pairs.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int[] pair : pairs){
            int start = pair[0];
            int end = pair[1];
            if(!map.containsKey(start) && !map.containsValue(end)){
                map.put(start,end);
            }
            else if(map.containsKey(start)){
                map.put(end,start);
            }
            else if(map.containsValue(end)){
                map.put(end,start);
            }
        }
        int count = 0;
        int[] result = new int[length];
        int pointer = 1;
        while(count < length){
            result[count] = map.get(pointer);
            pointer = result[count];
            count++;
        }
        return result;
    }
    public static void main(String[] args) {
        ArrayList<int[]> pairs = new ArrayList<>();
        int[] a = {3,5};
        int[] b = {1,4};
        int[] c = {2,4};
        int[] d = {1,5};
        int[] e = {2,3};
        pairs.add(a);
        pairs.add(b);
        pairs.add(c);
        pairs.add(d);
        pairs.add(e);
        int[] r = restorenumbersoncircle(pairs);
        for(int i : r){
            System.out.println(i);
        }
    }
}
