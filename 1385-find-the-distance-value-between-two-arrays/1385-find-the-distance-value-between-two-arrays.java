class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for(int i=0; i<arr1.length; i++){
            int a = arr1[i];
            count++;
            for(int j=0; j<arr2.length; j++){
                int b = arr2[j];
                int diff = Math.abs(a - b);
                if(diff <= d){
                    count--;
                    break;
                }
            }
        }
        return count;
    }
}