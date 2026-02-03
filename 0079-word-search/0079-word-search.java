class Solution {
    private boolean helper(char[][] board, String word, int row, int col, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        boolean found = helper(board, word, row - 1, col, index + 1, visited) ||
                        helper(board, word, row + 1, col, index + 1, visited) ||
                        helper(board, word, row, col - 1, index + 1, visited) ||
                        helper(board, word, row, col + 1, index + 1, visited);

        visited[row][col] = false; 
        return found;
    }
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}