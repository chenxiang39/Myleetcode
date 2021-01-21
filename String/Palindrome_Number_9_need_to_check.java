public class Palindrome_Number_9_need_to_check {
    //two pointer
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        if (s.charAt(0) == '-'){        //第一个字符是"-"
            return false;
        }
        if (length == 1){       //只有一个数字
            return true;
        }
        if (s.charAt(length - 1) == '0'){     //最后一个字符为0
            return false;
        }
        int start = 0;
        int end = length - 1;
        while (end > start){
            if(s.charAt(end) != s.charAt(start)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome(10));
    }
}