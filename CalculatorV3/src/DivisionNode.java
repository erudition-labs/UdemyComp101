public class DivisionNode extends OpNode {
    public DivisionNode(Node lhs, Node rhs) {
        super(lhs, rhs);
    }

    @Override
    public double evaluate() {
        return lhs.evaluate() / rhs.evaluate();
    }
}
