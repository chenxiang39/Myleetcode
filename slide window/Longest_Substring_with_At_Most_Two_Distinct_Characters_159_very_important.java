import java.util.Collections;
import java.util.HashMap;

public class Longest_Substring_with_At_Most_Two_Distinct_Characters_159_very_important {
    //slide window
    //思想在leetcode中有动画
    //Time complexity : O(N) where N is a number of characters in the input string.
    //Space complexity : O(1) since additional space is used only for a hashmap with at most 2 elements.
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();       //key是字符，value是该字符出现在字符串中最右边的位置
        int result = 0;
        int left = 0;
        int right = 0;
        while(right <= s.length() - 1){
            //如果出现了新的没被记录的字符
            if(!map.containsKey(s.charAt(right))){
                if(map.size() == 2){
                    int del_pos = Collections.min(map.values());        //把map最左边的元素删除
                    map.remove(s.charAt(del_pos));
                    left = del_pos + 1;                 //更新最左边指针为最左边元素(最左边元素需要被删除)的后一位
                }
                map.put(s.charAt(right), right);        //将新节点加入map
            }
            else{
                map.put(s.charAt(right),right);         //更新map中的点的位置，使其一直保持在最右边的位置
            }
            //left和right指针对应了两个字符组成的字符串的范围（窗口）
            result = Math.max(result, right - left + 1);            //结果是最右边指针减去最左边指针 + 1的最大值
            right++;                    //右边指针向右探索
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstringTwoDistinct("aa"));
    }
}
