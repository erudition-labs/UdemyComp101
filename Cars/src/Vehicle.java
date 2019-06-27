public abstract class Vehicle {
    private String color, model;

    Vehicle(String color, String model) {
        this.color = color;
        this.model = model;
    }

    public abstract void drive();
    public abstract void stop();

    public void horn() {
        System.out.println("Yeeeeeeet");
    }
}
