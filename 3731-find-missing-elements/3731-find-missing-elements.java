class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        boolean[] contains = new boolean[101];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int ele : nums) {
            min = Math.min(min, ele);
            max = Math.max(max, ele);
            contains[ele] = true;
        }
        for (int i=min; i<=max; i++) {
            if (!contains[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}