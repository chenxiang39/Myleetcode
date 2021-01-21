import java.util.Arrays;
import java.util.Comparator;

//n: the length of nums
//Time complexity: O(nlogn), sort
//Space complexity: O(n),result
//给出一个数组，求用数组里的元素能组成的最大数。我们可以随便去两个元素来看：s1=782,s2=9,那么s1+s2=7829,s2+s1=9782,我们可以得到s2在s1前面得到的数一定比s1在s2前面打，
//所以，我们可以用s1+s2与s2+s1的大小判断哪个元素在前面。最后用一个stringbuilder记录
public class Largest_Number_179_need_review {
    private class LargerNumberComparator implements Comparator<String> {
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);    //将可以组合成更大的数的那一位放前面，降序
        }
    }
    public String largestNumber(int[] nums) {
        if(nums.length == 0){
            return " ";
        }
        StringBuilder result = new StringBuilder();
        String[] numsStr = new String[nums.length];
        for(int i = 0 ; i < nums.length; i++){
            numsStr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(numsStr,new LargerNumberComparator());
        //最大的为0说明这些数字都是0，所以直接返回0
        if(numsStr[0].equals("0")){
            return "0";
        }
        //直接按排好序的数字拼接
        for(int i = 0 ; i < numsStr.length; i++){
            result.append(numsStr[i]);
        }
        return result.toString();
    }
}
