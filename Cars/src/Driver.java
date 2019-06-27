public class Driver {
    public static void main(String[] args) {
        Vehicle car = new Car("Tesla model", "black", 2);
        Vehicle plane = new Airplane("asdf", "blue");

        car.drive();
        car.stop();
        car.horn();

        plane.drive();
        plane.stop();
        plane.horn();
    }
}
