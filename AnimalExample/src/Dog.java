public class Dog extends Animal {
    private String sound;

    Dog(String name, double speed, double strength, String sound) {
        super(name, speed, strength);
        this.sound = sound;
    }

    public void speak() {
        System.out.println(sound);
    }
}
