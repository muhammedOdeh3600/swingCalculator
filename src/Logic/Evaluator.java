package Logic;

public class Evaluator {

    public static double evaluate(double a, double b, Operation op) throws CalculatorException {
        switch (op) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                if (b == 0) {
                    throw new CalculatorException("Cannot divide by 0");
                }
                return a / b;
            default:
                return b; // Default fallback if no operator was pending
        }
    }
}
