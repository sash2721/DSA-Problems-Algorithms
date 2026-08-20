class Solution {
    static boolean isPossible(char[][] board, int row, int col, char c) {
        for(int i = 0; i < 9; i++) {
            // check the col
            if(board[i][col] == c) {
                return false;
            }

            // check the row
            if(board[row][i] == c) {
                return false;
            }

            // check the 3x3 box
            if(
                board[
                    3 * (row / 3) + i / 3
                ][
                    3 * (col / 3) + i % 3
                ] == c
            ) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(isPossible(board, i, j, c)) {
                            board[i][j] = c;

                            if(solveSudoku(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solve(char[][] board) {
        solveSudoku(board);
    }
}

class Main {
    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        Solution s = new Solution();
        s.solve(board);

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }
}