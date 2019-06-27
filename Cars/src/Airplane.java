public class Airplane extends Vehicle {

    Airplane(String model, String color) {
        super(color, model);
    }

    @Override
    public void drive() {
        System.out.println("Ship is moving");
    }

    @Override
    public void stop() {
        System.out.println("Ship is stopping");
    }
}