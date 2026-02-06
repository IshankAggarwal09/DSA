class Solution {
    public void sortColors(int[] arr) {
        int n = arr.length;
        int start = 0;
        int mid = 0;
        int end = n-1;
        while (mid <= end) {
            if (arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[start];
                arr[start] = temp;
                start++;
                mid++;
            }
            else if (arr[mid] == 1) {
                mid++;
            }
            else {
                int temp = arr[mid];
                arr[mid] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
    }
}