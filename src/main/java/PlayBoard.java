public class PlayBoard {
    int ROWS = 3;
    int COLUMNS = 3;
    char[][] board = new char[ROWS][COLUMNS];
    char PLAYER1 = 'X';
    char PLAYER2 = 'Y';

    PlayBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void placeMark(int row, int column, char player) {
        if (isEmpty(row,column)) {
            board[row - 1][column - 1] = player;
        }
        whoIsWinner();
    }

    private boolean isEmpty(int row, int column) {
        return board[row - 1][column - 1] == ' ' ;
    }

    public String whoIsWinner() {
        if (checkMatchesFor(PLAYER1)) {
            return "player1 wins";
        }
        if (checkMatchesFor(PLAYER2)) {
            return "player2 wins";
        }
        return "";
    }

    private boolean checkMatchesFor(char player) {
        if (checkMatchInRows(player)) return true;
        if (checkMatchInColumns(player)) return true;
        return checkMatchInDiagonal(player);
    }

    private boolean checkMatchInDiagonal(char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }

    private boolean checkMatchInColumns(char player) {
        for (int i = 0; i < COLUMNS; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        return false;
    }

    private boolean checkMatchInRows(char player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        return false;
    }
}
