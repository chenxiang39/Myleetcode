import java.util.HashMap;

public class four_Sum_II_454_need_understand {
    //使用leetcode的solution
    //时间复杂度： O(n^2)
    //空间复杂度： O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        //key为A数组中的值和B数组中的值的所有可能和，value为和的出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : A){
            for(int b : B){
                if(!map.containsKey(a + b)){
                    map.put(a + b, 1);
                }
                else{
                    map.put(a + b, map.get(a + b) + 1);
                }
            }
        }
        for(int c : C){
            for(int d : D){
                //target表示c和d数组的和的相反数，如果这个相反数在map中存在，说明能匹配，result加上次数(map的value)
                int target = -(c + d);
                if(map.containsKey(target)){
                    result += map.get(target);
                }
            }
        }
        return result;
    }
}
