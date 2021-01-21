import java.util.*;

//Arrays.sort()根据入参类型选择以下排序算法
//基本类型数组使用快速排序
//对象数组使用归并排序
//合并排序的时间复杂度是n*logn, 快速排序的平均时间复杂度也是n*logn，但是归并排序的需要额外的n个引用的空间

public class Group_Anagrams_49_need_to_understand {
    //my way (brute force)
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {      //null的字符跳过
                continue;
            }
            List<String> cur = new ArrayList<>();
            List<Character> hasAppearedChar = new ArrayList<>();        //记录出现的字符
            List<Character> aux = new ArrayList<>();
            for (int j = 0; j < strs[i].length(); j++) {                //放进Arraylist
                hasAppearedChar.add(strs[i].charAt(j));
                aux.add(strs[i].charAt(j));
            }
            int strlength = strs[i].length();
            cur.add(strs[i]);
            strs[i] = null;         //添加过的字符设置成null
            //搜索其他组成字符一样的字符串
            for (int j = i + 1; j < strs.length; j++){
                if(strs[j] == null || strs[j].length() != strlength){
                    continue;                           //遇到null和长度不等的跳过检查
                }
                else {
                    //检查字符
                    for (int q = 0; q < strs[j].length(); q++) {
                        if(!hasAppearedChar.remove((Character)strs[j].charAt(q))){
                            hasAppearedChar = new ArrayList<>(aux);             //必须用new的方式开对象，否则当hasAppearedChar改变了，aux也会改变
                            break;
                        }
                    }
                    if(hasAppearedChar.isEmpty()){
                        cur.add(strs[j]);
                        strs[j] = null;         //已经记录的字符设置成null
                        hasAppearedChar = new ArrayList<>(aux);
                    }
                }
            }
            result.add(cur);
        }
        return result;
    }
    //categorize by Sorted String
    //Time Complexity: O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs. The outer loop has complexity O(N) as we iterate through each string. Then, we sort each string in O(KlogK) time.
    //Space Complexity: O(NK), the total information content stored in ans.
    public static List<List<String>> groupAnagrams_2(String[] strs){
        Map<String,List> map = new HashMap<>();     //需要用String,如果用char[]，即使内容一样，也会判不等
        for (int i = 0; i < strs.length;i ++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            //字符串顺序排序好以后，看是否相同
            String st = String.valueOf(c);              //将char数组转换成String
            if(!map.containsKey(st)){
                List<String> cur = new ArrayList<>();
                cur.add(strs[i]);
                map.put(st,cur);
            }
            else {
                map.get(st).add(strs[i]);
            }
        }
        return new ArrayList(map.values());             //不是ArrayList<>(map.values)!!!!!!!!!!!!!!!!!!
    }
    public static void main(String[] args){
        String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
        char[] c = {'e','a','t'};
        System.out.println(String.valueOf(c));
        System.out.println(c.toString());
        System.out.println(groupAnagrams_2(strs));
    }
}
