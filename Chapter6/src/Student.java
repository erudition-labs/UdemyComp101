

public class Student extends Person {
    private String id;
    private String status;

    Student(String id,
            String status,
            String name,
            String email) {
        super(name, email, 0);
        this.id = id;
        this.status = status;
        //System.out.println("Student constructor called");
    }


    public void sendEmail() {
        //super.sendEmail();
        System.out.println("my id is " + id);
    }

}
