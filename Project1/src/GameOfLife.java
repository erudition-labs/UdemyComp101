import java.util.Random;

public class GameOfLife {
    static boolean isRunning;
    final static int WIDTH = 100;
    final static int HEIGHT = 20;
    static int generations = 0;

    final static int LIVES = 1, DIES = 0;
    final static int ALIVE = 1, DEAD = 0;

    public static int[][] epoch(int[][] world) {
        int[][] newPopulation = new int[HEIGHT][WIDTH];

        for(int i=0; i<world.length; i++) {
            for(int j=0; j<world[i].length; j++) {
                newPopulation[i][j] = fitness(i, j, world);
            }
        }
        generations++;
        return newPopulation;
    }

    public static boolean exists(int row, int col) {
        if((row >= 0) && (row < HEIGHT) && (col < WIDTH) && (col >= 0)) {
            return true;
        }

        return false;
    }

    public static int countAliveNeighbors(int row, int col, int[][] world) {
        int aliveNeighbors = 0;

        for(int i=row-1; i<=row+1; i++) {
            for(int j=col-1; j<=col+1; j++) {

                if(exists(i, j)) {
                    if (world[i][j] == ALIVE) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        //what if cell is dead..subtracting one will throw off the count, so check if it was dead.
       if(world[row][col] == ALIVE) {
            aliveNeighbors--;
        }
        //don't count the cell itself
        return aliveNeighbors;

    }

    public static int fitness(int row, int col, int[][] grid) {

        int aliveNeighbors = countAliveNeighbors(row, col, grid);
        final int curr = grid[row][col];


        if((curr == ALIVE) && (aliveNeighbors  < 2)) {
            //Any live cell with fewer than two live neighbours dies, as if by underpopulation.
            return DIES;
        } else if((curr == ALIVE) && (aliveNeighbors > 3)) {
            //Any live cell with more than three live neighbours dies, as if by overpopulation.
            return DIES;
        } else if((curr == DEAD) && (aliveNeighbors == 3)) {
            //Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
            return LIVES;
        } else if((curr == ALIVE) && ((aliveNeighbors == 2) || aliveNeighbors == 3)) {
            //Any live cell with two or three live neighbours lives on to the next generation.
            //dead cells remain dead
            return LIVES;
        } else {
            return curr;
        }

       /* if((curr == dead)  && (aliveNeighbors == 3)) return lives;
        else if((curr == alive) && (aliveNeighbors >= 2) && (aliveNeighbors <= 3)) return lives;
        else return dies;*/
    }

    public static int[][] randomSeed() {
        int[][] tmp = new int[HEIGHT][WIDTH];
        Random rand = new Random();

        for(int i=0; i<tmp.length; i++) {
            for(int j=0; j<tmp[i].length; j++) {
                tmp[i][j] = rand.nextInt(2);
            }
        }
        return tmp;
    }

    public static int[][] gliders() {
        int[][] tmp = new int [HEIGHT][WIDTH];


        tmp[10+1][10+1] = 1;
        tmp[10+2][10+1] = 1;
        tmp[10+3][10+1] = 1;
        tmp[10+1][10+2] = 1;
        tmp[10+2][10+3] = 1;


        tmp[HEIGHT-2][WIDTH-3] = 1;
        tmp[HEIGHT-3][WIDTH-4] = 1;
        tmp[HEIGHT-4][WIDTH-4] = 1;
        tmp[HEIGHT-4][WIDTH-3] = 1;
        tmp[HEIGHT-4][WIDTH-2] = 1;


        tmp[HEIGHT-11][WIDTH-11] = 1;
        tmp[HEIGHT-11][WIDTH-12] = 1;
        tmp[HEIGHT-11][WIDTH-13] = 1;
        tmp[HEIGHT-12][WIDTH-11] = 1;
        tmp[HEIGHT-13][WIDTH-12] = 1;
        return tmp;
    }

    public static void run(int[][] world) {
        while(isRunning) {
            render(world);
            world = epoch(world);
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void render(int[][] grid) {
        clearScreen();
        System.out.println("Epochs: " + generations);
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == ALIVE) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        int[][] world = randomSeed();
        isRunning = true;
        run(world);

    }
}
