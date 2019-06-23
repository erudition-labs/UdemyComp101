import java.util.Random;

public class Universe {
    protected Cell[][] universe;
    protected int width, height;
    private int generations;
    private Rule[] rules;

    Universe(int height, int width, Cell[][] seed, Rule[] rules) {
        this.height = height;
        this.width = width;
        universe = seed;
        this.rules = rules;
    }

    Universe(int height, int width, Rule[] rules) {
        this.height = height;
        this.width = width;
        //universe = seed;
        //randomSeed();
        gliders();
        this.rules = rules;
    }

    public int getGenerations() {
        return generations;
    }

    private void randomSeed() {
        universe = new Cell[height][width];
        Random random = new Random();

        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                universe[i][j] = new Cell(random.nextInt(2), i, j);
            }
        }
    }

    private boolean exists(int row, int col) {
        if((row >= 0) && (row < height) && (col >= 0) && (col < width)) {
            return true;
        }
        return false;
    }

    public void epoch() {
        Cell[][] newPopulation = new Cell[height][width];

        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                Cell cell = universe[i][j];
                CellState resultState = fitness(cell);

                if(resultState != null) {
                    newPopulation[i][j] = new Cell(resultState, i, j);
                } else {
                    newPopulation[i][j] = new Cell(CellState.DEAD, i, j);
                }
            }
        }

        universe = newPopulation;
        generations++;
    }

    private CellState fitness(Cell cell) {
        //apply ruless
        for(int i=0; i<rules.length; i++) {
            Cell[] neighbors = getNeighborhood(cell, rules[i].getRadius());
            CellState result = rules[i].applyRule(cell, neighbors);

            if(result != CellState.NONE) {
                return result;
            }
        }

        return null;
        //return the state
    }

    private Cell[] getNeighborhood(Cell cell, int radius) {
        int block = (radius * 2) + 1;
        Cell[] neighbors = new Cell[block * block];
        int index = 0;

        for(int i=cell.getRow()-radius; i<=cell.getRow()+radius; i++) {
            for(int j=cell.getCol()-radius; j<=cell.getCol()+radius; j++) {
                if(exists(i, j)) {
                    neighbors[index] = universe[i][j];
                    index++;
                }
            }
        }
        return neighbors;
    }

    public String toString() {
        String result = new String();
        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                if(universe[i][j].getState() == CellState.ALIVE) {
                    result += "*";
                } else {
                    result += ".";
                }
            }
            result += "\n";
        }
        return result;
    }

    public void gliders() {
        universe = new Cell[height][width];
        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                universe[i][j] = new Cell(CellState.DEAD, i , j);
            }
        }


        universe[10+1][10+1].setState(CellState.ALIVE);
        universe[10+2][10+1].setState(CellState.ALIVE);
        universe[10+3][10+1].setState(CellState.ALIVE);
        universe[10+1][10+2].setState(CellState.ALIVE);
        universe[10+2][10+3].setState(CellState.ALIVE);


        universe[height-2][width-3].setState(CellState.ALIVE);
        universe[height-3][width-4].setState(CellState.ALIVE);
        universe[height-4][width-4].setState(CellState.ALIVE);
        universe[height-4][width-3].setState(CellState.ALIVE);
        universe[height-4][width-2].setState(CellState.ALIVE);


        universe[height-11][width-11].setState(CellState.ALIVE);
        universe[height-11][width-12].setState(CellState.ALIVE);
        universe[height-11][width-13].setState(CellState.ALIVE);
        universe[height-12][width-11].setState(CellState.ALIVE);
        universe[height-13][width-12].setState(CellState.ALIVE);
    }
}
