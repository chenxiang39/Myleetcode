public class Merge_Sorted_Array_88_not_all_way {
    //my way
    //时间复杂度：O(n * m),每个nums2插入进去都要排序(可用binary search优化)
    //空间复杂度：O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = m;     //后面的内容
        if(n == 0){
            return;
        }
        //先把之后的数组填满
        for(int i = m; i < m + n;i++){
            nums1[i] = nums2[i - m];
        }
        //将后面(nums2)的内容放到前面去
        while(p2 <= n + m - 1){
            if(nums1[p1] < nums1[p2]){
                p1++;
            }
            else if(nums1[p1] >= nums1[p2]){
                moveforward(nums1,p1,p2,nums1[p2]);
                p1++;
                p2++;
            }
        }
    }
    private static void moveforward(int nums1[],int p1, int p2, int content){
        int aux;
        for(int i = p2; i > p1; i--){
            nums1[i] = nums1[i - 1];
        }
        nums1[p1] = content;
    }
    public static void main(String[] args){
        int[] nums1 = {2,3,0,0};
        int[] nums2 = {1,2};
        merge(nums1,2,nums2,2);
        for (int i : nums1){
            System.out.println(i);
        }
    }
}
