import java.util.Random;

public class Universe {
    private int WIDTH, HEIGHT;
    private Cell[][] universe;
    private int generations;
    private Rule[] rules;

    Universe(int height, int width, Cell[][] seed, Rule[] rules) {
        WIDTH = width;
        HEIGHT = height;
        universe = seed;
        generations = 0;
        this.rules = rules;
    }


    Universe(int height, int width, Rule[] rules) {
        WIDTH = width;
        HEIGHT = height;
        generations = 0;
        randomSeed();
        this.rules = rules;
    }

    public int getGenerations() {
        return generations;
    }

    private void randomSeed() {
        universe = new Cell[HEIGHT][WIDTH];
        Random rand = new Random();

        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                universe[i][j] = new Cell(rand.nextInt(2), i, j);
            }
        }
    }

    public void gliders() {
        universe = new Cell[HEIGHT][WIDTH];
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


        universe[HEIGHT-2][WIDTH-3].setState(CellState.ALIVE);
        universe[HEIGHT-3][WIDTH-4].setState(CellState.ALIVE);
        universe[HEIGHT-4][WIDTH-4].setState(CellState.ALIVE);
        universe[HEIGHT-4][WIDTH-3].setState(CellState.ALIVE);
        universe[HEIGHT-4][WIDTH-2].setState(CellState.ALIVE);


        universe[HEIGHT-11][WIDTH-11].setState(CellState.ALIVE);
        universe[HEIGHT-11][WIDTH-12].setState(CellState.ALIVE);
        universe[HEIGHT-11][WIDTH-13].setState(CellState.ALIVE);
        universe[HEIGHT-12][WIDTH-11].setState(CellState.ALIVE);
        universe[HEIGHT-13][WIDTH-12].setState(CellState.ALIVE);
    }

    private boolean exists(int row, int col) {
        if((row >= 0) && (row < HEIGHT) && (col >= 0) && (col < WIDTH)) {
            return true;
        }
        return false;
    }

    public void epoch() {
        Cell[][] newPopulation = new Cell[HEIGHT][WIDTH];

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
        for(int i=0; i<rules.length; i++) {
            Cell[] neighbors = getNeighborhood(cell, rules[i].getRadius());
            CellState state = rules[i].applyRule(cell, neighbors);

            if(state != CellState.NONE) {
                return state;
            }
        }
        return null;
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
                    result += "* ";
                } else {
                    result += ". ";
                }
            }
            result += "\n";
        }
        return result;
    }

}
