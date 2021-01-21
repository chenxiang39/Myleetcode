public class Count_Primes_204_need_review {
    //https://www.jianshu.com/p/696d8d88a233

    //一个素数的倍数都不是素数。 比如2，依次往上乘，4,6,8等等，他们都不是质数，再比如3，也可以依次往上乘，得到的结果也不是质数。

    //我们从2开始遍历到根号n，先找到第一个质数2，然后将其所有的倍数全部标记出来，然后到下一个质数3，标记其所有倍数，一次类推，
    //直到根号n，此时数组中未被标记的数字就是质数。对此我们需要使用一个长度为n的布尔类型数组，来存储那些被标记的非质数。外层循环和内层循环都是遍历到根号n即可。

    //此解法的空间复杂度是O(n)，时间复杂度是O(nlog(log n))
    class Solution {
        public int countPrimes(int n){
            boolean[] isPrimes = new boolean[n];
            //0和1默认不是素数
            //然后设置全部都是质数
            for (int i = 2; i < n; i++) {
                isPrimes[i] = true;
            }
            for(int i = 2; i * i < n; i++){
                if(!isPrimes[i]){
                    continue;
                }
                //不用从 j = i * 2 开始向后，因为之前的数都已经被i之前的质数处理过了
                for (int j = i * i; j < n; j = j + i) {
                    isPrimes[j] = false;
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrimes[i]){
                    count++;
                }
            }
            return count;
        }
    }
}
