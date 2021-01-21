public class Excel_Sheet_Column_Number_171_need_to_remember {
    //时间复杂度：O(N), N is the number of characters in the input string.
    //空间复杂度：O(1)
    public static int titleToNumber(String s) {
        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            //注意：Integer.valueOf需要使用字串才能进行ASCII码转换
            result += (Integer.valueOf(s.charAt(s.length() - 1 - i)) - 64) * Math.pow(26, i);       //按字符串的左到右的顺序乘以26的i次方求和
        }
        return result;
    }
    public static void main(String[] args){
        String s = "AB";
        System.out.println(titleToNumber(s));
    }
}
