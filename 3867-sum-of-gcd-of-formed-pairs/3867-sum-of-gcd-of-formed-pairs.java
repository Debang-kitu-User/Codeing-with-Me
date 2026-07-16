class Solution {
    public long gcdSum(int[] nums) {
        int[] prefixGcd = new int[nums.length];
        int max = -1;

        for( int i=0; i<nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
            }
            prefixGcd[i] = GCD(nums[i], max);
        }

        Arrays.sort(prefixGcd);

        int left = 0;
        int right = prefixGcd.length - 1;
        long sum = 0;
        while(left < right ){
            sum = sum + (long)GCD(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
    public static int GCD(int a, int b){
        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
}