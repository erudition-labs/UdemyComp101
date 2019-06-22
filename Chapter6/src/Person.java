import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Loveable {
    public abstract void hugMe();
};

public class Person implements Loveable, Comparable<Person> {
     String name;
     String email;
    private  int weight;

     protected Person(String n, String email, int weight) {
        name = n;
        this.email = email;
        this.weight = weight;
    }

    public void sendEmail() {
        System.out.println("HELLLLoo my name is" + name);
    }

    @Override
    public void hugMe() {
        System.out.println("HUGA");
    }

    @Override
    public int compareTo(Person o) {
         if(this.weight < o.weight) {
             return -1;
         }

         if(this.weight == o.weight) {
             return 0;
         }
        return 1;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        list.add(new Person(
                "Jow",
                "jow@jow.com", 2));
        list.add(new Person(
                "Jowe",
                "jowe@jow.com", 230));

        list.add(new Person(
                "Bill",
                "Bill@jow.com", 200));


        for(Person p : list) {
            System.out.print(p.weight + " ");
        }
        System.out.println();
        Collections.sort(list);

        for(Person p : list) {
            System.out.print(p.weight + " ");
        }
    }

}

