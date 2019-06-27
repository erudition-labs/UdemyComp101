public class Car extends Vehicle {
    int windows;

    Car(String model, String color, int windows) {
        super(color, model);
        this.windows = windows;
    }

    @Override
    public void drive() {
        System.out.println("Car is moving");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping");
    }
}
