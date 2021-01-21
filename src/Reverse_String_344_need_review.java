public class Reverse_String_344_need_review {
    //two pointers
    //简单双指针，p1和p2分别从头尾扫描分别交换
    //时间复杂度：O(s.length)
    //空间复杂度：O(1)
    public void reverseString(char[] s) {
        int p1 = 0;
        int p2 = s.length - 1;
        while(p1 < p2){
            swap(s,p1,p2);
            p1++;
            p2--;
        }
    }

    public void swap(char[] s, int i, int j){
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
