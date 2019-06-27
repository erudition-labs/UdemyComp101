public class ExpandableUniverse extends Universe {
    private CellState[] expandableStates;

    ExpandableUniverse(int height, int width, Rule[] rules, CellState[] states) {
        super(height, width, rules);
        expandableStates = states;
    }

    private void expand(int n) {
        int oldHeight = height;
        int oldWidth = width;

        height = height + (2 * n);
        width = width + (2 * n);

        Cell[][] expandedUniverse = new Cell[height][width];

        for(int i=0; i<expandedUniverse.length; i++) {
            for(int j=0; j<expandedUniverse[i].length; j++) {
                expandedUniverse[i][j] = new Cell(0, i, j);
            }
        }

        for(int i=n; i<oldHeight+n; i++) {
            for(int j=n; j<oldWidth+n; j++) {
                expandedUniverse[i][j].setState(universe[i-n][j-n].getState());
            }
        }
        universe = expandedUniverse;
    }

    private boolean shouldBeExpanded() {
        for(int i=0; i<width; i++) {
            for(int state=0; state<expandableStates.length; state++) {
                if (universe[0][i].getState() == expandableStates[state]) return true;
                if (universe[height - 1][i].getState() == expandableStates[state]) return true;
            }
        }

        for(int i=0; i<height; i++) {
            for(int state=0; state<expandableStates.length; state++) {
                if (universe[i][0].getState() == expandableStates[state]) return true;
                if (universe[i][width - 1].getState() == expandableStates[state]) return true;
            }
        }

        return false;
    }

    public void epoch() {
        if(shouldBeExpanded()) expand(5);
        super.epoch();
    }
}
