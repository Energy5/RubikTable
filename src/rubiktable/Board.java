package rubiktable;

public class Board {

    private final int boardSize;
    private Field[][] board;

//    Board osztály konstruktora
    public Board(int boardSize) {
        this.boardSize = boardSize;
        board = new Field[this.boardSize][this.boardSize];
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 0; j < this.boardSize; ++j) {
                board[i][j] = new Field();
            }
        }
    }

//     Leellenőrzi, hogy a vízszintes sorokban ugyanolyan színek vannak-e
    public boolean isOverHorizontal(){
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 1; j < this.boardSize; ++j) {
                if(!board[i][0].getColor().equals(board[i][j].getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

//    Leellenőrzi, hogy a függőleges sorokban ugyanolyan színek vannak-e
    public boolean isOverVertical(){
        for (int i = 0; i < this.boardSize; ++i) {
            for (int j = 1; j < this.boardSize; ++j) {
                if(!board[0][i].getColor().equals(board[j][i].getColor())) {
                    return false;
                }
            }
        }
        return true;
    }

//    Visszaadja a board mátrixból a megadott koordinátán lévő Field-et
    public Field get(int x, int y) {
        return board[x][y];
    }

//    Visszaadja a tábla méretét
    public int getBoardSize() {
        return boardSize;
    }

//    Visszaadja a táblát
    public Field[][] getBoard(){
        return board;
    }
}
