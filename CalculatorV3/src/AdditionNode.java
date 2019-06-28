public class AdditionNode extends OpNode {
    public AdditionNode(Node lhs, Node rhs) {
        super(lhs, rhs);
    }

    @Override
    public double evaluate() {
        return lhs.evaluate() + rhs.evaluate();
    }
}
