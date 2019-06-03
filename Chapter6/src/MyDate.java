public class MyDate {
    private String day;
    private String month;
    private String year;

    public MyDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDayOfMonth() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }

    public static void main(String[] args) {
        MyDate date = new MyDate("29", "03", "1995");
        System.out.println(date.toString());
    }

}
