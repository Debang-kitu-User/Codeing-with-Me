class Solution {
    public int longestMountain(int[] arr) {
        int bigMount = 0;
        for (int peak = 1; peak < arr.length - 1; peak++) {
            if (arr[peak] > arr[peak-1] && arr[peak] > arr[peak+1]) {
                int left = peak, right = peak;
                while (left > 0 && arr[left] > arr[left-1]) left--;
                while (right < arr.length - 1 && arr[right] > arr[right+1]) right++;
                bigMount = Math.max(bigMount, right - left + 1);
            }
        }
        return bigMount;
    }
}