public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Fido", 3.3, 5.7, "barks");
        Cat cat = new Cat("Idiot", .0001, .00000000001, "I'm stupid");
        Animal animal = new Animal("ben", 34, 55);

        dog.attack();
        dog.move();
        dog.speak();

        cat.attack();
        cat.move();
        cat.speak();

        animal.attack();
        animal.move();
    }
}
