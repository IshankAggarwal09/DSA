class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s1.length > s2.length) {
            String[] temp = s1;
            s1 = s2;
            s2 = temp;
        }
        int n1 = s1.length;
        int n2 = s2.length;
        int left = 0;
        while (left < n1 && s1[left].equals(s2[left])) {
            left++;
        }
        int right1 = n1 - 1;
        int right2 = n2 - 1;
        while (right1 >= left && s1[right1].equals(s2[right2])) {
            right1--;
            right2--;
        }
        return right1 < left;
    }
}