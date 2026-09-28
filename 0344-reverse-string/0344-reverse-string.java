class Solution {
    public void reverseString(char[] s) {
      int size = s.length - 1;  
      int right = size;
      int left = 0;
      while( left < right){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
      }
    }

}