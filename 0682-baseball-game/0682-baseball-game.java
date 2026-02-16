class Solution {
    public int calPoints(String[] operations) {
        int n = operations.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            String s = operations[i];
            if (s.equals("C")) {
                stack.pop();
            }
            else if (s.equals("D")) {
                stack.push(2 * stack.peek());
            }
            else if (s.equals("+")) {
                int top = stack.pop();
                int secondTop = stack.peek();
                int sum = top + secondTop;
                stack.push(top);
                stack.push(sum);
            }
            else {
                stack.push(Integer.parseInt(s));
            }
        }
        int sum = 0;
        while (stack.size() > 0) {
            sum += stack.pop();
        }
        return sum;
    }
}