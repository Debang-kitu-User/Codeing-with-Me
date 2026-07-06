
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort to handle duplicates and maintain order for the result set
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current number is the same as the previous, skip it
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (seen.contains(complement)) {
                    // List.of creates an immutable list which is perfect for Set storage
                    result.add(Arrays.asList(nums[i], complement, nums[j]));
                }
                
                seen.add(nums[j]);
            }
        }

        return new ArrayList<>(result);
    }
}