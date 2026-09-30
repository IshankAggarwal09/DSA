class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int d = 0;
        int[] a = new int[seq.length()];
        for(int i=0; i<seq.length(); i++){
            a[i] = seq.charAt(i) == '(' ? d++ & 1 : --d & 1;
        }
        return a;
    }
}