import java.util.Random;

public class GameOfLife {
    static int[][] world;
    static boolean isRunning;
    final static int width = 10;
    final static int height = 10;

    public static void epoch() {

    }

    public static int fitness(int x, int y) {
        return 0;
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

    public static void run() {

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
        world = randomSeed();
        render(world);

    }
}
