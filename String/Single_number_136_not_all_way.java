import java.util.HashSet;

public class Single_number_136_not_all_way {
    //空间复杂度：O(n) , n为nums数组的长度
    //时间复杂度：O(n)
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            //遇到重复的移出set
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        int result = 0;
        //此时set中只有那个不重复的元素
        for(Integer i : set){
            result = i;
        }
        return result;
    }
}
