import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayBoardTest {

//    p1 wins, p2 wins , tie, out of Bounds
    @Test
    void shouldCheckForAPlayerMatches() {
        PlayBoard playBoard = new PlayBoard();
        int[] rows = {1, 1, 2, 3, 2, 2, 3};
        int[] columns = {1, 2, 1, 1, 2, 3, 3};
        char player;

        int x=0;
        while(x<=6) {
            player = x%2 ==0 ? 'X':'Y';
            playBoard.placeMark(rows[x], columns[x], player);
            x++;
        }

        assertEquals("player1 wins", playBoard.whoIsWinner());
    }
}