class Solution {
    public int maxArea(int[] height) {
        int MaxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while( left <= right){
            int area = 0;
            int width = right - left;
            int hit = Math.min(height[left], height[right]);
            area = hit * width;
            if( area > MaxArea){
                MaxArea = area;
            }
            if( height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return MaxArea;
    }
}