public class MultiplicationNode extends OpNode {

    public MultiplicationNode(Node lhs, Node rhs) {
        super(lhs, rhs);
    }

    @Override
    public double evaluate() {
        return lhs.evaluate() * rhs.evaluate();
    }
}
