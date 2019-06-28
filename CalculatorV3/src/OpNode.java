public abstract class OpNode extends Node {
    //private char operator;
    protected Node lhs, rhs;

    protected OpNode(Node lhs, Node rhs) {
        //operator = op;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    //@Override
    /*public abstract double evaluate(); {
        switch(operator) {
            case '+': return lhs.evaluate() + rhs.evaluate();
            case '-': return lhs.evaluate() - rhs.evaluate();
            case '/': return lhs.evaluate() / rhs.evaluate();
            case '*': return lhs.evaluate() * rhs.evaluate();
            default: return 0;
        }
    }*/
}
