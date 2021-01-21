public class Compare_Version_Numbers_165_need_reivew {
    //Time complexity: O(m + n + Math.max(n,m)), m: the length of version1, n: the length of version2
    //m + n 的原因是split操作的时间复杂度
    //Space complexity : O(m + n), two arrays
    public int compareVersion(String version1, String version2) {
        //将.分离
        String[] version1Array =  version1.split("\\.");    //https://www.cnblogs.com/miracle-luna/p/11828745.html
        String[] version2Array =  version2.split("\\.");    //https://www.cnblogs.com/ylht/p/10249543.html
        int v1_length = version1Array.length;
        int v2_length = version2Array.length;
        for(int i = 0 ; i < Math.max(v1_length,v2_length); i++){
            //比较每一位的大小，如果位数超了就补0
            int a = i < v1_length ? Integer.parseInt(version1Array[i]) : 0;
            int b = i < v2_length ? Integer.parseInt(version2Array[i]) : 0;
            if(a > b){
                return 1;
            }
            if(a < b){
                return -1;
            }
        }
        return 0;
    }
}
