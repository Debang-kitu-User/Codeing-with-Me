class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        
        for(int i = 0; i < intervals.length; i++) {
            boolean isCovered = false;
            for(int j = 0; j < intervals.length; j++) {
                if(i != j && intervals[j][0] <= intervals[i][0] && intervals[j][1] >= intervals[i][1]) {
                    isCovered = true;
                    break;
                }
            }
            if(!isCovered) {
                list.add(intervals[i]);
            }
        }
        
        return list.size();
        
    }
}