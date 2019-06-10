public class GameOfLife {
    private static boolean isRunning = false;
    private  static Universe universe;

    public static void run() {
        while(isRunning) {
            render();
            universe.epoch();

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void render() {
        clearScreen();
        System.out.println("Generation: " + universe.getGenerations());
        System.out.println(universe.toString());
    }

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        //make rules
        Rule[] rules = new Rule[5];
        rules[0] = new Rule(1, 2, "<", CellState.ALIVE, CellState.DEAD);
        rules[1] = new Rule(1, 3, ">", CellState.ALIVE, CellState.DEAD);
        rules[2] = new Rule(1, 3, "==", CellState.DEAD, CellState.ALIVE);
        rules[3] = new Rule(1, 2, "==", CellState.ALIVE, CellState.ALIVE);
        rules[4] = new Rule(1, 3, "==", CellState.ALIVE, CellState.ALIVE);
        //cerate universe
        universe = new Universe(20, 100, rules);
        //run
        isRunning = true;
        run();
    }
}
