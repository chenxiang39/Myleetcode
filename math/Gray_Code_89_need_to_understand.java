import java.util.ArrayList;
import java.util.List;

public class Gray_Code_89_need_to_understand {
    //my way
    //如果n = 1，那么编码为[0, 1]；
    //
    //n = 2，编码为[00, 01, 11, 10]；
    //
    //n = 3，编码为[000, 001, 011, 010, 110, 111, 101, 100]；
    //前半部分跟上一个一样，后半部分是前一半基础上倒转，然后在最前面加个1
    //时间复杂度：O(n * n),因为每个n都要计算size,等差数列求和
    //空间复杂度：O(1)
    public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if(n == 0){
            result.add(0);
            return result;
        }
        if(n == 1){
            result.add(0);
            result.add(1);
            return result;
        }
        result.addAll(grayCode(n-1));       //加前半部分
        int size = result.size();
        int offset = (int)Math.pow(2,n - 1);        //最前面加1的意思是直接加2的n-1次方
        int sum;
        for (int i =  0 ; i < size; i++){
            sum = result.get(size - 1 - i) + offset;
            result.add(sum);
        }
        return result;
    }
    public static void main(String[] args){
        System.out.println(grayCode(4));
    }
}
