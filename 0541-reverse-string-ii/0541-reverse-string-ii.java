class Solution {
    public void reverse(char[] ch, int left, int right) {
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
    }
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        for (int i=0; i<n; i+=2*k) {
            reverse(ch, i, Math.min(i+k-1, n-1));
        }
        return new String(ch);
    }
}