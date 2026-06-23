class Solution {
    public int findMin(int[] nums) {
        // int min = nums[0];
        // for( int n : nums){
        //     if( n < min){
        //         min  = n;
        //     }
        // }
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while( l <= r){
            if(nums[l]  < nums[r]){
                res = Math.min(res, nums[l]);
                break;
            }
            int m = l + (r - l)/2;
            res = Math.min(res, nums[m]);
            if(nums[m] >= nums[l]){
                l= m+1;
            }else{
                r= m-1;
            }
        }
        return res;
    }
}