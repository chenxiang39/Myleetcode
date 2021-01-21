import java.util.HashSet;

public class Happy_Number_202_need_review {
    //https://www.cnblogs.com/grandyang/p/4447233.html
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)){   //循环到1则必定发生循环，自动退出，若退出循环时不是1触发，则表明整个循环中不存在1，因此返回n是否为1，即是答案
            set.add(n);
            n = dealnumber(n);
        }
        return n == 1;
    }
    //处理数字，比如将19转化成82
    private int dealnumber(int input){
        int result = 0;
        while(input!= 0){
            result += Math.pow(input % 10 , 2);
            input = input/10;
        }
        return result;
    }
}
