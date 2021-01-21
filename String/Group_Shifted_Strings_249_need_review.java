import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group_Shifted_Strings_249_need_review {
    //https://www.cnblogs.com/grandyang/p/5204770.html
    //思路： 用hashmap存储，key是除了第一个字母之后的每个字母离第一个字母的距离（比如 abc 和 efg 互为偏移，对于 abc 来说，b和a的距离是1，c和a的距离是2，
    // 对于 efg 来说，f和e的距离是1，g和e的距离是2。再来看一个例子，az 和 yx，z和a的距离是 25，x和y的距离也是 25 (直接相减是 -1，这就是要加 26 然后取余的原因)，
    // 那么这样的话，所有互为偏移的字符串都有个 unique 的距离差，根据这个来建立映射就可以很好的进行单词分组了，），value是分组
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String str : strings){
            StringBuilder sb = transfer(str);
            if(map.containsKey(sb.toString())){
                ArrayList<String> list = map.get(sb.toString());
                list.add(str);
            }
            else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(), list);
            }
        }

        for(Map.Entry<String, ArrayList<String>> entry : map.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }
    //分析距离
    public StringBuilder transfer(String str){
        StringBuilder res = new StringBuilder();
        if(str.length() == 1){
            res.append("0");
            return res;
        }
        char first = str.charAt(0);
        for(int i = 1; i < str.length(); i++){
            int diff = str.charAt(i) - first;
            if(diff < 0){
                diff += 26;
            }
            res.append(String.valueOf(diff));
            res.append(" ");    //防止出现 "1" + "2" == "12"，每个数字之间加空格
        }
        return res;
    }
}
