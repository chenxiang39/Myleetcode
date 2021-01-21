import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

//https://www.jianshu.com/p/a3f59d366c91
//3 to the n => 3的n次方
//Time complexity: O(3^N * 4^M), where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8)
//and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N + M is the total number digits in the input.
//Space complexity: O(3^N * 4^M) since one has to keep 3^N * 4^M solutions;
public class Letter_Combinations_of_a_Phone_Number_17 {
    public static List<String> letterCombinations(String digits) {
        // 数字与字母的对应关系
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> answ = new ArrayList<>();
        if(digits.isEmpty())
            return answ;
        // 图中树的根节点
        answ.add("");

        // 遍历输入的数字
        for(char c : digits.toCharArray()){
            answ = combine(map[c-'0'], answ);
        }
        return answ;
    }

    // 根据数字组合字母
    private static List<String> combine(String digits, List<String> list){
        List<String> aux = new ArrayList<>();
        for(char c : digits.toCharArray()){
            for(String s : list){
                aux.add(s + c);
            }
        }
        return aux;
    }

    //dfs
    private static void dfs(String digits , Map<Character, Character[]> Map ,int level, List<String> result, StringBuilder current){
        //截止条件
        if (level == digits.length() ){
            result.add(current.toString());
            return;
        }
        //截止条件
        if(!Map.containsKey(digits.charAt(level))) {        //不存在的话，return
            return;
        }
        //遍历候选节点
        for (int i = 0 ; i < Map.get(digits.charAt(level)).length ; i++){
            char a = Map.get(digits.charAt(level))[i];      //候选字符
            current.append(a);
            dfs(digits, Map, level + 1, result, current);
            current.deleteCharAt(current.length() - 1);     //删除已经插入的点的最后一位，因为最后一位会有多种可能，例如ab,ac,ad中的"b","c","d",之所以有这一步，是因为输出的时候是current.toString(),为新的对象,故需要此步骤，且此步骤不会影响current.toString()的值（与39题不同），如果直接用String，也不需要此步骤
        }
    }
    public static List<String> letterCombinations_2(String digits) {
        Map<Character, Character[]> Map = new HashMap<>();
        Map.put('2',new Character[] {'a','b','c'});
        Map.put('3',new Character[] {'d','e','f'});
        Map.put('4',new Character[] {'g','h','i'});
        Map.put('5',new Character[] {'j','k','l'});
        Map.put('6',new Character[] {'m','n','o'});
        Map.put('7',new Character[] {'p','q','r','s'});
        Map.put('8',new Character[] {'t','u','v'});
        Map.put('9',new Character[] {'w','x','y','z'});
        List<String> result = new ArrayList<>();
        if(digits.length() == 0){
            return result;
        }
        dfs(digits, Map ,0, result,new StringBuilder());
        return result;
    }

    public static void main(String[] args){
        System.out.println(letterCombinations_2("24"));
    }
}
