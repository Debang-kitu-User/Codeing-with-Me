class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for( int i : nums1){
            seen.put(i,1);
        }
        for( int x : nums2){
            if( seen.containsKey(x) && seen.get(x) == 1){
                res.add(x);
                seen.put(x,0);
            }
        }
        int[] result = res.stream().mapToInt(Integer :: intValue).toArray();
        return result;
    }
}