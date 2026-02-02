class Solution {
    public void helper(int[] arr, List<List<Integer>> ans, List<Integer> ds, int idx) {
        ans.add(new ArrayList<Integer>(ds));
        for (int i=idx; i<arr.length; i++) {
            if (i > idx && arr[i] == arr[i-1]) {
                continue;
            }
            ds.add(arr[i]);
            helper(arr, ans, ds, i+1);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(nums, ans, ds, 0);
        return ans;
    }
}