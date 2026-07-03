class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> types = new HashSet<>();

        for( int x : candyType){
           if(!types.contains(x)) 
            types.add(x);
        }

        return Math.min((candyType.length/2), (types.size()));
    }
}