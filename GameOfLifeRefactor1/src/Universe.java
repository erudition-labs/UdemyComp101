import java.util.Random;

public class Universe {

    private int WIDTH, HEIGHT;
    private final static int ALIVE = 1, DEAD = 0;
    private final static int LIVES = 1, DIES = 0;
    private int[][] universe;

    Universe(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        universe = randomSeed();
    }

    public void epoch() {
        int[][] newPopulation = new int[HEIGHT][WIDTH];

        for(int i=0; i<universe.length; i++) {
            for(int j=0; j<universe[i].length; j++) {
                newPopulation[i][j] = fitness(i, j);
            }
        }
        universe = newPopulation;
    }

    public int[][] getUniverse() {
        return universe;
    }

    //public void setUniverse()

    private boolean exists(int row, int col) {
        if((row >= 0) && (row < HEIGHT) && (col >= 0) && (col < WIDTH)) {
            return true;
        }

        return false;
    }

    private int countAliveNeighbors(int row, int col) {
        int aliveNeighbors = 0;

        for(int i=row-1; i<=row+1; i++) {
            for(int j=col-1; j<=col+1; j++) {
                if(exists(i, j)) {
                    if(universe[i][j] == ALIVE) {
                        aliveNeighbors++;
                    }
                }
            }
        }

        if(universe[row][col] == ALIVE) {
            aliveNeighbors--;
        }
        return aliveNeighbors;
    }

    private int fitness(int row, int col) {
        // get neighbors
        int aliveNeighbors = countAliveNeighbors(row, col);
        final int curr = universe[row][col];
        //apply rules
        // Any live cell with fewer than two live neighbours dies, as if by underpopulation.
        if((curr == ALIVE) && (aliveNeighbors < 2)) {
            return DIES;
        } else if((curr == ALIVE) && (aliveNeighbors > 3)) {
            //Any live cell with more than three live neighbours dies, as if by overpopulation.
            return DIES;
        } else if((curr == DEAD) && (aliveNeighbors == 3)) {
            //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            return  LIVES;
        } else if((curr == ALIVE) && ((aliveNeighbors == 2) || (aliveNeighbors == 3))) {
            //Any live cell with two or three live neighbours lives on to the next generation.
            return LIVES;
        } else {
            return curr;
        }
    }

    private int[][] randomSeed() {
        int[][] tmp = new int[HEIGHT][WIDTH];
        Random rand = new Random();

        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<tmp[i].length; j++) {
                tmp[i][j] = rand.nextInt(2);
            }
        }
        return tmp;
    }

}
