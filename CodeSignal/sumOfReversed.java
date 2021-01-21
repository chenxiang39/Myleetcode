import java.util.LinkedList;
import java.util.Queue;

public class sumOfReversed {
    public static int sumOfreversed(int[] arr){
        int result = 0;
        for(int i : arr){
            result += reverse(i);
        }
        return result;
    }
    public static int reverse(Integer num){
        String str = num.toString();
        int result = 0;
        int zeroLength = 0;
        while (num!= 0 && num % 10 == 0){
            zeroLength++;
            num = num / 10;
        }
        for(int i = 0; i < str.length(); i++){
            result += (str.charAt(i) - '0') * Math.pow(10, i);
        }
        //末尾补0
        if(zeroLength != 0){
            result = result * (int)Math.pow(10, zeroLength);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {7,234,58100};
        System.out.println(sumOfreversed(arr));
    }
}
