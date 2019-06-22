public class Animal {
    protected String name;
    protected double speed;
    protected double strength;

    Animal(String name, double speed, double strength) {
        this.name = name;
        this.speed = speed;
        this.strength = strength;
    }

    Animal() {
        this.name = "Animal";
        this.speed = 5.2;
        this.strength = 6.8;
    }

    protected void move() {
        System.out.println(name + " has moved at a speed of" + speed);
    }

    protected void attack() {
        System.out.println(name + " attacked with strenght " + strength);
    }

}
