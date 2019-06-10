public class Animal {
    protected String name;
    protected double speed;
    protected double strength;

    Animal(String name, double speed, double strength) {
        this.name = name;
        this.speed = speed;
        this.strength = strength;
    }

    protected void move() {
        System.out.println("Animal Moving with speed " + speed);
    }

    protected void attack() {
        System.out.println("Animal Attacking with strength" + strength);
    }
}
