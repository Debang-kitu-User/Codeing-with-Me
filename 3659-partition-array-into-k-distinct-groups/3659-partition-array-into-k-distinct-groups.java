class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        

        if( nums.length % k == 0){
            
            for( int i : nums){
                if(!map.containsKey(i)){
                    map.put(i, 1);
                }else{
                    map.put(i, map.get(i) + 1);
                }
            }

            for( int value : map.values()){
                if( value > nums.length/k)
                    return false;
            }

            return true;
        }
        return false;
    }
}