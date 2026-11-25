import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("Введіть два числа:");
                double firstNum = numberInput();
                double secondNum = numberInput();

                System.out.println("Виберіть операцію:" +
                        "\n1. Додавання" +
                        "\n2. Віднімання" +
                        "\n3. Множення" +
                        "\n4. Ділення");
                int choice = choiceInput();

                switch (choice) {
                    case 1:
                        System.out.println("Результат: " + Calculator.add(firstNum, secondNum));
                        break;
                    case 2:
                        System.out.println("Результат: " + Calculator.subtract(firstNum, secondNum));
                        break;
                    case 3:
                        System.out.println("Результат: " + Calculator.multiply(firstNum, secondNum));
                        break;
                    case 4:
                        System.out.println("Результат: " + Calculator.divide(firstNum, secondNum));
                        break;
                    default:
                        System.out.println("Невідома операція!");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Помилка обчислення: " + e.getMessage());
            } catch (InvalidInputException e) {
                System.out.println("Некоректні вхідні дані: " + e.getMessage());
            } finally {
                System.out.println("Обробку запиту завершено.\n");
            }
        }
    }

    public static double numberInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Введене значення не є числом, спробуйте ще раз.");
            }
        }
    }

    public static int choiceInput() {
        while (true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введене значення не є числом, спробуйте ще раз.");
            }
        }
    }
}