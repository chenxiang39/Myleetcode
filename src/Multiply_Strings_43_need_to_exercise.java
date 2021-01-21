public class Multiply_Strings_43_need_to_exercise {
    //https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
    //99 * 99 ，res数组变化
    //Before -> [0, 0, 0, 0]    0 + 81 = 81
    //After -> [0, 0, 8, 1]
    //=================
    //Before -> [0, 0, 8, 1]        8 + 81 = 89
    //After -> [0, 8, 9, 1]
    //=================
    //Before -> [0, 8, 9, 1]        9 + 81 = 90
    //After -> [0, 17, 0, 1]
    //=================
    //Before -> [0, 17, 0, 1]   17 + 81 = 98
    //After -> [9, 8, 0, 1]
    public static String multiply(String num1, String num2) {
        int num1size = num1.length();
        int num2size = num2.length();
        int [] res = new int[num1size + num2size];
        for (int i = 0; i < num1size + num2size; i++){
            res[i] = 0;
        }
        for (int i = num2.length() - 1; i >= 0; i--){       //必须大于等于0
            for(int j = num1.length() - 1; j >= 0; j--){
                int product = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = product + res[p2] ;       //由链接里的图可知，上一位的进位的位置位于下一个数的原本的位的位置
                res[p1] += sum / 10;     //进位      pos [p1]可以是大于10的整数。但是当算法在以下循环中进行运算时，它将获得正确的数字，即pos [p1]％10。问题是它将始终得到纠正。
                res[p2] = sum % 10;      //原本的位
            }
        }
        StringBuilder result = new StringBuilder();
        boolean flag = false;       //是否允许开始计数
        for (int i = 0 ; i < res.length; i++){
            if(!flag && res[i] == 0){       //开头的0，则不放进result

            }
            else {
                flag = true;            //一旦出现非0，则开始计数，后面即使有0也要加入
                result.append(res[i]);
            }
        }
        return flag? result.toString() : "0";       //是否result存入了非0元素
    }
    public static void main(String[] args){
        System.out.println(multiply("99","99"));
    }
}
