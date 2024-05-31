package mlc.methods.lab;

    import java.util.Scanner;

    public class MathOperator {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int number1 = Integer.parseInt(scanner.nextLine());
            char operator = scanner.nextLine().charAt(0);
            int number2 = Integer.parseInt(scanner.nextLine());
            print(operator, number1, number2);
        }

        private static void print(char operator, int num1, int num2) {
            double result = calc(operator, num1, num2);
            if (Math.floor(result) == Math.ceil(result)) {
                System.out.printf("%.0f", result);
            } else {
                System.out.printf("%.2f", result);
            }
        }

        private static double calc(char operator, int num1, int num2) {
            switch (operator) {
                case '+':
                    return num1 + num2;
                case '-':
                    return num1 - num2;
                case '*':
                    return num1 * num2;
                default:
                    return 1.0 * num1 / num2;
            }
        }
    }
