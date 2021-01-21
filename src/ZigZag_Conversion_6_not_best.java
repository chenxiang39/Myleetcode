import java.util.ArrayList;
import java.util.List;
//String：适用于少量的字符串操作的情况（速度慢）
//StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况 （线程不安全，速度最快）(此处选择StringBuilder)
//StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况

//时间复杂度分析：https://blog.csdn.net/xiaoxixixiyang/article/details/40377187

//Time Complexity: O(n), where n == len(s)
//Space Complexity: O(n)
public class ZigZag_Conversion_6_not_best {
    public static String convert(String s, int numRows){
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();       //输出结果的行单元（按列表存储一行的字符）
        for (int i = 0; i < Math.min(s.length(),numRows); i++){
            rows.add(new StringBuilder());          //保存行数
        }
        boolean goDown = false; //遍历是否朝下
        int currentRow = 0; //查找的行数
        for(int Index = 0; Index < s.length(); Index ++){
            rows.get(currentRow).append(s.charAt(Index));       //对应的字符放到对应的行数中     O(1)操作
            if (currentRow == numRows - 1 || currentRow == 0){      //到底部或者顶部时，方向改变
                goDown = !goDown;       //刚开始，通过转换为向下
            }
            if (goDown){
                currentRow++;
            }
            else {
                currentRow--;
            }
        }
        StringBuilder answ = new StringBuilder();
        for (StringBuilder row : rows){
            answ.append(row);       //把每行的内容拼在一起
        }
        return answ.toString();
    }
    public static void main(String[] args){
        System.out.print(convert("abcdefgh",3));

    }
}
