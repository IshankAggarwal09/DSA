class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long moves = 0;
        int i = 0; 
        int j = nums.length - 1;
        while (i < j){
            moves += (long) nums[j--] - nums[i++];
        }
        return (int) moves;
    }
}