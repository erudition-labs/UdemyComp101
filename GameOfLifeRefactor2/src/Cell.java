public class Cell {
    private CellState currState;
    private int row, col; //col is x

    Cell(CellState state, int row, int col) {
        currState = state;
        this.row = row;
        this.col = col;
    }

    Cell(int state, int row, int col) {
        //assume starts from 0
        currState = CellState.values()[state];
        this.row = row;
        this.col = col;
    }

    public CellState getState() {
        return currState;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
