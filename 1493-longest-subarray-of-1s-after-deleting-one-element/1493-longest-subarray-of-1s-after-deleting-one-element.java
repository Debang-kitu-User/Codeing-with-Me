class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int maxcount = 0;

        for(int i=0; i<n; i++){
            if( nums[i] == 0){
                int left = i-1;
                int right = i+1;
                while( left >= 0 && nums[left] == 1)left--;
                while( right < n && nums[right] == 1)right++;
                int onesCount = (i - 1 - left) + (right - i - 1);
                maxcount = Math.max(maxcount, onesCount);
            }
        }

        if( maxcount == 0){
            int totalones = 0;
            boolean haszero = false;

            for( int num : nums){
                if( num == 1) totalones++;
                else
                    haszero = true;
            }
            maxcount = haszero ? 0 : totalones - 1;
        }
        return maxcount;
    }
}