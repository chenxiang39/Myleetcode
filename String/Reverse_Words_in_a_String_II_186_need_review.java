public class Reverse_Words_in_a_String_II_186_need_review {
    //先翻转全部的序列，再翻转一个个单词(使用双指针对单词进行扫描)
    //Time complexity: O(N), it's two passes along the string.
    //Space complexity: O(1), it's a constant space solution.
    public void reverseWords(char[] s) {
        reverse(0, s.length - 1,s);     //先翻转全部的序列
        int start = -1;     //一个单词的开始的指针
        int end = -1;       //一个单词的末尾的指针
        for(int i = 0; i < s.length ; i++){
            if(s[i] == ' '){
                if(start == - 1 && end == -1){      //如果双指针没有指向任何单词就跳过
                    continue;
                }
                reverse(start,end,s);               //否则就将指向的单词翻转（遇到了新的空格，将老的单词翻转，除非到了最后却没有空格的情况）
                start = -1;                         //双指针重新还原
                end = - 1;
            }
            else{
                if(start == -1){                //如果开始指针没开始指
                    start = i;                  //赋值
                    end = i;                    //末尾指针赋值
                }
                else{
                    end++;                      //开始指针有值，末尾的指针向后遍历，记录剩下的字母
                    if(end == s.length - 1){        //如果末尾指针到了结尾，此时必须反转并且结束
                        reverse(start,end,s);          //翻转
                    }
                }
            }
        }
    }
    public void reverse(int start, int end, char[] s){
        while (start < end){
            char aux = s[start];
            s[start] = s[end];
            s[end] = aux;
            start++;
            end--;
        }
    }
}
