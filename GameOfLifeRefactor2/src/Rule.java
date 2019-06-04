public class Rule {
    private int radius;
    private int requiredAliveNeighbors;
    private CellState initialState, resultingState;
    private String operator;

    Rule(int radius, int requiredAliveNeighbors, String operator, CellState initialState, CellState resultingState) {
        this.radius = radius;
        this.requiredAliveNeighbors = requiredAliveNeighbors;
        this.operator = operator;
        this.resultingState = resultingState;
        this.initialState = initialState;
    }

    public int getRadius() {
        return radius;
    }

    public CellState applyRule(Cell currCell, Cell[] neighborhood) {
        if(currCell.getState() == initialState) {
            boolean currIsAlive = false;
            if(currCell.getState() == CellState.ALIVE) {
                currIsAlive = true;
            }

            int livingNeighbors = countLivingNeighbors(currIsAlive, neighborhood);
            switch(operator) {
                case "<": return livingNeighbors < requiredAliveNeighbors ? resultingState : CellState.NONE;
                case "<=": return livingNeighbors <= requiredAliveNeighbors ? resultingState : CellState.NONE;
                case ">": return livingNeighbors > requiredAliveNeighbors ? resultingState : CellState.NONE;
                case ">=": return livingNeighbors >= requiredAliveNeighbors ? resultingState : CellState.NONE;
                case "==": return livingNeighbors == requiredAliveNeighbors ? resultingState : CellState.NONE;
                case "!=": return livingNeighbors != requiredAliveNeighbors ? resultingState : CellState.NONE;
                default: return  CellState.NONE;
            }
        } else {
            return CellState.NONE;
        }
    }



    private int countLivingNeighbors(boolean currCellIsAlive, Cell[] neighborhood) {
        int livingNeighbors = 0;
            for(int i=0; i<neighborhood.length; i++) {
                if(neighborhood[i] != null) {
                    if (neighborhood[i].getState() == CellState.ALIVE) {
                        livingNeighbors++;
                    }
                }
            }
            if(currCellIsAlive) livingNeighbors--;
        return livingNeighbors;
    }
}
