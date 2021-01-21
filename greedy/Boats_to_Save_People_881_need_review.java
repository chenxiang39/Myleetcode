import java.util.Arrays;

public class Boats_to_Save_People_881_need_review {
    //two pointers + greedy,将最轻的人和最重的人配对
    //n : the length of people
    //Time complexity: O(n*logn);
    //Space complexity: O(logn);        //quick sort
    public int numRescueBoats(int[] people, int limit) {
        //排序
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        int result = 0;
        //首位配对
        while(start <= end){
            //中间只剩下一个的话
            if(start == end){
                result++;
                break;
            }
            //尾部太大只能一个人进去
            if(people[end] + people[start] > limit){
                result++;
                end--;
            }
            else{
                result++;
                end--;
                start++;
            }
        }
        return result;
    }
}
