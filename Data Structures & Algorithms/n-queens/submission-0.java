class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row, '.');
        backtrack(board, 0, n);
        return result;
    }

    private void backtrack(char[][] board, int row, int n){
        if(row == n){
            List<String> solution = new ArrayList<>();
            for(char[] r : board) solution.add(new String(r));
            result.add(solution);
            return;
        }

        for(int col = 0; col < n; col++){
            if(isValid(board, row, col, n)){
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n){
        // check column
        for(int i = 0; i < row; i++)
            if(board[i][col] == 'Q') return false;

        // check upper-left diagonal
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--)
            if(board[i][j] == 'Q') return false;

        // check upper-right diagonal
        for(int i = row-1, j = col+1; i >= 0 && j < n; i--, j++)
            if(board[i][j] == 'Q') return false;

        return true;
    }
}