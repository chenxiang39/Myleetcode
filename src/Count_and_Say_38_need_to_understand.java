public class Count_and_Say_38_need_to_understand {
    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append('1');         //初始化自带1
        result = recursive(1,result,n);
        return result.toString();
    }
    private static StringBuilder recursive(int level, StringBuilder cur, int n){
        //level到达n,则退出函数返回结果
        if (level == n){
            return cur;
        }
        int count = 0;
        StringBuilder result = new StringBuilder();
        Character point = cur.charAt(0);        //搜索指针
        for (int i = 0; i <= cur.length();i++){         //需要有等于号，需要循环到最后
            //如果已经扫描到底或者扫描到不一样的字符串
            if (i == cur.length() || cur.charAt(i) != point){
                result.append(count);       //将出现的次数计入结果
                result.append(cur.charAt(i - 1));   //将查找的字符（i - 1 即为之前查找的字符串）计入结果
                if (i < cur.length()){          //如果还没扫描完所有的字符串，则继续扫下一个不同的字符
                    point = cur.charAt(i);          //记录新的字符
                    count = 1;                  //count设置为1，因为已经存在一个要找的字符了（即point）
                }
            }
            //point一直查找重复的字节并计数
            else if (cur.charAt(i) == point){
                count++;
            }
        }
        //继续递归
        return recursive(level + 1, result, n);
    }
    public static void main(String[] args){
        System.out.println(countAndSay(5));
    }
}
