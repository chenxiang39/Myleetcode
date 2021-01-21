import java.util.HashMap;

public class Fraction_to_Recurring_Decimal_166_very_review {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        //特殊情况
        if(numerator == 0){
            return "0";
        }
        if (numerator < 0 ^ denominator < 0){               //异或运算，相同为false(0),不同为true(1)
            result.append("-");
        }
        long num = numerator;
        long deno = denominator;
        //需要全部转换成long型再进行绝对值转化，使用int会出现溢出
        num = Math.abs(num);
        deno = Math.abs(deno);
        result.append(String.valueOf(num / deno));
        long remainder = num % deno;
        if(remainder == 0){
            return result.toString();
        }
        result.append(".");
        HashMap<Long, Integer> map = new HashMap<>();   //记录余数与其出现的位置，若出现重复，则在其之前插入"(",最后插入")",表示无限循环
        while(remainder != 0){
            if(map.containsKey(remainder)){
                result.insert(map.get(remainder),"(");
                result.append(")");
                break;          //无限循环需要退出
            }
            //记录每一次余数出现的位置
            map.put(remainder, result.length());
            remainder = remainder * 10;
            result.append(String.valueOf(remainder / deno));
            remainder = remainder % deno;
        }
        return result.toString();
    }
}
