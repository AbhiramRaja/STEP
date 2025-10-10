public class CalculatorLab6 {
    interface MathOperation {
        int operate(int a, int b);
    }

    // static nested class for addition
    static class Operation {
        public static int add(int a, int b) {
            return a + b;
        }
    }

    public void doSubtraction(int a, int b) {
        // local inner class for subtraction
        class Subtract {
            int sub(int x, int y) { return x - y; }
        }
        Subtract s = new Subtract();
        System.out.println("Subtraction result: " + s.sub(a, b));
    }

    public void doMultiplication(int a, int b) {
        // anonymous inner class for multiplication
        MathOperation mul = new MathOperation() {
            @Override
            public int operate(int x, int y) {
                return x * y;
            }
        };
        System.out.println("Multiplication result: " + mul.operate(a, b));
    }

    public static void main(String[] args) {
        int a = 6, b = 3;
        System.out.println("Addition result: " + CalculatorLab6.Operation.add(a, b));

        CalculatorLab6 calc = new CalculatorLab6();
        calc.doSubtraction(a, b);
        calc.doMultiplication(a, b);
    }
}