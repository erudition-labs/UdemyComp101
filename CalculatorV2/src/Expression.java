import java.util.Stack;

public class Expression {
    private Node root;
    private static String operators = new String("+-/*");

    public Expression(String exp) {
        Stack<Node> stack = new Stack();
        Node lhs, rhs, tmp;

        for(int i=0; i<exp.length(); i++) {
            if(!isOperator(exp.charAt(i))) {
                tmp = new ValueNode(Double.parseDouble(Character.toString(exp.charAt(i))));
                stack.push(tmp);
            } else {
                rhs = stack.pop();
                lhs = stack.pop();
                tmp = new OpNode(exp.charAt(i), lhs, rhs);
                stack.push(tmp);
            }
        }
        root = stack.peek();
        stack.pop();
    }


    private boolean isOperator(char op) {
        return operators.contains(String.valueOf(op));
    }

    public double evaluate() {
        return root.evaluate();
    }

   /*public void inorder() {
       inorder(root);
   }*/

    /*public void inorder(Node t) {
        if (t != null) {
            inorder(t.lhs());
            System.out.print(t.value() + " ");
            inorder(t.rhs());
        }
    }*/

}
