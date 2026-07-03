class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for( int x : nums1){
            seen.add(x);
        }
        for( int c : nums2){
            if(seen.contains(c)){
                result.add(c);
            }
        }
        int[] res = new int[result.size()];
        int i=0;
        for( int c : result){
            res[i] = c;
            i++;
        } 
        return res;
    }
}