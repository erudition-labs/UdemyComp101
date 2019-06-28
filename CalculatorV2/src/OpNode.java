public class OpNode extends Node {
    private char operator;
    private Node lhs, rhs;

    OpNode(char op, Node lhs, Node rhs) {
        operator = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public double evaluate() {
        switch(operator) {
            case '+': return lhs.evaluate() + rhs.evaluate();
            case '-': return lhs.evaluate() - rhs.evaluate();
            case '/': return lhs.evaluate() / rhs.evaluate();
            case '*': return lhs.evaluate() * rhs.evaluate();
            default: return 0;
        }
    }
}
