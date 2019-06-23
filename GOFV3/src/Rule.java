public class Rule {
    private int radius;
    private int requiredLiveNeighbors;
    private CellState initialState, resultingState;
    String operator;

    Rule(int radius, int requiredLiveNeighbors, String operator, CellState initialState, CellState resultingState) {
        this.radius = radius;
        this.resultingState = resultingState;
        this.requiredLiveNeighbors = requiredLiveNeighbors;
        this.operator = operator;
        this.initialState = initialState;
    }

    public int getRadius() {
        return radius;
    }

    public CellState applyRule(Cell curr, Cell[] neighborhood) {
        if(curr.getState() == initialState) {
            boolean currIsAlive = false;
            if(curr.getState() == CellState.ALIVE) {
                currIsAlive = true;
            }
            int livingNeighbors = countLivingNeighbors(currIsAlive, neighborhood);
            switch(operator) {
                case "<"    : return livingNeighbors < requiredLiveNeighbors ? resultingState: CellState.NONE;
                case "<="   : return livingNeighbors <= requiredLiveNeighbors ? resultingState: CellState.NONE;
                case ">"    : return livingNeighbors > requiredLiveNeighbors ? resultingState: CellState.NONE;
                case ">="   : return livingNeighbors >= requiredLiveNeighbors ? resultingState: CellState.NONE;
                case "=="   : return livingNeighbors == requiredLiveNeighbors ? resultingState: CellState.NONE;
                case "!="   :  return livingNeighbors != requiredLiveNeighbors ? resultingState: CellState.NONE;
                default: return CellState.NONE;
            }
        }
        return CellState.NONE;
    }

    private int countLivingNeighbors(boolean currIsAlive, Cell[] neighborHood) {
        int livingNeighbors = 0;

        for(int i=0; i<neighborHood.length; i++) {
            if(neighborHood[i] != null) {
                if(neighborHood[i].getState() == CellState.ALIVE) {
                    livingNeighbors++;
                }
            }
        }

        if(currIsAlive) livingNeighbors--;
        return livingNeighbors;
    }
}
