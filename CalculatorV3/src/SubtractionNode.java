public class SubtractionNode extends OpNode {
    public SubtractionNode(Node lhs, Node rhs) {
        super(lhs, rhs);
    }

    @Override
    public double evaluate() {
        return lhs.evaluate() - rhs.evaluate();
    }
}
