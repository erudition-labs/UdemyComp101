public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("Fido", 3.3, 5.7, "bark");
        Cat cat = new Cat("idiot", 3.3, 5.7, "meoowww");

        dog.attack();
        dog.move();
        dog.speak();

        cat.attack();
        cat.move();
        cat.speak();
    }
}
