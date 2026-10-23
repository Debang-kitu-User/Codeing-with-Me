class Solution {
    public int[] shuffle(int[] nums, int n) {

      int[] left = new int[n];
      for( int i=0; i<n; i++){left[i] = nums[i];}
      int[] right = new int[n];
      int j=0;
      for( int i=n; i<nums.length; i++){right[j] = nums[i]; j++;}
    
      int l = 0;
      int r = 0;  
      for( int i=0 ; i<nums.length; i++){
        if( i%2 != 0 && r<nums.length){
            nums[i] = right[r];
            r++;
        }else{
            nums[i] = left[l];
            l++;
        }
      } 
      return nums; 
    }
}