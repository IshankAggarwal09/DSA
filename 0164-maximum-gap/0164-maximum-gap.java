class Solution {
    public void sort(int[] arr) {
        int max = arr[0];
        for (int val : arr) {
            if (val > max) {
                max = val;
            }
        }
        for (int exp=1; max/exp>0; exp*=10) {
            countingSort(arr, exp);
        }
    }
    public void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i=0; i<n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i=1; i<10; i++) {
            count[i] += count[i-1];
        }
        for (int i=n-1; i>=0; i--) {
            int digit = (arr[i] / exp) % 10;
            int position = count[digit] - 1;
            output[position] = arr[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) return 0;
        sort (nums);
        int max = 0;
        for (int i=1; i<nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i-1]);
        }
        return max;
    }
}