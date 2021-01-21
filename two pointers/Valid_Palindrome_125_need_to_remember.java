import java.util.Stack;

//not good way(浪费空间)
//时间复杂度: O(N)
//空间复杂度：O(N),使用了stack
public class Valid_Palindrome_125_need_to_remember {
    public static boolean isPalindrome(String s) {
        int length = 0;
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){          //判断字符是否是数字和字母
                length++;
            }
        }
        int count = 0;
        boolean needJump = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                if(count < length/2){
                    stack.push(s.charAt(i));
                    count++;
                }
                else {
                    if(length % 2 == 1 && count == length / 2 && needJump){
                        needJump = !needJump;
                        continue;
                    }
                    if(!isEqual(s.charAt(i),stack.pop())){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    //two pointer(省空间)
    //时间复杂度: O(N)
    //空间复杂度：O(1)
    public static boolean isPalindrome_2(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            if(!Character.isLetterOrDigit(s.charAt(start))){        //判断字符是否是数字和字母
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            if(!isEqual(s.charAt(start),s.charAt(end))){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
    private static boolean isEqual(char a,char b){
        if(!Character.isUpperCase(a)){
            a = Character.toUpperCase(a);
        }
        if(!Character.isUpperCase(b)){
            b = Character.toUpperCase(b);
        }
        return a == b;
    }
    public static void main(String[] args){
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
