class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int res=0;
        int shift=0;
        while(left < right) {
            shift++;
            left >>= 1;
            right >>= 1;
        }
        return left << shift;
        // int mx = (int)(Math.log(right)/Math.log(2));
        // for(int i=0; i<=mx; ++i) {
        //     int num = (1<<i);
        //     boolean set = true;
        //     for(long j = left; j<= right; ++j) {
                
        //         if(((int)j & num) == 0){
        //             set = false;
        //             break;
        //         }
        //     }
        //     if(set) res += num;
        // }
        
        // return res;
    }
}