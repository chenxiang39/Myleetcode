import java.util.HashMap;

public class Two_Sum_III_Data_structure_design_170_not_all_way {
    //空间复杂度：O(n),n是the total number of unique numbers
    HashMap<Integer,Integer> map = new HashMap<>();     //使用HashMap记录元素及其出现的次数
    public Two_Sum_III_Data_structure_design_170_not_all_way() {

    }
    //时间复杂度: O(1)
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number)){
            map.put(number, map.get(number) + 1);
        }
        else{
            map.put(number, 1);
        }
    }
    //时间复杂度: O(n),n是the total number of unique numbers
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int i : map.keySet()){
            int T = value - i;
            if(T == i){         //缺的是相同的元素
                if(map.get(i) >= 2){        //查看是否出现两次及以上
                    return true;
                }
                else{
                    continue;       //继续遍历
                }
            }
            if(map.containsKey(T)){
                return true;
            }
        }
        return false;
    }
}
