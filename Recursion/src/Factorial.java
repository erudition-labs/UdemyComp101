public class Factorial {

    static void itrFactorial(int n) {
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + n + " is: " + fact + " Done Iteratively");
    }

    static int recFactorial(int n) {
        if(n == 0) return 1;
        else return(n * recFactorial(n-1));
    }

   /* 7! = 7 * 6! //7 * 6 * 5 *24
    6! = 6 * 5!  // 6 * 5 *24
    5! = 5 * 4! // 5 * 24
    4! = 4 * 3! //24
    3! = 3 * 2! //6
    2! = 2 * 1! //2
    1! = 1 * 0! //1
    0! = 1*/

    public static void main(String[] args) {
        itrFactorial(7);
        System.out.println("Factorial of " + 7 + "is: " + recFactorial(7) + " Done Recursively");
    }
}
