public class GameOfLife {


    public static void main(String[] args) {
        Universe universe = new Universe(20, 100);
        System.out.println(universe.toString());
        //System.out.println(CellStates.ALIVE);
    }
}
