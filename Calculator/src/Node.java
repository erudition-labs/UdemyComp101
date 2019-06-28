public class Node {
    private char operator;
    private double value;
    private Node lhs;
    private Node rhs;

    Node(char op, Node lhs, Node rhs) {
        operator = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    Node(double value) {
        operator = '#';
        this.lhs = null;
        this.rhs = null;
        this.value = value;
    }

    public double evaluate() {
        switch(operator) {
            case '#': return value;
            case '+': return lhs.evaluate() + rhs.evaluate();
            case '-': return lhs.evaluate() - rhs.evaluate();
            case '/': return lhs.evaluate() / rhs.evaluate();
            case '*': return lhs.evaluate() * rhs.evaluate();
            default: return value;
        }
    }

    public Node lhs() {
        return lhs;
    }

    public Node rhs() {
        return rhs;
    }

    public double value() {
        return value;
    }
}
