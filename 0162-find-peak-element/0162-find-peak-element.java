class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            boolean left = (i == 0) || (arr[i] >= arr[i-1]);
            boolean right = (i == n-1) || arr[i] >= arr[i+1];
            if (left && right) {
                return i;
            }
        }
        return -1;
    }
}