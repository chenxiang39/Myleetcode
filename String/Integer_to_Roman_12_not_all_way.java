import java.util.HashMap;
import java.util.Map;

public class Integer_to_Roman_12_not_all_way {
    public static String intToRoman(int num) {
       String[] Str = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
       int[] values = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
       StringBuilder answ = new StringBuilder();
       if (num < 1 || num > 3999){
           return "";
       }
       for (int i = Str.length - 1; i >= 0; i--){       //从大到小遍历，找到符合的数字
           while (num > 0){     //不断拼凑
               int val = num - values[i];
               if (val < 0){        //小于0则立刻退出，换成更小的数字进行计算
                   break;
               }
               answ.append(Str[i]);
               num = val;
           }
           if (num == 0){
               break;       //得到结果后退出
           }
       }
       return answ.toString();
    }
    public static void main(String[] args){
        System.out.println(intToRoman(4));
    }
}
