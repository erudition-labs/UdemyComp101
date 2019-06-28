public class ValueNode extends Node {
    private double value;

    ValueNode(double val) {
        value = val;
    }

    @Override
    public double evaluate() {
        return value;
    }
}
