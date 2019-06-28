public class Calculator {


    public static void main(String[] args) {
        Expression exp = new Expression("415*2*+8+"); //(4 + 1) * (5 * 2)

        System.out.println(exp.evaluate());
    }
}
