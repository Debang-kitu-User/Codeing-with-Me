class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length -1;
        int last = nums.length -1;

        while( left <= right){
            if( nums[left]*nums[left] > nums[right]*nums[right]){

                result[last] = nums[left] * nums[left];
                last--;
                left++;

            }else{
                result[last] = nums[right] * nums[right];
                last--;
                right--;
            }
        }
        return result;
    }
}