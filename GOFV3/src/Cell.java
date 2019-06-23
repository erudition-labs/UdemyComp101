public class Cell {
    private int row, col;
    CellState currState;

    Cell(CellState state, int row, int col) {
        this.row = row;
        this.col = col;
        currState = state;
    }

    Cell(int state, int row, int col) {
        this.row = row;
        this.col = col;
        currState = CellState.values()[state];
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setState(CellState state) {
        currState = state;
    }

    public CellState getState() {
        return currState;
    }
}
