public class Janitor extends Student {
    private String location;

    Janitor(String location,
            String id,
            String status,
            String name,
            String email) {
        super(id, status, name, email);
        this.location = location;
    }

    @Override
    public void sendEmail() {
        //super.sendEmail();
        System.out.println("my name is " + super.name + " and I clean the area " + location);

    }
}
