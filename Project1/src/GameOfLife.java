import java.util.Random;

public class GameOfLife {
    //static int[][] world;
    static boolean isRunning;
    final static int width = 10;
    final static int height = 10;

    public static int[][] epoch(int[][] world) {
        for(int i=0; i<world.length; i++) {
            for(int j=0; j<world[i].length; j++) {
                world[i][j] = fitness(i, j, world);
            }
        }
        return world;
    }

    public static boolean exists(int x, int y) {
        if(x < 0 || x >= height || y < 0 || y >= width) {
            return false;
        }

        return true;
    }

    public static int fitness(int x, int y, int[][] grid) {
        final int lives = 1, dies = 0;
        final int alive = 1, dead = 0;

        //since only 0 and 1, just add all the neighbors
        int aliveNeighbors = 0;

        if(exists(x, y-1)) aliveNeighbors += grid[x][y-1]; //check above you
        if(exists(x, y+1)) aliveNeighbors += grid[x][y+1]; //below you
        if(exists(x-1, y)) aliveNeighbors += grid[x-1][y]; //the left
        if(exists(x+1, y)) aliveNeighbors += grid[x+1][y]; //the right

        if((grid[x][y] == alive) && (aliveNeighbors  < 2)) {
            //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
            return dies;
        } else if((grid[x][y] == alive) && (aliveNeighbors > 3)) {
            //Any live cell with more than three live neighbours dies, as if by overpopulation.
            return dies;
        } else if((grid[x][y] == dead) && (aliveNeighbors == 3)) {
            //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            return lives;
        } else {
            //Any live cell with two or three live neighbours lives on to the next generation.
            return lives;
        }
    }

    public static int[][] randomSeed() {
        int[][] tmp = new int[width][height];
        Random rand = new Random();

        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<tmp[i].length; j++) {
                tmp[i][j] = rand.nextInt(2);
            }
        }
        return tmp;
    }

    public static void run(int[][] world) {
        while(isRunning) {
            int[][] newWorld = epoch(world);
            render(newWorld);
        }
    }

    public static void render(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] world = randomSeed();
        //render(world);
        isRunning = true;
        run(world);

    }
}
