//https://blog.csdn.net/fuxuemingzhu/article/details/82113409
//字典顺序 （ 1，2，3 -》 1，3，2 =》 2，1，3 =》 2，3，1 =》 3，1，2=》 3，2，1 ）
public class Next_Permutation_31_need_exercise {
    //my way (Single Pass Approach)
    public static void nextPermutation(int[] nums) {
        if (nums.length == 1 || nums.length == 0){      //0长度和1长度需要注意
            return;
        }
        int startDecrease = nums.length - 1;        //从尾部向前开始寻找数组倒序的交界处
        while (startDecrease >= 0){     //必须>=，因为需要检查到第一个数
            if (startDecrease == 0 || nums[startDecrease - 1] < nums[startDecrease]){     //开始下降
                startDecrease--;
                break;
            }
            startDecrease--;
        }
        int correctIndex = startDecrease + 1;
        int needSwap = startDecrease != - 1? nums[startDecrease] : nums[0];         //当startDecrease == -1时，意味这个数组是倒序的
        while (correctIndex <= nums.length - 1){        //此处必须有等于号，因为最后一个需要被检查到
            if (nums[correctIndex] <= needSwap){
                correctIndex--;
                break;
            }
            //解决后面nums[correctIndex]溢出的问题
            if (correctIndex == nums.length - 1){
                break;
            }
            correctIndex++;
        }
        //swap，将交界处的值回归到正确的位置
        if (startDecrease != -1) {
            nums[startDecrease] = nums[correctIndex];
            nums[correctIndex] = needSwap;
        }
        int end = nums.length - 1;
        int start = startDecrease + 1;  //交界处之后开始交换
        //倒置倒序交界处到数组最后的顺序
        while (start < end){
            int aux = nums[end];
            nums[end] = nums[start];
            nums[start] = aux;
            end--;
            start++;
        }
    }
    public static void main(String[] args){
        int[] nums = {8,7,6,5,4};
        nextPermutation(nums);
        for (int a : nums){
            System.out.print(a + " ");
        }
    }
}
