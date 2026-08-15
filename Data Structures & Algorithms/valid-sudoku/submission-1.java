class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // check rows
        for(int i = 0; i < 9; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.') continue;
                if(seen.contains(c)) return false;
                seen.add(c);
            }
        }
        
        // check columns
        for(int i = 0; i < 9; i++){
            HashSet<Character> seen = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char c = board[j][i];
                if(c == '.') continue;
                if(seen.contains(c)) return false;
                seen.add(c);
            }
        }
        
        // boxes come here next
        // check 3x3 boxes
        for(int block = 0; block < 9; block++){
            HashSet<Character> seen = new HashSet<>();
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    int row = (block / 3) * 3 + i;
                    int col = (block % 3) * 3 + j;
                    char c = board[row][col];
                    if(c == '.') continue;
                    if(seen.contains(c)) return false;
                    seen.add(c);
                }
            }
        }
        
        return true;
    }
}