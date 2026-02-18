class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] nge = new int[n];
        for (int i=n-1; i>=0; i--) {
            stack.push(nums[i]);
        }
        for (int i=n-1; i>=0; i--) {
            while (stack.size() > 0 && nums[i] >= stack.peek()) {
                stack.pop();
            }
            if (stack.size() == 0) {
                nge[i] = -1;
            }
            else {
                nge[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return nge;
    }
}