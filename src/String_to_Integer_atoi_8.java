//trim() 方法用于删除字符串的头尾空白符。
//java中的单引号表示字符,java中的双引号是字符串。
//单引号引的数据一般是char类型的;双引号引的数据是String类型的。
public class String_to_Integer_atoi_8 {
    public static int myAtoi(String str){
        //Time complexity : O(str.length)
        //Space complexity: O(str.length) ==> StringBuilder
            if(str.length() == 0){
                return 0;
            }
            //remove whitespace from both ends of str
            str = str.trim();
            int isNeg = 1;
            StringBuilder result = new StringBuilder();

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                //if the first character is '-' ,that means this number is negative
                if(c == '-' && i == 0){
                    isNeg = -1;
                    continue;
                }
                //if the first character is '+' ,that means this number is positive
                else if(c == '+' && i == 0){
                    continue;
                }
                // c is not the Integer, stop append character
                if(c - '0' < 0 || c - '0' > 9){
                    break;
                }
                else{
                    result.append(c);
                }
            }

            //Use double to prevent overflow
            double r = 0;
            //dont't append any valid number
            if(result.length() == 0){
                return (int)r;
            }
            else{
                r = isNeg * Double.parseDouble(result.toString());
            }
            if(r > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(r < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }

            return (int)r ;
    }
    public static void main(String[] args){
        System.out.println(myAtoi("1 1d"));
    }
}
