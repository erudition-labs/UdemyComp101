public class GameOfLife {
    static boolean isRunning;


    public static void render(int[][] world) {
        clearScreen();
        for(int i=0; i<world.length; i++) {
            for(int j=0; j<world[i].length; j++) {
                if(world[i][j] == 1) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void run(Universe universe) {
        while(isRunning) {
            render(universe.getUniverse());
            universe.epoch();

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Universe universe = new Universe(100, 20);
        isRunning = true;
        run(universe);

    }
}
