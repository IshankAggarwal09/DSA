class Solution {
    public boolean isSorted(int nums[], int bp) {
        for(int i=bp; i<nums.length-1; i++) {
            if(nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
    public boolean isRotated(int nums[]) {
        int n = nums.length;
        int bp = -1;
        for(int i=0; i<n-1; i++) {
            if(nums[i] > nums[i+1]) {
                bp = i;
                break;
            }
        }
        if(bp == -1) {
            return true;
        }
        return isSorted(nums, bp + 1) && nums[0] > nums[n-1];
    }
    public void reverse(int nums[]) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (isRotated(nums)) {
            for (int i=0; i<n; i++) {
                if (nums[i] == 0) {
                    return Math.min(i, 2 + (n - i));
                }
            }
        }
        reverse(nums);
        if (isRotated(nums)) {
            for (int i=0; i<n; i++) {
                if (nums[i] == 0) {
                    return 1 + Math.min(i, n - i);
                }
            }
        }
        return -1;
    }
}