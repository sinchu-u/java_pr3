public class Calculator {
    private static void validate(double a, double b) throws InvalidInputException {
        if (Double.isNaN(a) || Double.isNaN(b)) {
            throw new InvalidInputException("Значення NaN недопустиме.");
        }
        if (Double.isInfinite(a) || Double.isInfinite(b)) {
            throw new InvalidInputException("Нескінченні значення недопустимі.");
        }
    }

    public static double add(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a + b;
    }

    public static double subtract(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a - b;
    }

    public static double multiply(double a, double b) throws InvalidInputException {
        validate(a, b);
        return a * b;
    }

    public static double divide(double a, double b) throws InvalidInputException {
        validate(a, b);
        if (b == 0) {
            throw new ArithmeticException("Ділити на нуль не можна!");
        }
        return a / b;
    }
}