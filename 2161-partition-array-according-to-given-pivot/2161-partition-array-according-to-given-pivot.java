class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                list1.add(nums[i]);
            } else if (nums[i] == pivot) {
                list2.add(nums[i]);
            } else {
                list3.add(nums[i]);
            }
        }
        List<Integer> combined = new ArrayList<>();
        combined.addAll(list1);
        combined.addAll(list2);
        combined.addAll(list3);
        return combined.stream().mapToInt(Integer::intValue).toArray();
    }
}