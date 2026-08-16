class Solution {
    public String reverse(String word) {
        char[] ch = word.toCharArray();
        int left = 0;
        int right = ch.length - 1;
        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return new String(ch);
    }
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            if (i > s.length()) {
                break;
            }
            int start = i;
            while (i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            String word = s.substring(start, i);
            String revWord = reverse(word);
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(revWord);
        }
        return result.toString();
    }
}